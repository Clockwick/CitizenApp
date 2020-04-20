/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.Payphone.Account;

import citizenapp.Account;
import citizenapp.AccountCheck;
import citizenapp.Module.CompleteHeader;
import citizenapp.Module.LoginForm;
import citizenapp.Payphone.InsuffPayphone;
import citizenapp.Payphone.NoExistPayphone;
import citizenapp.Payphone.PayAlready;
import citizenapp.Payphone.SuccessPayphone;
import citizenapp.Payphone.otherPhone;
import database.UserData;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author arthris
 */
public class ConfirmPayBill {
	
	private static final String css = ConfirmPayBill.class.getResource("../../style/darkbutton.css").toExternalForm();
	
	public static void display(int number, String accNum, double balance, String phoneNumber, double price) throws FileNotFoundException {
		UserData thisUser = CompleteHeader.getUser1();
		UserData otherUser = LoginForm.getUserkey().getUserData(LoginForm.getUserkey().key.get(WhichAccount.getQ()).getId());
		Stage window =  new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		
		AnchorPane mainPane = new AnchorPane();
		//VBox
		VBox vbox = new VBox(5);
		
		Date dateNow = new Date();
		 
		//Text
		Text t = new Text("Are you sure to pay the bill?");
		t.setFont(Font.font("Ink Free", 24));
		//Account No.
		Text accNumText = new Text("Account No. : " + accNum);
		
		//Balance
		Text balanceText = new Text("Balance : " + balance + " baht");
		
		//Text
		Text t1 = new Text("You want to pay this phone bill?");
		Text phoneText;
		Text priceText;
		//Phone number
		if (WhichAccount.isIsForOther()) {
			phoneText = new Text("Phone number : " + otherPhone.getOtherPhoneNum());
			priceText = new Text("Price : " + otherUser.getPhone().getPrice() + " baht");
		}
		else {
			phoneText = new Text("Phone number : " + phoneNumber);
			priceText = new Text("Price : " + price + " baht");
		}
		
		
		//HBox
		HBox hbox = new HBox(5);
		Button confirmBtn = new Button("Confirm");
		confirmBtn.setOnAction(e -> {
			double result = balance - price;
			try {
				int i;
				for (i = 0; i < Account.getAccountList().size(); i++) {
					if (accNum.equals(Account.getAccountList().get(i).getAccNum())) {
						System.out.println("Account Found!!" + result);
						
						if (result >= 0) {
							if (AccountCheck.isIsOtherPhone()) {
								
								if (otherUser.getPhone().getDate().getYear() ==  dateNow.getYear()) { // Same year
									
									if (otherUser.getPhone().getDate().getMonth() == dateNow.getMonth()) { //Same Month
										
										if (otherUser.getPhone().getDate().getDate() - dateNow.getDate() >  7) { 
											PayAlready.setMe(false);
											PayAlready.display();
										} else {
											SuccessPayphone.display(number, price, otherPhone.getOtherPhoneNum());
									}
									} else /*Not Same Month */ {
										
										if ((otherUser.getPhone().getDate().getDate() + (otherUser.getPhone().getDate().getMonth() * 30)) - (dateNow.getDate() + (dateNow.getMonth() * 30)) > 7)					{
											
											PayAlready.setMe(false);
											PayAlready.display();
			
										} else {
												SuccessPayphone.display(number, price, otherPhone.getOtherPhoneNum());
								
										}
									}
								} else {
									if (dateNow.getMonth() == 12 && otherUser.getPhone().getDate().getMonth() == 1) {
											
										if ((otherUser.getPhone().getDate().getDate() + 365) - (dateNow.getDate() + 334) > 7) {
												
											PayAlready.setMe(false);
											PayAlready.display();
										} else {
											
											SuccessPayphone.display(number, price, otherPhone.getOtherPhoneNum());
										}
									} else {
											
										PayAlready.setMe(false);
										PayAlready.display();
											
									}
								}
							}
							else {
								System.out.println("Check error : " + otherUser.getPhone().getDate().getYear());
								if (otherUser.getPhone().getDate().getYear() ==  dateNow.getYear()) { // Same year
									
									if (otherUser.getPhone().getDate().getMonth() == dateNow.getMonth()) { //Same Month
										if (otherUser.getPhone().getDate().getDate() - dateNow.getDate() >  7) { 
											PayAlready.setMe(true);
											PayAlready.display();
										} else {
										SuccessPayphone.display(number, price, otherPhone.getOtherPhoneNum());
									}
									} else /*Not Same Month */ {
										if ((otherUser.getPhone().getDate().getDate() + (otherUser.getPhone().getDate().getMonth() * 30)) - (dateNow.getDate() + (dateNow.getMonth() * 30)) > 7)					{
											PayAlready.setMe(true);
											PayAlready.display();
										} else {
											
											SuccessPayphone.display(number, price, otherPhone.getOtherPhoneNum());
										}
									}
								} else {
									if (dateNow.getMonth() == 12 && otherUser.getPhone().getDate().getMonth() == 1) {
										if ((otherUser.getPhone().getDate().getDate() + 365) - (dateNow.getDate() + 334) > 7) {
											PayAlready.setMe(true);
											PayAlready.display();
										} else {
											SuccessPayphone.display(number, price, otherPhone.getOtherPhoneNum());
										}
									} else {
										PayAlready.setMe(true);
										PayAlready.display();
									}
								}
							}
							}
						else {
							
							InsuffPayphone.display();
							break;
						}

					} 
				}  
				i = Account.getAccountList().size() + 1;
				if (i == Account.getAccountList().size()) {
					NotFoundAccount.display();
				}
					
			}
				
			catch (Exception ex) {
				Logger.getLogger(ConfirmPayBill.class.getName()).log(Level.SEVERE, null, ex);
			} window.close();
		});
		Button cancelBtn = new Button("Cancel");
		cancelBtn.setOnAction(e -> {
			e.consume();
			window.close();
		});
		hbox.setPadding(new Insets(0,0,0,40));
		hbox.getChildren().addAll(confirmBtn, cancelBtn);
		
		vbox.getChildren().addAll(t, accNumText, balanceText, t1, phoneText, priceText, hbox);
		vbox.setAlignment(Pos.CENTER);
		
		vbox.setAlignment(Pos.CENTER);
		vbox.setLayoutX(55);
		vbox.setLayoutY(45);
		
		Image img1 = new Image(new FileInputStream(CompleteHeader.getPATH_TO_BG3()));
		ImageView mainBg = new ImageView();
		mainBg.setImage(img1);
		mainBg.setFitWidth(400);
		mainBg.setFitHeight(300);
		vbox.getStylesheets().add(css);
		
		mainPane.getChildren().addAll(mainBg, vbox);
		
		
		Scene scene = new Scene(mainPane, 400, 300);
		window.setScene(scene);
		window.setTitle("Confirm Pay phone bill");
		window.show();
		
	}
	
	
	
}
