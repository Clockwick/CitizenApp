/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.WithDraw;

import citizenapp.Module.CompleteHeader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author arthris
 */
public class VerifyWithDraw {

	private static int COUNT = 10;
	private static int seconds = COUNT;
	private static Label countdownLabel = new Label();
	private static boolean isCountdown;
	private static String firstName1;
	private static String accNum1;
	private static double totalMoney1;
	private static boolean isShutDown = false;
	private static Stage stage1;
	
	private final static String css = VerifyWithDraw.class.getResource("../style/darkbutton.css").toExternalForm();

	public static void display(int number, String firstName, String lastName, String accNum, double totalMoney, double withdraw) throws FileNotFoundException {
		
		AnchorPane mainPane = new AnchorPane();
		countdownLabel.setText("Times : " + seconds);
		firstName1 = firstName;
		accNum1 = accNum;
		totalMoney1 = totalMoney;
		double leftMoney = totalMoney - withdraw;
		//Stage
		Stage window = new Stage();
		stage1 = window;
		stage1.setOnCloseRequest(e -> {
			isShutDown = true;
			isCountdown = false;
			seconds = COUNT;
			stage1.close();
			
		});
		stage1.setResizable(false);
		try {
			window.initModality(Modality.APPLICATION_MODAL);
	
		} catch (Exception ex ) {}
		

	 	VBox vbox = new VBox(20);
		Button otp = new Button();
		otp.setDisable(true);
		
		Text t1 = new Text("Your withdraw code");
		t1.setFont(Font.font("OCR A Extended", 25));
		
		//OTP
		String otpS = "";
		for (int i = 0; i < 6; i++) {
			int otpNumber = (int)(Math.random() * 10);
			otpS += Integer.toString(otpNumber);
		}
		otp.setText(otpS);
		
		Label l1 = new Label("This code expires in 1 minutes");
		l1.setFont(Font.font("Segoe UI", 16));
		
		
		countdown();
		
		countdownLabel.setFont(Font.font("Segoe UI", 16));
		
		Button finishBtn = new Button("Finish");
		finishBtn.setStyle("-fx-backgroud-radius: 1em;");
		finishBtn.setOnAction(e -> {
			try {	
				if (leftMoney >= 0 && seconds != 0) {
					isShutDown = true;
					isCountdown = false;
					stage1.close();
					SuccessWithDraw.display(number, firstName, lastName, accNum, totalMoney, withdraw);
					CompleteHeader.setMoney(leftMoney);
					
				} 
				
			} catch (FileNotFoundException ex) {
				Logger.getLogger(VerifyWithDraw.class.getName()).log(Level.SEVERE, null, ex);
			}
		});
		vbox.setAlignment(Pos.CENTER);

		//Vbox
		vbox.getChildren().addAll(t1, otp, l1, countdownLabel, finishBtn);
		Image img1 = new Image(new FileInputStream(CompleteHeader.getPATH_TO_BG3()));
		ImageView mainBg = new ImageView();
		mainBg.setImage(img1);
		mainBg.setFitWidth(400);
		mainBg.setFitHeight(300);
	
		vbox.setLayoutX(60);
		vbox.setLayoutY(25);
		
		mainPane.getChildren().addAll(mainBg, vbox);
		mainPane.getStylesheets().add(css);
		//Scene 
		Scene scene = new Scene(mainPane, 400, 300);
		window.setScene(scene);
		window.setTitle("Verify");
		window.show();
		
	
		
		
		
	}
	
	public static void countdown() {
		Timeline time = new Timeline();
		time.setCycleCount(Timeline.INDEFINITE);
		if (time != null) {
			time.stop();
		}
		KeyFrame frame = new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {
			if (isCountdown){
				seconds--;
				countdownLabel.setText("Times : " + seconds);
				if (seconds < 1) {
					time.stop();	
					seconds = 0;
					try {
						isShutDown = true;
						isCountdown = false;
						seconds = COUNT;
						FailWithDraw.display(firstName1, accNum1, totalMoney1);
						VerifyWithDraw.getStage().close();
					} catch (Exception ex) {
						Logger.getLogger(VerifyWithDraw.class.getName()).log(Level.SEVERE, null, ex);
					}
					
				}
			} else {
				seconds = COUNT;
				time.stop();
			}
		});
		time.getKeyFrames().add(frame);
		time.playFromStart();
			
	}
	
	public static void setSeconds(int second) {
		seconds = second;
	}
	
	public static void setCountdown(boolean boo) {
		isCountdown = boo;
		
	}
	
	public static Stage getStage() {
		return stage1;
	}
	



	
}
