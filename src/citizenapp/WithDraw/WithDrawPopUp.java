package citizenapp.WithDraw;

import citizenapp.AccountCheck;
import citizenapp.AccountPage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WithDrawPopUp implements EventHandler<ActionEvent>{
	@Override
	public void handle(ActionEvent event) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public static void display(int number, String firstName, String lastName, String accNum, double money) {
		Stage stage = new Stage();
		stage.setOnCloseRequest(e -> stage.close());
		stage.initModality(Modality.APPLICATION_MODAL);
		Text account = new Text("Withdraw");
		VBox vbox = new VBox(20);
		account.setFont(Font.font("Ink Free", 33));
		String moneyS = String.format("%.2f", money);
		Text nameOfAccount = new Text("Name of Account: " + firstName + " " + lastName);
		Text accountNo = new Text("Account No." + accNum);
		Text balanceText = new Text("Balance : " + moneyS + " baht");
		Text amount = new Text("Amount : ");
		nameOfAccount.setFont(Font.font("Segoe UI", 16));
		accountNo.setFont(Font.font("Segoe UI", 16));
		amount.setFont(Font.font("Segoe UI", 16));
		balanceText.setFont(Font.font("Segoe UI", 16));
		TextField amountInput = new TextField();		
		amountInput.setPromptText("Enter the Amount");
		amountInput.textProperty().addListener(new ChangeListener<String>() {
            	@Override
            	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    amountInput.setText(oldValue);
                }
           	 }
       		 });
//		double withdraw = Double.parseDouble(amountInput.getText());
//		double withdraw1 = 2000;
		
		HBox hbox = new HBox(5);
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(amount, amountInput);
		HBox hbox1 = new HBox(10);
		hbox1.setAlignment(Pos.CENTER);
		Button confirmBtn = new Button("Confirm");
		confirmBtn.setOnAction(e -> {
			try {
				
				double withdraw = Double.parseDouble(amountInput.getText());
				if (money - withdraw >= 0) {
					VerifyWithDraw.setCountdown(true);
					VerifyWithDraw.display(number, firstName, lastName, accNum, money, withdraw);
					stage.close();
					
					
				} else {
					stage.close();
					InsufficientWithDraw.display(firstName, accNum, money);

				}
				
				
			} catch (Exception ex) {
				Logger.getLogger(AccountCheck.class.getName()).log(Level.SEVERE, null, ex);
			}
		});
		Button cancelBtn = new Button("Cancel");
		cancelBtn.setOnAction(e -> {
			e.consume();
			stage.close();
			}
		);
		hbox1.getChildren().addAll(confirmBtn, cancelBtn);
		VBox.setMargin(account, new Insets(0,0,20,0));
		vbox.getChildren().addAll(account, nameOfAccount, accountNo, balanceText, hbox, hbox1);
		vbox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(vbox, 400, 300);
		stage.setScene(scene);
		stage.setTitle("Account");
		stage.show();	
	}

	
	

	
}
