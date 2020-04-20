/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.ChangePacket;

import citizenapp.Log;
import citizenapp.Module.CompleteHeader;
import citizenapp.PhoneInfo;
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
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Pair;


/**
 *
 * @author arthris
 */
public class SuccessChangePackage {
	
	private static Stage stage = new Stage();
	private static String price1 ;
	private static String minute1 ;
	private static String gb1 ;
	private static final String css = SuccessChangePackage.class.getResource("../style/darkbutton.css").toExternalForm();
	
	public static void display(String packAge, String price, String gb, String minute) throws FileNotFoundException {
		price1 = price;
		gb1 = gb;
		minute1 = minute;
		
		
		AnchorPane mainPane = new AnchorPane();
		try {
			stage.initModality(Modality.APPLICATION_MODAL);
		} catch (Exception e) {}
		
		//Date
		Locale thaiLocal = new Locale("en", "TH");
		DateFormat dateformatLog = new SimpleDateFormat("dd/MM/Y hh:mm a :");
		DateFormat dateformatOne = new SimpleDateFormat("dd MMM Y");
		Date date = new Date();
		String dateLog = dateformatLog.format(date);
		Date date1= new Date();
		date1.setMonth(date1.getMonth() + 1);
		String dateOne = dateformatOne.format(date1);
//		System.out.println(dateLog);
//		System.out.println(dateOne);
		//Cost format
		String costFormat = "You have changed package to Package : " + packAge + " (Price : " + price + " baht " + gb + " GB " + minute + " minutes)";

		//Log Message
//		CompleteHeader.getUser1().getLogList().add(new Log(dateLog, costFormat)); Error
		CompleteHeader.getUser1().getLogy().add(new Pair<>(dateLog, costFormat));

		//VBox
		VBox vbox = new VBox(20);
		stage.setOnCloseRequest(e -> {
			try {
				closeProgram();
			} catch (Exception ex) {
				Logger.getLogger(SuccessChangePackage.class.getName()).log(Level.SEVERE, null, ex);
			}
		});

		//Correct Image
		Image correctPic = new Image(new FileInputStream("src/citizenapp/img/correct.png"));
		ImageView correctImg = new ImageView();
		correctImg.setImage(correctPic);
		Text t1 = new Text("Package change successful");
		Text t2 = new Text("Your current package : " + packAge + " (Price : " + price + " baht " + gb + " GB " + minute + " minutes)");
		t1.setFont(Font.font("Segoe UI", FontWeight.BOLD,20));
		t2.setFont(Font.font("Segoe UI",16));
		t2.setWrappingWidth(180);
		t2.setTextAlignment(TextAlignment.CENTER);

		Button finishBtn = new Button("Finish");
		finishBtn.setOnAction(e -> {
			e.consume();
			try {
				CompleteHeader.getUser1().getPhone().setInternet(gb);
				CompleteHeader.getUser1().getPhone().setCallingTime(minute);
				CompleteHeader.getUser1().getPhone().setPrice(price);
				CompleteHeader.getUser1().getPhone().setBillingDate(dateOne);
				CompleteHeader.getUser1().getPhone().setDate(date1);
				CompleteHeader.getUser1().WriteData("src/database/" + CompleteHeader.getUser1().getId());
				closeProgram();
			} catch (Exception ex) {
				Logger.getLogger(SuccessChangePackage.class.getName()).log(Level.SEVERE, null, ex);
			}

		});
		VBox.setMargin(t1, new Insets(-30,0,0,0));
		vbox.getChildren().addAll(correctImg, t1, t2, finishBtn);
		vbox.setAlignment(Pos.CENTER);
		Image img1 = new Image(new FileInputStream(CompleteHeader.getPATH_TO_BG3()));
		ImageView mainBg = new ImageView();
		mainBg.setImage(img1);
		mainBg.setFitWidth(400);
		mainBg.setFitHeight(300);
	
		vbox.setLayoutX(87);
		vbox.setLayoutY(-10);
		
		vbox.getStylesheets().add(css);
		
		mainPane.getChildren().addAll(mainBg, vbox);
		
		
		Scene scene = new Scene(mainPane, 400, 300);
		stage.setScene(scene);
		stage.setTitle("Successful Change Package");
		stage.show();
		
	}
	
	public static void closeProgram() throws Exception {
		PhoneInfo p2 = new PhoneInfo(CompleteHeader.getPhoneNumber(), price1, CompleteHeader.getUser1().getPhone().getBillingDate() , gb1, minute1, CompleteHeader.getBalance());
		p2.start();
		CompleteHeader.getStage().setScene(PhoneInfo.getScene());
		stage.close();
	}
}
