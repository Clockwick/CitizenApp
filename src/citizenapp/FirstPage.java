

package citizenapp;

import citizenapp.Module.LoginForm;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import database.UserData;
import database.UserkeyList;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class FirstPage implements EventHandler<ActionEvent>{
	
	private static Stage window;
	private static final String BUTTON = "button";
	private String css = this.getClass().getResource("style/FirstPage.css").toExternalForm();
	private String DB_PATH = "src/citizenapp/DatabaseList/";
	private static final String PATH = "src/userdata/keylist"; 
	
	public FirstPage() {
		
//		UserkeyList ukl = new UserkeyList(PATH);
//		UserData us1 = ukl.Login("lol", "1234");
		
	}

	
	public void start(Stage stage) throws Exception {
		window = stage;
		window.setResizable(false);
		AnchorPane anchorPane = new AnchorPane();
		anchorPane.setPrefHeight(600);
		anchorPane.setPrefWidth(800);
		
		ImageView bgImage = new ImageView();
		bgImage.setFitHeight(600);
		bgImage.setFitWidth(900);
		bgImage.setLayoutX(-100);
		
		Image image = new Image(new FileInputStream("src/citizenapp/img/front.jpg"));
		bgImage.setImage(image);
		
		Button loginBtn = new Button("Login");
		loginBtn.setLayoutX(602.0);
		loginBtn.setLayoutY(40.0);
		loginBtn.setFont(Font.font("Oswald",51));
		loginBtn.getStyleClass().add(BUTTON);	
		loginBtn.setOnAction(e -> {
			try {
				
				LoginForm.display();
			} catch (Exception ex) {
				Logger.getLogger(FirstPage.class.getName()).log(Level.SEVERE, null, ex);
			}
		});
		
		anchorPane.getChildren().addAll(bgImage, loginBtn);
		
		Scene scene = new Scene(anchorPane, 800, 600);
		scene.getStylesheets().add(css);
		window.setTitle("Citizen");
		window.setScene(scene);	
		window.show();		
		
		
	}

	@Override
	public void handle(ActionEvent event) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	public static void close() {
		window.close();
	}
	
	
	
	
}
