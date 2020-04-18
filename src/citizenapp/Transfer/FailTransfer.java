/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.Transfer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
public class FailTransfer {
	
	public static void display() throws FileNotFoundException {
		//Stage
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		
		VBox vbox = new VBox(20);

////		//Correct Image
		Image incorrectPic = new Image(new FileInputStream("src/citizenapp/img/incorrect.png"));
		ImageView incorrectImg = new ImageView();
		incorrectImg.setImage(incorrectPic);

		Text t1 = new Text("The Transfer was unsuccessful");
		Text t2 = new Text("due to insuffcient money.");
		
		t1.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
		t2.setFont(Font.font("FreesiaUPC", 22));
		
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(incorrectImg, t1,t2);

		Scene scene = new Scene(vbox, 400, 300);
		window.setScene(scene);
		window.setTitle("Insufficient Balance");
		window.showAndWait();
		
	}
}
