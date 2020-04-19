/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.Payphone;

import citizenapp.AccountList;
import citizenapp.Module.CompleteHeader;
import citizenapp.Payphone.Account.NotFoundAccount;
import citizenapp.Payphone.Account.WhichAccount;
import citizenapp.PhoneInfo;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author arthris
 */
public class ownPhone {
	
	private static Scene scene1;
	private final static String css = ownPhone.class.getResource("../style/darkbutton.css").toExternalForm();
	private final static String TEXT = "text-label";
	
	public static void display(String phoneNumber, double balance, double cost) throws FileNotFoundException  {
	
		Stage stage = new Stage();
		stage.setResizable(false);

		AnchorPane mainPane = new AnchorPane();
		stage.initModality(Modality.APPLICATION_MODAL);
		
		stage.setOnCloseRequest(e -> stage.close());
		VBox vbox = new VBox(20);
		
		Text t = new Text("Phone Number : " + phoneNumber);
		t.getStyleClass().add(TEXT);
		t.setFont(Font.font("Montserrat", 22));
		Text t1 = new Text("Total Cost : " + cost + " baht");
		t1.setFont(Font.font("Montserrat", 22));
		t1.getStyleClass().add(TEXT);
		Text confirmText = new Text("Confirm");
		confirmText.getStyleClass().add("text");
		
		Button confirmBtn = new Button();
		confirmBtn.setGraphic(confirmText);
		confirmBtn.getStylesheets().add(css);
		confirmBtn.setOnAction(e -> {
			try {	
				stage.close();
				WhichAccount.display();
			} catch (Exception ex) {
				Logger.getLogger(ownPhone.class.getName()).log(Level.SEVERE, null, ex);
			}
		});
		
		Text cancelText = new Text("Cancel");
		cancelText.getStyleClass().add("text");
		Button cancelBtn = new Button();
		cancelBtn.getStylesheets().add(css);
		cancelBtn.setOnAction(e -> {
			e.consume();
			stage.close();
		});
		
		cancelBtn.setGraphic(cancelText);
		HBox hbox = new HBox(5);
		hbox.getChildren().addAll(confirmBtn, cancelBtn);
		hbox.setPadding(new Insets(0, 0, 0, 55));
		
		vbox.getChildren().addAll(t, t1, hbox);
		vbox.setAlignment(Pos.CENTER);
		vbox.setLayoutX(50);
		vbox.setLayoutY(70);

		Image img1 = new Image(new FileInputStream(CompleteHeader.getPATH_TO_BG3()));
		ImageView mainBg = new ImageView();
		mainBg.setImage(img1);
		mainBg.setFitWidth(400);
		mainBg.setFitHeight(300);
		
		mainPane.getStylesheets().add(css);
		mainPane.getChildren().addAll(mainBg, vbox);
		
		Scene scene = new Scene(mainPane, 400, 300);
		scene1 = scene;
		stage.setScene(scene);
		stage.setTitle("PayPhone");
		stage.showAndWait();
		
	}
	
	
	public static Scene getScene() {
		return scene1;
	}
}
