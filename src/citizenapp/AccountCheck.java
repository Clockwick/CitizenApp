package citizenapp;


import citizenapp.Module.CompleteHeader;
import citizenapp.Module.LoginForm;
import citizenapp.Payphone.Account.ConfirmPayBill;

import citizenapp.Payphone.Account.WhichAccount;
import citizenapp.Payphone.otherPhone;
import database.UserData;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arthris
 * 
 * 
 */

public class AccountCheck  implements EventHandler<ActionEvent>{
	
	private static final String css = AccountCheck.class.getResource("style/darkbutton.css").toExternalForm();
	private static double balance;
	private static Account ownAccount;
	
	private static boolean isPayPhone;
	private static boolean isOtherPhone;

	public static boolean isIsPayPhone() {
		return isPayPhone;
	}

	public static boolean isIsOtherPhone() {
		return isOtherPhone;
	}

	public AccountCheck(String firstName, String lastName, String accNum) {
		
	}

	@Override
	public void handle(ActionEvent event) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public static void display(int number,String firstName, String lastName, String accNum1, double money) throws FileNotFoundException {
		Stage stage = new Stage();
		stage.setResizable(false);
		balance = money;	
		UserData receiver = LoginForm.getUserkey().getUserData(LoginForm.getUserkey().key.get(WhichAccount.getQ()).getId());
		
		try {
			stage.initModality(Modality.APPLICATION_MODAL);
		} catch (Exception ex) {}
		
		AnchorPane mainPane = new AnchorPane();
		
		Text account = new Text("Account");
		VBox vbox = new VBox(20);
		account.setFont(Font.font("Ink Free", 33));
		Text nameOfAccount = new Text("Name of Account: " + firstName + " " + lastName);
		Text accountNo = new Text("Account No." + accNum1);
		Text password = new Text("Password: ");
		nameOfAccount.setFont(Font.font("Segoe UI", 16));
		accountNo.setFont(Font.font("Segoe UI", 16));
		password.setFont(Font.font("Segoe UI", 16));
		PasswordField passwordInput = new PasswordField();		
		passwordInput.setPromptText("Enter your password");
		passwordInput.setStyle("-fx-border-color: white;-fx-border-radius: 15px;-fx-background-color: transparent; -fx-text-fill: white;");			

		HBox hbox = new HBox(5);
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(password, passwordInput);
		HBox hbox1 = new HBox(10);
		hbox1.setAlignment(Pos.CENTER);
		Text t1 = new Text("Confirm");
		t1.getStyleClass().add("text");
		Button confirmBtn = new Button();
		confirmBtn.getStylesheets().add(css);
		confirmBtn.setGraphic(t1);
		confirmBtn.setOnAction(e -> {
			try {
				String pwS = passwordInput.getText();
				for (int i  = 0; i < Account.getAccountList().size(); i++) {
					if (pwS.equals(Account.getAccountList().get(i).getPassword())) {
						 if (!isPayPhone) {
							AccountPage a1 = new AccountPage(number, firstName, lastName, accNum1, money);
							a1.setAccount(ownAccount);
							a1.start(CompleteHeader.getStage());
							stage.close();
						} else {
							 stage.close();
							 if (!isOtherPhone) {
								 setOtherPhone(false);
								 ConfirmPayBill.display(number, accNum1, balance, CompleteHeader.getPhoneNumber(), Double.parseDouble(CompleteHeader.getUser1().getPhone().getPrice())); 
							 } else {
								 setOtherPhone(true);
								 ConfirmPayBill.display(number, accNum1, balance, CompleteHeader.getPhoneNumber(), Double.parseDouble(receiver.getPhone().getPrice()));
							 }
								 
						}
						 break;
					 } else {
						if (vbox.getChildren().size() < 6) {
							Text incorrectPw = new Text("Your password is incorrect");
							incorrectPw.setFont(Font.font("Segoe UI", 12));
							incorrectPw.setFill(Color.RED);
							vbox.getChildren().remove(hbox1);
							vbox.getChildren().addAll(incorrectPw, hbox1);
							break;
						}
					 }
			 }
						
			} catch (Exception ex) {
				Logger.getLogger(AccountCheck.class.getName()).log(Level.SEVERE, null, ex);
			}
		});
		stage.setOnCloseRequest(event -> {
			stage.close();
		});
		Text t2 = new Text("Cancel");
		t2.getStyleClass().add("text");
		Button cancelBtn = new Button();
		cancelBtn.getStylesheets().add(css);
		cancelBtn.setGraphic(t2);
		cancelBtn.setOnAction(e -> {
			stage.close();
		});
		hbox1.getChildren().addAll(confirmBtn, cancelBtn);
		VBox.setMargin(account, new Insets(0,0,0,0));
		vbox.getChildren().addAll(account, nameOfAccount, accountNo, hbox, hbox1);
		vbox.setAlignment(Pos.CENTER);
		Image img1 = new Image(new FileInputStream(CompleteHeader.getPATH_TO_BG3()));
		ImageView mainBg = new ImageView();
		mainBg.setImage(img1);
		mainBg.setFitWidth(400);
		mainBg.setFitHeight(350);
		
		vbox.setLayoutX(80);
		vbox.setLayoutY(30);
		mainPane.getChildren().addAll(mainBg, vbox);
		Scene scene = new Scene(mainPane, 400, 350);
		stage.setScene(scene);
		stage.setTitle("Account");
		stage.show();
		
	}

	
	public static void setAccount(Account a1) {
		ownAccount = a1;
	}
	
	public static void setPayphone(boolean poo) {
		isPayPhone = poo;
	}
	public static void setOtherPhone(boolean poo) {
		isOtherPhone = poo;
	}
	


}
