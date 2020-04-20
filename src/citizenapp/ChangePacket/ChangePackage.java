/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.ChangePacket;

import citizenapp.Module.CompleteHeader;
import citizenapp.Payphone.InsuffPayphone;
import citizenapp.Payphone.ownPhone;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author arthris
 */
public class ChangePackage {
	
	
	private static final String IDLE = "-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-border-color: #000";
	private static final String HOVER = "-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: linear-gradient(from 35% 35% to 100% 100%, #A49295, #d9c59e); -fx-border-color: #6e6d6b; -fx-effect: dropshadow(three-pass-box, white, 5, 0, 0 ,0);\n" +
"    -fx-fill: whitesmoke;";
	
	//Package1 Info
	private static String price1 = "399";
	private static String gb1 = "5";
	private static String min1 = "150";
	//Package2 Info
	private static String price2 = "499"; 
	private static String gb2 = "10";
	private static String min2 = "200";
	//Package3 Info
	private static String price3 = "599"; 
	private static String gb3 = "16";
	private static String min3 = "300";
	//Package4 Info
	private static String price4 = "699"; 
	private static String gb4 = "20";
	private static String min4 = "300";
	
	public static void display() throws FileNotFoundException {
		
		
		Stage stage = new Stage();
		AnchorPane mainPane = new AnchorPane();
		stage.setOnCloseRequest(e -> stage.close());
		try {
			stage.initModality(Modality.APPLICATION_MODAL);
		} catch (Exception ex) {}
		
		VBox vbox = new VBox(10);
		HBox hbox = new HBox(10);
		HBox hbox1 = new HBox(10);
		HBox hbox2 = new HBox(10);
		
		Text t1 = new Text("Change Packet");
		t1.setFont(Font.font("Ink Free", 30));
		
		Button package1 = new Button();
		package1.setStyle(IDLE);
		package1.setOnMouseEntered(e -> package1.setStyle(HOVER));
		package1.setOnMouseExited(e -> package1.setStyle(IDLE));
		VBox packageVbox1 = new VBox(2);
		packageVbox1.setAlignment(Pos.CENTER);
		
		
		Text t01 = new Text("Price "+ price1 + " baht");
		t01.setFont(Font.font("Segoe UI", 15));
		t01.setFill(Color.BLACK);
		Text t02 = new Text(gb1 + " GB");
		t02.setFont(Font.font("Segoe UI", 15));
		t02.setFill(Color.BLACK);
		Text t03 = new Text(min1 +" minutes");
		t03.setFont(Font.font("Segoe UI", 15));
		t03.setFill(Color.BLACK);
		packageVbox1.getChildren().addAll(t01, t02, t03);
		package1.setGraphic(packageVbox1);
		Button package2 = new Button();
		package2.setStyle(IDLE);
		package2.setOnMouseEntered(e -> package2.setStyle(HOVER));
		package2.setOnMouseExited(e -> package2.setStyle(IDLE));
		VBox packageVbox2 = new VBox(2);
		packageVbox2.setAlignment(Pos.CENTER);
		Text t04 = new Text("Price "+ price2 + " baht");
		t04.setFont(Font.font("Segoe UI", 15));
		t04.setFill(Color.BLACK);
		Text t05 = new Text(gb2 + " GB");
		t05.setFont(Font.font("Segoe UI", 15));
		t05.setFill(Color.BLACK);
		Text t06 = new Text(min2 +" minutes");
		t06.setFont(Font.font("Segoe UI", 15));
		t06.setFill(Color.BLACK);
		packageVbox2.getChildren().addAll(t04, t05, t06);
		package2.setGraphic(packageVbox2);
		Button package3 = new Button();
		package3.setStyle(IDLE);
		package3.setOnMouseEntered(e -> package3.setStyle(HOVER));
		package3.setOnMouseExited(e -> package3.setStyle(IDLE));
		VBox packageVbox3 = new VBox(2);
		packageVbox3.setAlignment(Pos.CENTER);
		Text t07 = new Text("Price "+ price3 + " baht");
		t07.setFont(Font.font("Segoe UI", 15));
		t07.setFill(Color.BLACK);
		Text t08 = new Text(gb3 + " GB");
		t08.setFont(Font.font("Segoe UI", 15));
		t08.setFill(Color.BLACK);
		Text t09 = new Text(min3 +" minutes");
		t09.setFont(Font.font("Segoe UI", 15));
		t09.setFill(Color.BLACK);
		packageVbox3.getChildren().addAll(t07, t08, t09);
		package3.setGraphic(packageVbox3);
		Button package4 = new Button();
		package4.setStyle(IDLE);
		package4.setOnMouseEntered(e -> package4.setStyle(HOVER));
		package4.setOnMouseExited(e -> package4.setStyle(IDLE));
		VBox packageVbox4 = new VBox(2);
		packageVbox4.setAlignment(Pos.CENTER);
		Text t10 = new Text("Price "+ price4 + " baht");
		t10.setFont(Font.font("Segoe UI", 15));
		t10.setFill(Color.BLACK);
		Text t11 = new Text(gb4 + " GB");
		t11.setFont(Font.font("Segoe UI", 15));
		t11.setFill(Color.BLACK);
		Text t12 = new Text(min4 +" minutes");
		t12.setFont(Font.font("Segoe UI", 15));
		t12.setFill(Color.BLACK);
		packageVbox4.getChildren().addAll(t10, t11, t12);
		package4.setGraphic(packageVbox4);
		hbox.getChildren().addAll(package1, package2);
		hbox1.getChildren().addAll(package3, package4);
		hbox.setPadding(new Insets(0,0,0,5));
		hbox1.setPadding(new Insets(0,0,0,5));
		
		Button confirmBtn = new Button("Confirm");
		
		
		//Set Action
		package1.setOnAction( e -> {
			CompleteHeader.getPhoneObj().setPriceS(price1);
			CompleteHeader.getPhoneObj().setGbS(gb1);
			CompleteHeader.getPhoneObj().setMinS(min1);
			stage.close();
			try {
				SuccessChangePackage.display("1", price1, gb1, min1);
			} catch (FileNotFoundException ex) {
				Logger.getLogger(ChangePackage.class.getName()).log(Level.SEVERE, null, ex);
			}
			
		});
		package2.setOnAction( e -> {
			CompleteHeader.getPhoneObj().setPriceS(price2);
			CompleteHeader.getPhoneObj().setGbS(gb2);
			CompleteHeader.getPhoneObj().setMinS(min2);
			stage.close();
			try {
				SuccessChangePackage.display("2", price2, gb2, min2);
			} catch (FileNotFoundException ex) {
				Logger.getLogger(ChangePackage.class.getName()).log(Level.SEVERE, null, ex);
			}
			
		});
		package3.setOnAction( e -> {
			CompleteHeader.getPhoneObj().setPriceS(price3);
			CompleteHeader.getPhoneObj().setGbS(gb3);
			CompleteHeader.getPhoneObj().setMinS(min3);
			stage.close();
			try {
				SuccessChangePackage.display("3", price3, gb3, min3);
			} catch (FileNotFoundException ex) {
				Logger.getLogger(ChangePackage.class.getName()).log(Level.SEVERE, null, ex);
			}
			
		});
		package4.setOnAction( e -> {
			CompleteHeader.getPhoneObj().setPriceS(price4);
			CompleteHeader.getPhoneObj().setGbS(gb4);
			CompleteHeader.getPhoneObj().setMinS(min4);
			stage.close();
			try {
				SuccessChangePackage.display("4", price4, gb4, min4);
			} catch (FileNotFoundException ex) {
				Logger.getLogger(ChangePackage.class.getName()).log(Level.SEVERE, null, ex);
			}
			
		});
		vbox.getChildren().addAll(t1, hbox, hbox1);
		vbox.setAlignment(Pos.CENTER);
		
		Image img1 = new Image(new FileInputStream(CompleteHeader.getPATH_TO_BG3()));
		ImageView mainBg = new ImageView();
		mainBg.setImage(img1);
		mainBg.setFitWidth(400);
		mainBg.setFitHeight(300);
	
		vbox.setLayoutX(75);
		vbox.setLayoutY(25);
		
		mainPane.getChildren().addAll(mainBg, vbox);
		
		Scene scene = new Scene(mainPane, 400, 300);
		stage.setScene(scene);
		stage.setTitle("Change Package");
		stage.show();
		
	}
	
	
	
}
