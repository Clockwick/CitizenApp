/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.WithDraw;

import citizenapp.Account;
import citizenapp.AccountCheck;
import citizenapp.AccountPage;
import citizenapp.Module.RoundButton;
import citizenapp.Log;
import citizenapp.Module.CompleteHeader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 *
 * @author arthris
 */
public class SuccessWithDraw {

	private static Stage window = new Stage();
	private static double totalMoney;
	
	private static String firstName1;
	private static String lastName1;
	private static String accNum1;
	private static int number1;
	
	public static void display(int number, String firstName,String lastName, String accNum, double totalAmount, double withdraw) throws FileNotFoundException {
		AnchorPane mainPane = new AnchorPane();
		number1 = number;
		totalMoney = totalAmount - withdraw;
		firstName1 = firstName;
		lastName1 = lastName;
		accNum1 = accNum;
		//Stage
		try {
			window.initModality(Modality.APPLICATION_MODAL);	
		} catch (Exception ex) {}
		
		
		
		window.setOnCloseRequest(e -> {
			try {
				e.consume();
				closeProgram();
			} catch (Exception ex) {
				Logger.getLogger(SuccessWithDraw.class.getName()).log(Level.SEVERE, null, ex);
			}
		});
		
		VBox vbox = new VBox(20);

		//Date
		Locale locale = new Locale("en", "TH");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy h:mm a :", locale);
		String date = dateFormat.format(new Date());

		//Cost format
		String costFormat = "You have withdrawed " + withdraw + " baht from Account No." + accNum;

		//Log Message
//		CompleteHeader.getUser1().getLogList().add(new Log(date, costFormat)); Error
//		Log.add(new Log(date, costFormat));
		CompleteHeader.getUser1().getLogy().add(new Pair<>(date, costFormat));
		//Correct Image
		Image correctPic = new Image(new FileInputStream("src/citizenapp/img/correct.png"));
		ImageView correctImg = new ImageView();
		correctImg.setImage(correctPic);

		Text t1 = new Text("Successful withdrawing of money");
		Text t2 = new Text("Name of Account : " + firstName);
		Text t3 = new Text("Account No." + accNum);
		Text t4 = new Text("Withdrawing money : " + totalAmount + " baht");
		Text t5 = new Text("Total money : " + String.format("%.2f", totalMoney) + " baht");
		t1.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
		t2.setFont(Font.font("FreesiaUPC", 22));
		t3.setFont(Font.font("FreesiaUPC", 22));
		t4.setFont(Font.font("FreesiaUPC", 22));
		t5.setFont(Font.font("FreesiaUPC", 22));
		
//		Button finishbtn = new Button("Finish");
		
		VBox.setMargin(correctImg, new Insets(0,0,0,0));
		VBox.setMargin(t1, new Insets(-40,0,0,0));
		
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(correctImg, t1,t2,t3,t4,t5);
		
		
		
		Image img1 = new Image(new FileInputStream(CompleteHeader.getPATH_TO_BG3()));
		ImageView mainBg = new ImageView();
		mainBg.setImage(img1);
		mainBg.setFitWidth(400);
		mainBg.setFitHeight(300);
	
		vbox.setLayoutX(82);
		vbox.setLayoutY(5);
		
		mainPane.getChildren().addAll(mainBg, vbox);

		Scene scene = new Scene(mainPane, 400, 300);
		window.setScene(scene);
		window.setTitle("Success Withdrawing");
		window.showAndWait();
			
		
	}

	public static void closeProgram() throws Exception {
		VerifyWithDraw.setCountdown(false);
		CompleteHeader.getUser1().getAccountList().get(number1).setBalance(totalMoney);
		CompleteHeader.getUser1().WriteData(CompleteHeader.getDATAPATH() + CompleteHeader.getUser1().getId());
		AccountPage a2 = new AccountPage(number1, firstName1, lastName1, accNum1, totalMoney); 
		a2.start(AccountPage.getStage());
		AccountPage.getAccount().setBalance(totalMoney);
		window.close();

		
	}
}
