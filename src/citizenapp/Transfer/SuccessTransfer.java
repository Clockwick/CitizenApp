/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.Transfer;

import citizenapp.Account;
import citizenapp.AccountPage;
import citizenapp.Log;
import citizenapp.Module.CompleteHeader;
import citizenapp.Module.LoginForm;
import citizenapp.WithDraw.SuccessWithDraw;
import static citizenapp.WithDraw.SuccessWithDraw.closeProgram;
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
public class SuccessTransfer {
	private static Stage window = new Stage();
	private static double totalMoney;
	private static String firstName1;
	private static String lastName1;
	private static String accNum1;
	private static String accNumTransfer1;
	private static double transfer1;
	private static int number1;
public static void display(int number, String firstName, String lastName, String accNum, String accNumTransfer,double totalAmount, double transfer) throws FileNotFoundException {
	
		AnchorPane mainPane = new AnchorPane();
		window.setResizable(false);
		//Stage
		number1 = number;
		totalMoney = totalAmount - transfer;
		firstName1 = firstName;
		lastName1 = lastName;
		accNum1 = accNum;
		transfer1 = transfer;
		accNumTransfer1 = accNumTransfer;
		
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
		String costFormat = "Account No." + accNum + "  transfer " + transfer + " baht to Account No." + accNumTransfer;

		//Log Message
//		CompleteHeader.getUser1().getLogList().add(new Log(date, costFormat)); Error
		CompleteHeader.getUser1().getLogy().add(new Pair<>(date, costFormat));
		//Correct Image
		Image correctPic = new Image(new FileInputStream("src/citizenapp/img/correct.png"));
		ImageView correctImg = new ImageView();
		correctImg.setImage(correctPic);

		Text t1 = new Text("Successful Money Transfer");
		Text t2 = new Text("From Account No. " + accNum);
		Text t3 = new Text("To Account No. " + accNumTransfer);
		Text t4 = new Text("Amount : " + transfer + " baht");
		t1.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
		t2.setFont(Font.font("FreesiaUPC", 22));
		t3.setFont(Font.font("FreesiaUPC", 22));
		t4.setFont(Font.font("FreesiaUPC", 22));
		
//		Button finishbtn = new Button("Finish");
		
		VBox.setMargin(correctImg, new Insets(0,0,0,0));
		VBox.setMargin(t1, new Insets(-40,0,0,0));
		
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(correctImg, t1,t2,t3,t4);

		Image img1 = new Image(new FileInputStream(CompleteHeader.getPATH_TO_BG3()));
		ImageView mainBg = new ImageView();
		mainBg.setImage(img1);
		mainBg.setFitWidth(400);
		mainBg.setFitHeight(300);
	
		vbox.setLayoutX(95);
		vbox.setLayoutY(25);
		
		mainPane.getChildren().addAll(mainBg, vbox);
		Scene scene = new Scene(mainPane, 400, 300);
		window.setScene(scene);
		window.setTitle("Success Transfering");
		window.show();
			
		
	}	

	public static void closeProgram() throws Exception {
		CompleteHeader.getUser1().getAccountList().get(number1).setBalance(totalMoney);
//		System.out.println(LoginForm.getUserkey().getUserData(CompleteHeader.getUser1().getId()).getAccountList().get(number1).getBalance());
		LoginForm.getUserkey().getUserData(CompleteHeader.getUser1().getId()).getAccountList().get(number1).setBalance(totalMoney);
		CompleteHeader.getUser1().WriteData(CompleteHeader.getDATAPATH() + CompleteHeader.getUser1().getId());
//		System.out.println(LoginForm.getUserkey().getUserData(CompleteHeader.getUser1().getId()).getAccountList().get(number1).getBalance());
//		
//		System.out.println("Number : " + number1);
		AccountPage a2 = new AccountPage(number1, firstName1, lastName1, accNum1, LoginForm.getUserkey().getUserData(CompleteHeader.getUser1().getId()).getAccountList().get(number1).getBalance()); 
		a2.start(AccountPage.getStage());
		window.close();
	}
}
