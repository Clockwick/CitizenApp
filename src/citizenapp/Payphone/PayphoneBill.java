/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.Payphone;

import citizenapp.AccountCheck;
import citizenapp.Module.CompleteHeader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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

public class PayphoneBill {
	
	private static String phoneNumberS;
	private static final String IDLE_BUTTON_STYLE = "-fx-background-radius: 7em;-fx-min-width: 150px; -fx-min-height: 150px;-fx-max-width: 150px;-fx-max-height: 150px;-fx-background-color: transparent;-fx-border-color: #000;-fx-border-radius: 7em; -fx-font-family: FreesiaUPC; -fx-font-size: 20;";
	private static final String HOVER_BUTTON_STYLE = "-fx-background-radius: 7em;-fx-min-width: 150px; -fx-min-height: 150px;-fx-max-width: 150px;-fx-max-height: 150px;-fx-background-color: #878786;-fx-border-color: #000;-fx-border-radius: 7em; -fx-font-family: FreesiaUPC; -fx-font-weight: bold; -fx-font-size: 20;";
	private static final String ACTIVE_BUTTON_STYLE = "-fx-background-radius: 7em;-fx-min-width: 150px; -fx-min-height: 150px;-fx-max-width: 150px;-fx-max-height: 150px;-fx-background-color: #303030;-fx-border-color: #000;-fx-border-radius: 7em; -fx-font-family: FreesiaUPC; -fx-font-weight: bold; -fx-font-size: 20;";
	
	
	private static final String button_css = PayphoneBill.class.getResource("../style/PayPhoneBill.css").toExternalForm();
	public static void display(String phoneNumber, double balance, double cost) throws FileNotFoundException {
		AnchorPane mainPane = new AnchorPane();
		Stage stage = new Stage();
		stage.setResizable(false);
		phoneNumberS = phoneNumber;
		stage.setOnCloseRequest(e -> {
			e.consume();
			stage.close();
		});
	
		stage.initModality(Modality.APPLICATION_MODAL);
		//Background
//		Background background = new Background(new BackgroundFill(Color.rgb(200,200,200,0.5), CornerRadii.EMPTY, Insets.EMPTY));
		VBox vbox = new VBox(20);
		HBox hbox = new HBox(10);
		
		Text t1 = new Text("Pay phone bills");
		t1.setFill(Color.web("#2e2c29"));
		t1.setFont(Font.font("Montserrat", 30));
		Text ownPhoneText = new Text("Own phone number");
		Text otherPhoneText = new Text("Other phone number");
		ownPhoneText.getStyleClass().add("text");
		otherPhoneText.getStyleClass().add("text");
		Button ownPhoneBtn = new Button();
		Button otherPhoneBtn = new Button();
		ownPhoneBtn.setGraphic(ownPhoneText);
		ownPhoneText.setTextAlignment(TextAlignment.CENTER);
		ownPhoneText.setWrappingWidth(100);
		ownPhoneBtn.setOnAction(e -> {
			stage.close();
			AccountCheck.setPayphone(false);
			try {
				ownPhone.display(CompleteHeader.getUser1().getPhone().getPhoneNumber(), balance, cost);
			} catch (FileNotFoundException ex) {
				Logger.getLogger(PayphoneBill.class.getName()).log(Level.SEVERE, null, ex);
			}
		});
		otherPhoneText.setWrappingWidth(100);
		otherPhoneText.setTextAlignment(TextAlignment.CENTER);
		otherPhoneBtn.setGraphic(otherPhoneText);
		otherPhoneBtn.setOnAction(e -> {
			stage.close();
			AccountCheck.setPayphone(false);
			try {
				otherPhone.display();
			} catch (FileNotFoundException ex) {
				Logger.getLogger(PayphoneBill.class.getName()).log(Level.SEVERE, null, ex);
			}
		});
		
		
		hbox.getChildren().addAll(ownPhoneBtn, otherPhoneBtn);
		hbox.setPadding(new Insets(0,0,0,0));

		
		Image img1 = new Image(new FileInputStream(CompleteHeader.getPATH_TO_BG3()));
		ImageView mainBg = new ImageView();
		mainBg.setImage(img1);
		mainBg.setFitWidth(400);
		mainBg.setFitHeight(300);
		vbox.getChildren().addAll(t1,hbox);
		vbox.setAlignment(Pos.CENTER);
//		vbox.setBackground(background);
		vbox.setLayoutX(42);
		vbox.setLayoutY(30);

		mainPane.getChildren().addAll(mainBg, vbox);
		mainPane.getStylesheets().add(button_css);
		Scene scene = new Scene(mainPane, 400, 300);
		stage.setScene(scene);
		stage.setTitle("Pay phone bills");
		stage.show();
			
	}
	
	
	
	
	
}
