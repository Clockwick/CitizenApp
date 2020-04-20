/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.Transfer;

import citizenapp.AccountCheck;
import citizenapp.Module.CompleteHeader;
import citizenapp.Module.LoginForm;
import citizenapp.WithDraw.VerifyWithDraw;
import database.UserData;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
public class TransferPopUp {
	
	private final static String css = TransferPopUp.class.getResource("../style/darkbutton.css").toExternalForm();
	
	public static void display(int number, String firstName, String lastName, String accNum, double money) throws FileNotFoundException {
		AnchorPane mainPane = new AnchorPane();
		Stage stage = new Stage();
		stage.setResizable(false);
		stage.initModality(Modality.APPLICATION_MODAL);
		Text account = new Text("Transfer");
		VBox vbox = new VBox(20);
		account.setFont(Font.font("Ink Free", 33));
		String moneyS = String.format("%.2f", money);
		Text accountNo = new Text("Account No. : " + accNum);
		Text balanceText = new Text("Balance : " + moneyS + " baht");
		Text amount = new Text("Amount : ");
		Text to = new Text("To Account No. : ");
		to.setFont(Font.font("Segoe UI", 16));
		accountNo.setFont(Font.font("Segoe UI", 16));
		amount.setFont(Font.font("Segoe UI", 16));
		balanceText.setFont(Font.font("Segoe UI", 16));
		TextField toInput = new TextField();
		toInput.setPromptText("Enter the Account No.");
		toInput.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
			if (!newValue.matches("\\d{0,10}([\\.]\\d{0,4})?")) {
				toInput.setText(oldValue);
			}	
		});
		
		TextField amountInput = new TextField();		
		amountInput.setPromptText("Enter the Amount ");
		amountInput.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
			if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
				amountInput.setText(oldValue);
			}
		});
		
		HBox hbox = new HBox(5);
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(amount, amountInput);
		HBox hbox1 = new HBox(5);
		hbox1.setAlignment(Pos.CENTER);
		hbox1.getChildren().addAll(to, toInput);
		HBox hbox2 = new HBox(10);
		hbox2.setAlignment(Pos.CENTER);
		Button confirmBtn = new Button("Confirm");
		confirmBtn.setOnAction(e -> {
			try {
				String accNumTransfer = toInput.getText();
				double amountD = Double.parseDouble(amountInput.getText());
					
				if (money - amountD >= 0) {
					int i;
					if (! accNumTransfer.equals(CompleteHeader.getUser1().getAccountList().get(number).getAccountNumber())) {
					for (i = 0; i < LoginForm.getUserkey().key.size(); i++)  {
						UserData tempUser = LoginForm.getUserkey().key.get(i).ReadData();
						for (int j = 0; j < tempUser.getAccountList().size(); j++) {
							if (accNumTransfer.equals(tempUser.getAccountList().get(j).getAccountNumber())) {
								
								if (CompleteHeader.getUser1().getId().equals(tempUser.getId())) {
//									System.out.println("Same ID Transfer");
									SuccessTransfer.display(number, firstName, lastName, accNum, accNumTransfer, money, amountD);									     CompleteHeader.getUser1().getAccountList().get(j).setBalance(CompleteHeader.getUser1().getAccountList().get(j).getBalance() + amountD);
									CompleteHeader.getUser1().WriteData(CompleteHeader.getDATAPATH() + tempUser.getId());
									
								} else {
//									System.out.println("Different ID Transfer");
									SuccessTransfer.display(number, firstName, lastName, accNum, accNumTransfer, money, amountD);	
//									System.out.println(LoginForm.getUserkey().key.get(i).ReadData().getAccountList().get(j).getBalance());
									tempUser.getAccountList().get(j).setBalance(tempUser.getAccountList().get(j).getBalance() + amountD);
//									System.out.println("From Temp: " + tempUser.getAccountList().get(j).getBalance());

									tempUser.WriteData(CompleteHeader.getDATAPATH() + tempUser.getId());
//									System.out.println(LoginForm.getUserkey().key.get(i).ReadData().getAccountList().get(j).getBalance());
								}
								
								i = LoginForm.getUserkey().key.size() + 1;
								j = tempUser.getAccountList().size() + 1;
							} 
						}
					}
					if (i == LoginForm.getUserkey().key.size()) {
						NotFoundUserTransfer.display();
					}
				} else {
					SameAccountTransfer.display();
				}
				
				} else {
					FailTransfer.display();
				}
			} catch (Exception ex) {
				Logger.getLogger(AccountCheck.class.getName()).log(Level.SEVERE, null, ex);
			}
		});
		Button cancelBtn = new Button("Cancel");
		cancelBtn.setOnAction(e -> {
			stage.close();
		});
		hbox2.getChildren().addAll(confirmBtn, cancelBtn);
		VBox.setMargin(account, new Insets(0,0,0,0));
		vbox.getChildren().addAll(account, accountNo, balanceText, hbox1, hbox, hbox2);
		vbox.setAlignment(Pos.CENTER);
		vbox.getStylesheets().add(css);
		
		Image img1 = new Image(new FileInputStream(CompleteHeader.getPATH_TO_BG3()));
		ImageView mainBg = new ImageView();
		mainBg.setImage(img1);
		mainBg.setFitWidth(400);
		mainBg.setFitHeight(300);
	
		vbox.setLayoutX(60);
		vbox.setLayoutY(0);
		
		mainPane.getChildren().addAll(mainBg, vbox);
		
		Scene scene = new Scene(mainPane, 400, 300);
		stage.setScene(scene);
		stage.setTitle("Account");
		stage.showAndWait();	
	}
}
