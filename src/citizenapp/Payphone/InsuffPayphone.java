/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.Payphone;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author arthris
 */
public class InsuffPayphone {
	
	public static void display() throws FileNotFoundException {
		Stage stage = new Stage();
		stage.setOnCloseRequest(e -> stage.close());
		try {
			stage.initModality(Modality.APPLICATION_MODAL);
		} catch (Exception e) {}
		
		VBox vbox = new VBox(20);

////		//Correct Image
		Image incorrectPic = new Image(new FileInputStream("src/citizenapp/img/incorrect.png"));
		ImageView incorrectImg = new ImageView();
		incorrectImg.setImage(incorrectPic);

		Text t1 = new Text("Phone bill payment failed");
		
		Text t2 = new Text("You have insufficient funds for the transaction");
		
		
		t1.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
		t2.setFont(Font.font("FreesiaUPC", 22));
		t2.setFill(Color.RED);
		
		Button finishBtn = new Button("Finish");
		finishBtn.setOnAction(e -> {
			e.consume();
			stage.close();
		});
		
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(incorrectImg, t1,t2, finishBtn);

		Scene scene = new Scene(vbox, 400, 300);
		stage.setScene(scene);
		stage.setTitle("Insufficient Funds");
		stage.show();
	}
	
	
}
