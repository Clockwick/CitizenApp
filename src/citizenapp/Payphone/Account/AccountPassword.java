/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.Payphone.Account;

import citizenapp.Account;
import citizenapp.Module.CompleteHeader;
import javafx.geometry.Insets;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author arthris
 */
public class AccountPassword {
	
	private static Stage window = new Stage();
	
	public static void display(String accNum) {
		
		Text t1 = new Text("The account that you want to pay by phone bill");
		t1.setFont(Font.font("Ink Free", 24));
		 HBox hbox = new HBox(5);
		 Text t2 = new Text("Account No. : " + accNum);
		 Text pw = new Text("Password : ");
		 PasswordField pwInput = new PasswordField();
		 pwInput.setPromptText("Enter the your password");
		 hbox.getChildren().addAll(pw, pwInput);
		 
		 Button confirmBtn = new Button("Confirm");
		 confirmBtn.setOnAction(e -> {
			 String pwS = pwInput.getText();
			 for (int i  = 0; i < Account.getAccountList().size(); i++) {
				 if (pwS.equals(Account.getAccountList().get(i).getPassword())) {
//					 ConfirmPayBill.display(Com , Account.getAccountList().get(i).getBalance(), CompleteHeader.getUser1().getPhone().getPhoneNumber(), CompleteHeader.getUser1().getPhone().getPrice());
					 break;
				 } else {
					 IncorrentPassword.display();
				 }
			 }
		});
		 Button cancelBtn = new Button("Cancel");
		 HBox hbox1 = new HBox(5);
		 hbox1.getChildren().addAll(confirmBtn, cancelBtn);
		 hbox1.setPadding(new Insets(0,0,0,40));
		 VBox vbox = new VBox(10);
		 vbox.getChildren().addAll(t1, t2, hbox, hbox1);
		 
		 
		 Scene scene = new Scene(vbox, 400, 300);
		 window.setScene(scene);
		 window.setTitle("Confirm Password");
		 window.showAndWait();
	}
}
