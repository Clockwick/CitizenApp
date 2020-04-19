package citizenapp.WithDraw;

import citizenapp.AccountCheck;
import citizenapp.AccountPage;
import citizenapp.Module.CompleteHeader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WithDrawPopUp implements EventHandler<ActionEvent>{
	
	private final static String css = WithDrawPopUp.class.getResource("../style/darkbutton.css").toExternalForm();
	@Override
	public void handle(ActionEvent event) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public static void display(int number, String firstName, String lastName, String accNum, double money) throws FileNotFoundException {
		Stage stage = new Stage();
		stage.setResizable(false);
		AnchorPane mainPane = new AnchorPane();
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
		amountInput.setStyle("-fx-border-color: white;-fx-border-radius: 15px;-fx-background-color: transparent; -fx-text-fill: white;");
		amountInput.setPromptText("Enter the Amount");
		amountInput.textProperty().addListener(new ChangeListener<String>() {
            	@Override
            	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    amountInput.setText(oldValue);
                }
           	 }
       		 });
		HBox hbox = new HBox(5);
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(amount, amountInput);
		HBox hbox1 = new HBox(10);
		hbox1.setAlignment(Pos.CENTER);
		Text t1 = new Text("Confirm");
		Button confirmBtn = new Button();
		confirmBtn.setGraphic(t1);
		confirmBtn.getStyleClass().add("button");
		t1.getStyleClass().add("text");
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
			} catch (Exception ex) {}
		});
		Text t2 = new Text("Cancel");
		Button cancelBtn = new Button();
		cancelBtn.getStyleClass().add("button");
		t2.getStyleClass().add("text");
		cancelBtn.setGraphic(t2);
		cancelBtn.setOnAction(e -> {
			e.consume();
			stage.close();
		}
		);
		hbox1.getChildren().addAll(confirmBtn, cancelBtn);
		VBox.setMargin(account, new Insets(0,0,0,0));
		vbox.getChildren().addAll(account, nameOfAccount, accountNo, balanceText, hbox, hbox1);
		vbox.getStylesheets().add(css);
		vbox.setAlignment(Pos.CENTER);
		
		Image img1 = new Image(new FileInputStream(CompleteHeader.getPATH_TO_BG3()));
		ImageView mainBg = new ImageView();
		mainBg.setImage(img1);
		mainBg.setFitWidth(400);
		mainBg.setFitHeight(300);
	
		vbox.setLayoutX(80);
		vbox.setLayoutY(5);
		
		mainPane.getChildren().addAll(mainBg, vbox);
		mainPane.getStylesheets().add(css);
		Scene scene = new Scene(mainPane, 400, 300);
		
		stage.setScene(scene);
		stage.setTitle("Account");
		stage.show();	
	}

	
	

	
}
