/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.Payphone;

import citizenapp.AccountCheck;
import citizenapp.Module.CompleteHeader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
	public static void display(String phoneNumber, double balance, double cost) {
		Stage stage = new Stage();
		phoneNumberS = phoneNumber;
		stage.setOnCloseRequest(e -> {
			e.consume();
			stage.close();
		});
		stage.initModality(Modality.APPLICATION_MODAL);
		VBox vbox = new VBox(20);
		HBox hbox = new HBox(10);
		
		Text t1 = new Text("Pay phone bills");
		t1.setFont(Font.font("Ink Free", 30));
		Button ownPhoneBtn = new Button("Own phone number");
		Button otherPhoneBtn = new Button("Other phone number");
		ownPhoneBtn.setStyle(IDLE_BUTTON_STYLE);
		ownPhoneBtn.setOnMouseEntered(e -> ownPhoneBtn.setStyle(HOVER_BUTTON_STYLE));
		ownPhoneBtn.setOnMouseExited(e -> ownPhoneBtn.setStyle(IDLE_BUTTON_STYLE));
		ownPhoneBtn.setOnAction(e -> {
			stage.close();
			AccountCheck.setPayphone(false);
			ownPhoneBtn.setStyle(ACTIVE_BUTTON_STYLE);
			ownPhone.display(CompleteHeader.getUser1().getPhone().getPhoneNumber(), balance, cost);
		});
		otherPhoneBtn.setStyle(IDLE_BUTTON_STYLE);
		otherPhoneBtn.setOnMouseEntered(e -> otherPhoneBtn.setStyle(HOVER_BUTTON_STYLE));
		otherPhoneBtn.setOnMouseExited(e -> otherPhoneBtn.setStyle(IDLE_BUTTON_STYLE));
		otherPhoneBtn.setOnAction(e -> {
			stage.close();
			AccountCheck.setPayphone(false);
			otherPhoneBtn.setStyle(ACTIVE_BUTTON_STYLE);
			otherPhone.display();
		});
		hbox.getChildren().addAll(ownPhoneBtn, otherPhoneBtn);
		hbox.setPadding(new Insets(0,0,0,40));

		
		vbox.getChildren().addAll(t1,hbox);
		vbox.setAlignment(Pos.CENTER);

		Scene scene = new Scene(vbox, 400, 300);
		stage.setScene(scene);
		stage.setTitle("Pay phone bills");
		stage.show();
			
	}
	
	
	
	
	
}
