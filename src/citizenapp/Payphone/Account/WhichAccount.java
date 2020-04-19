/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.Payphone.Account;

import citizenapp.Account;
import citizenapp.AccountCheck;
import citizenapp.Module.CompleteHeader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author arthris
 */
public class WhichAccount {
	private static Stage window = new Stage();
	private static Scene scene1;
	//CSS
	private final static String SCROLL = "scroll-pane";
	private final static String css = WhichAccount.class.getResource("/citizenapp/style/ScrollBar.css").toExternalForm();
	private static int otherQ;
	private static boolean isForOther;

	public static int getOtherQ() {
		return otherQ;
	}

	public static void setOtherQ(int otherQ) {
		WhichAccount.otherQ = otherQ;
	}

	public static boolean isIsForOther() {
		return isForOther;
	}

	public static void setIsForOther(boolean isForOther) {
		WhichAccount.isForOther = isForOther;
	}
	
	public static void display() throws FileNotFoundException, Exception {
		//close before this page
		window.setResizable(false);
		 window.setOnCloseRequest(e -> {
			window.close();
		 });
		 isForOther = false;
		 
		 AnchorPane mainPane = new AnchorPane();
		 mainPane.setPrefWidth(600);
		 mainPane.setPrefWidth(450);
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setLayoutX(90.0);
		scrollPane.setLayoutY(181.25);
		scrollPane.setPrefWidth(440);
		scrollPane.setPrefHeight(95);
		scrollPane.getStyleClass().add(SCROLL);
		scrollPane.getStylesheets().add(css);
		scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		scrollPane.setOnMouseEntered(e -> scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED));
		scrollPane.setOnMouseExited(e -> scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER));
		//Vbox
		VBox vbox = new VBox();
		vbox.setMinWidth(Control.USE_PREF_SIZE);
		vbox.setMaxWidth(Control.USE_PREF_SIZE);
		vbox.setPrefWidth(285);
		AccountCheck.setPayphone(true);
		
		for (int i = 0; i < Account.getAccountBox().size(); i++) {
			Account.getAccountList().get(i).getNameText().setFont(Font.font("Neucha", 18));
			Account.getAccountList().get(i).getAccNumText().setFont(Font.font("Neucha", 18));
			Account.getAccountBox().get(i).setPrefWidth(432);
			Account.getAccountList().get(i).getNameText().setWrappingWidth(260);
			vbox.getChildren().add(Account.getAccountBox().get(i));
		}
		
		scrollPane.setContent(vbox);
		scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		 
		Text t1 = new Text("Choose your Account");
		t1.setFont(Font.font("Ink Free", 52));
		t1.setFill(Color.WHITE);
		t1.setLayoutX(150);
		t1.setLayoutY(80);
		t1.setWrappingWidth(300);
		t1.setTextAlignment(TextAlignment.CENTER);
		
		 //Primary Background
		Image img1 = new Image(new FileInputStream(CompleteHeader.getPATH_TO_BG3()));
		ImageView mainBg = new ImageView();
		mainBg.setImage(img1);
		mainBg.setFitWidth(600);
		mainBg.setFitHeight(450);
		
		mainPane.getChildren().addAll(mainBg, t1, scrollPane);
		 
		 Scene scene = new Scene(mainPane, 600, 450);
		 scene1 = scene;
		 window.setScene(scene1);
		 window.setTitle("Choose account");
		 try {
			window.initModality(Modality.APPLICATION_MODAL);	 
		 } catch (Exception ex) {}
		 window.show();
		 
	}
	public static void displayOther(int Q) throws FileNotFoundException, Exception {
		//close before this page
		 window.setOnCloseRequest(e -> {
			window.close();
		 });
		 isForOther = true;
		 otherQ = Q;
		 AnchorPane mainPane = new AnchorPane();
		 mainPane.setPrefWidth(600);
		 mainPane.setPrefWidth(450);
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setLayoutX(90.0);
		scrollPane.setLayoutY(181.25);
		scrollPane.setPrefWidth(440);
		scrollPane.setPrefHeight(95);
		scrollPane.getStyleClass().add(SCROLL);
		scrollPane.getStylesheets().add(css);
		scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		scrollPane.setOnMouseEntered(e -> scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED));
		scrollPane.setOnMouseExited(e -> scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER));
		//Vbox
		VBox vbox = new VBox();
		vbox.setMinWidth(Control.USE_PREF_SIZE);
		vbox.setMaxWidth(Control.USE_PREF_SIZE);
		vbox.setPrefWidth(285);
		AccountCheck.setPayphone(true);
		AccountCheck.setOtherPhone(true);
		
		for (int i = 0; i < Account.getAccountBox().size(); i++) {
			Account.getAccountList().get(i).getNameText().setFont(Font.font("Neucha", 18));
			Account.getAccountList().get(i).getAccNumText().setFont(Font.font("Neucha", 18));
			Account.getAccountBox().get(i).setPrefWidth(432);
			Account.getAccountList().get(i).getNameText().setWrappingWidth(260);
			vbox.getChildren().add(Account.getAccountBox().get(i));
		}
		
		scrollPane.setContent(vbox);
		scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		 
		Text t1 = new Text("Choose your Account");
		t1.setFont(Font.font("Ink Free", 52));
		t1.setFill(Color.WHITE);
		t1.setLayoutX(150);
		t1.setLayoutY(80);
		t1.setWrappingWidth(300);
		t1.setTextAlignment(TextAlignment.CENTER);
		
		 //Primary Background
		Image img1 = new Image(new FileInputStream(CompleteHeader.getPATH_TO_BG3()));
		ImageView mainBg = new ImageView();
		mainBg.setImage(img1);
		mainBg.setFitWidth(600);
		mainBg.setFitHeight(450);
		
		mainPane.getChildren().addAll(mainBg, t1, scrollPane);
		 
		 Scene scene = new Scene(mainPane, 600, 450);
		 scene1 = scene;
		 window.setScene(scene1);
		 window.setTitle("Choose account");
		 try {
			window.initModality(Modality.APPLICATION_MODAL);	 
		 } catch (Exception ex) {}
		 window.show();
		 
	}
	
	public static Scene getScene() {
		return scene1;
	}
	
	public static void close() {
		window.close();
	}
	
	public static int getQ() {
		return otherQ;
	}
	
}
