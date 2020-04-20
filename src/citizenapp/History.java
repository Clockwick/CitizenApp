/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp;

import citizenapp.Module.CompleteHeader;
import java.io.FileInputStream;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Pair;

/**
 *
 * @author arthris
 */
public class History {

	private static Scene sceneZ;
	
	private final static String css = History.class.getResource("style/ScrollBar.css").toExternalForm();
	private final static String SCROLL = "scroll-pane";


	public History() throws Exception {
		start();
	}
	public static void start() throws Exception {
		Log.getLogList().clear();
		
		HBox nameHBox = new HBox();
		Label fullNameLabel = new Label(CompleteHeader.getFullName());
		fullNameLabel.setTextFill(Color.WHITE);
		fullNameLabel.setFont(Font.font("MV Boli", 18));
		fullNameLabel.setTextAlignment(TextAlignment.RIGHT);
		nameHBox.setMinWidth(Control.USE_PREF_SIZE);
		nameHBox.setMinHeight(Control.USE_PREF_SIZE);
		nameHBox.setMaxWidth(Control.USE_PREF_SIZE);
		nameHBox.setMaxHeight(Control.USE_PREF_SIZE);
		nameHBox.setPrefWidth(300);
		nameHBox.setPrefHeight(30);
		nameHBox.setLayoutX(465);
		nameHBox.setLayoutY(40);
		nameHBox.getChildren().add(fullNameLabel);
		nameHBox.setAlignment(Pos.CENTER_RIGHT);
		AnchorPane mainPane = new AnchorPane();
		Rectangle mainRec = new Rectangle();
		mainRec.setStrokeWidth(0.5);
		mainRec.setFill(Color.rgb(155,155,155,0.5));
		mainRec.setArcWidth(30);
		mainRec.setArcHeight(30);
		mainRec.setStroke(Color.rgb(211, 209, 209));
		
		mainRec.setWidth(672);
		mainRec.setHeight(408);
		mainRec.setLayoutX(63);
		mainRec.setLayoutY(143);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setMinWidth(Control.USE_PREF_SIZE);
		scrollPane.setMinHeight(Control.USE_PREF_SIZE);
		scrollPane.setMaxWidth(Control.USE_PREF_SIZE);
		scrollPane.setMaxHeight(Control.USE_PREF_SIZE);
		scrollPane.setPrefWidth(613);
		scrollPane.setPrefHeight(369);
		scrollPane.setLayoutX(92);
		scrollPane.setLayoutY(164);
		scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
		scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		scrollPane.getStyleClass().add(SCROLL);
		scrollPane.getStylesheets().add(css);
		
		
		
		System.out.println("Logy size : " + CompleteHeader.getUser1().getLogy().size());
		System.out.println("Log size : " + Log.getLogList().size());
		VBox vbox = new VBox(5);
		vbox.getChildren().clear();
		vbox.setMinWidth(Control.USE_PREF_SIZE);
		vbox.setMaxWidth(Control.USE_PREF_SIZE);
		vbox.setPrefWidth(600);
		vbox.setStyle("-fx-background-color: transparent;");
		//Pull from Pair String
		for (int i = 0; i < CompleteHeader.getUser1().getLogy().size(); i++) {
			String timeString = CompleteHeader.getUser1().getLogy().get(i).getKey();
			String detailString = CompleteHeader.getUser1().getLogy().get(i).getValue();
			Log.add(new Log(timeString, detailString));
			System.out.println(timeString);
			System.out.println(detailString);
			
		}
		for (int i = 0; i < Log.getLogList().size(); i++) {
			vbox.getChildren().add(Log.getLogList().get(i).active());
		}
		
		scrollPane.setContent(vbox);
		
		//Empty
		Text noList = new Text("No history lists yet.");
		noList.setFill(Color.WHITE);
		noList.setFont(Font.font("Mv Boli", 36));
		noList.setLayoutX(220);
		noList.setLayoutY(340);

		//Primary Background
		Image img1 = new Image(new FileInputStream(CompleteHeader.getPATH_TO_BG1()));
		ImageView mainBg = new ImageView();
		mainBg.setImage(img1);
		mainBg.setFitWidth(800);
		mainBg.setFitHeight(600);
		//Secondary Background
		Image img2 = new Image(new FileInputStream(CompleteHeader.getPATH_TO_BG2()));
		ImageView secondBg = new ImageView();
		secondBg.setFitWidth(600);
		secondBg.setFitHeight(450);
		secondBg.setLayoutX(-75);
		secondBg.setLayoutY(-240);
		Rectangle clip = new Rectangle(secondBg.getFitWidth(), secondBg.getFitHeight() - 75);
		clip.setArcWidth(300);
		clip.setArcHeight(300);
		secondBg.setClip(clip);
		secondBg.setImage(img2);
		secondBg.setEffect(new DropShadow(20, Color.GRAY));
		secondBg.setOpacity(0.8);
		mainPane.getChildren().addAll(mainBg, secondBg, CompleteHeader.getLogo(), CompleteHeader.getNavbar(), CompleteHeader.getTopRight(),nameHBox, mainRec, scrollPane);
		
		if (Log.getLogList().isEmpty()) {
			mainPane.getChildren().add(noList);
		} else {
			mainPane.getChildren().remove(noList);
		}
		
		Scene scene = new Scene(mainPane, 800, 600);
		sceneZ = scene;
		
	}
	
	public static Scene getScene() {
		return sceneZ;
	}
	
	
}
