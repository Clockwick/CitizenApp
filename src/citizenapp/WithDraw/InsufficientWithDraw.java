/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.WithDraw;

import citizenapp.Module.CompleteHeader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

/**
 *
 * @author arthris
 */
public class InsufficientWithDraw {
	public static void display(String firstName, String accNum, double totalAmount) throws FileNotFoundException {

		AnchorPane mainPane = new AnchorPane();
		//Stage
		Stage window = new Stage();
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);
		
		VBox vbox = new VBox(20);

////		//Correct Image
		Image incorrectPic = new Image(new FileInputStream("src/citizenapp/img/incorrect.png"));
		ImageView incorrectImg = new ImageView();
		incorrectImg.setImage(incorrectPic);

		Text t1 = new Text("You have insufficeint funds for the transaction");
		Text t2 = new Text("Name of Account : " + firstName);
		Text t3 = new Text("Account No." + accNum + " baht");
		Text t5 = new Text("Balance : " + String.format("%.2f", totalAmount) + " baht");
		t1.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
		t2.setFont(Font.font("FreesiaUPC", 22));
		t3.setFont(Font.font("FreesiaUPC", 22));
		t5.setFont(Font.font("FreesiaUPC", 22));
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(incorrectImg, t1,t2,t3,t5);

//		Button finishbtn = new Button("Finish");
		Image img1 = new Image(new FileInputStream(CompleteHeader.getPATH_TO_BG3()));
		ImageView mainBg = new ImageView();
		mainBg.setImage(img1);
		mainBg.setFitWidth(400);
		mainBg.setFitHeight(300);
	
		vbox.setLayoutX(38);
		vbox.setLayoutY(25);
		
		mainPane.getChildren().addAll(mainBg, vbox);
		VBox.setMargin(t1, new Insets(-20,0,0,0));
		
		
		Scene scene = new Scene(mainPane, 400, 300);
		window.setScene(scene);
		window.setTitle("Insufficient Balance");
		window.showAndWait();
		
		
			
		
	}
}
