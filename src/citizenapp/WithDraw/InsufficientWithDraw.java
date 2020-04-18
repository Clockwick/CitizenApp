/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.WithDraw;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

		
		//Stage
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		
		VBox vbox = new VBox(20);

////		//Correct Image
		Image incorrectPic = new Image(new FileInputStream("src/citizenapp/img/incorrect.png"));
		ImageView incorrectImg = new ImageView();
		incorrectImg.setImage(incorrectPic);

		Text t1 = new Text("You have insufficeint funds for the transaction");
		Text t2 = new Text("Name of Account : " + firstName);
		Text t3 = new Text("Account No. : " + accNum);
		Text t5 = new Text("Balance : " + String.format("%.2f", totalAmount));
		t1.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
		t2.setFont(Font.font("FreesiaUPC", 22));
		t3.setFont(Font.font("FreesiaUPC", 22));
		t5.setFont(Font.font("FreesiaUPC", 22));
		
//		Button finishbtn = new Button("Finish");
		
		VBox.setMargin(t1, new Insets(-20,0,0,0));
		
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(incorrectImg, t1,t2,t3,t5);

		Scene scene = new Scene(vbox, 400, 300);
		window.setScene(scene);
		window.setTitle("Insufficient Balance");
		window.showAndWait();
			
		
	}
}