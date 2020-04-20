/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.Payphone;

import citizenapp.History;
import citizenapp.Log;
import citizenapp.Module.CompleteHeader;
import citizenapp.Module.LoginForm;
import citizenapp.Payphone.Account.WhichAccount;
import database.UserData;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Date;
import java.util.Locale;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.util.Pair;

/**
 *
 * @author arthris
 */
public class SuccessPayphone {

	
	public static void display(int number, double cost, String otherPhoneNum) throws FileNotFoundException, Exception {
		AnchorPane mainPane = new AnchorPane();
		UserData sender = CompleteHeader.getUser1();
		UserData receiver = LoginForm.getUserkey().getUserData(LoginForm.getUserkey().key.get(WhichAccount.getQ()).getId());
		System.out.println(receiver.toString());
		Stage stage = new Stage();
		stage.setResizable(false);
		stage.initModality(Modality.APPLICATION_MODAL);
		//Date
		Locale locale = new Locale("en", "TH");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy h:mm a :", locale);
		String date = dateFormat.format(new Date());
		DateFormat dateformatOne = new SimpleDateFormat("dd MMM Y");
		Date date1= new Date();
		date1.setMonth(date1.getMonth() + 1);
		String dateOne = dateformatOne.format(date1);
		//Cost format
		String costFormat;
		if (!WhichAccount.isIsForOther()) {
			costFormat = "You have paid for your phone bill for " + cost + " baht";
		} else {
			costFormat = "You have paid for your phone bill for " + cost + " baht to Phone Number " + otherPhoneNum;
		}
			
		//Log Message
//		CompleteHeader.getUser1().getLogList().add(new Log(date, costFormat));
		CompleteHeader.getUser1().getLogy().add(new Pair<>(date, costFormat));

		//VBox
		VBox vbox = new VBox(20);
		stage.setOnCloseRequest(e -> stage.close());

		//Correct Image
		Image correctPic = new Image(new FileInputStream("src/citizenapp/img/correct.png"));
		ImageView correctImg = new ImageView();
		correctImg.setImage(correctPic);
		Text t1 = new Text("Phone bill payment is successful");
		t1.setFont(Font.font("Segoe UI", FontWeight.BOLD,20));
		Button finishBtn = new Button("Finish");
		finishBtn.setOnAction(e -> {
			sender.getAccountList().get(number).setBalance(sender.getAccountList().get(number).getBalance() - cost);
			receiver.getPhone().setBillingDate(dateOne);
			sender.WriteData(CompleteHeader.getDATAPATH() + sender.getId());
			receiver.WriteData(CompleteHeader.getDATAPATH() + receiver.getId());
			e.consume();
			WhichAccount.close();
			stage.close();
		});
		
		vbox.getChildren().addAll(correctImg, t1, finishBtn);
		vbox.setAlignment(Pos.CENTER);
		
		Image img1 = new Image(new FileInputStream(CompleteHeader.getPATH_TO_BG3()));
		ImageView mainBg = new ImageView();
		mainBg.setImage(img1);
		mainBg.setFitWidth(400);
		mainBg.setFitHeight(300);
	
		vbox.setLayoutX(60);
		vbox.setLayoutY(25);
		
		mainPane.getChildren().addAll(mainBg, vbox);
		Scene scene = new Scene(vbox, 400, 300);
		stage.setScene(scene);
		stage.setTitle("Successful Pay Phone Bills");
		stage.show();
	}
	
	
}
