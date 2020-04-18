
package citizenapp.Module;


import citizenapp.FirstPage;
import citizenapp.HomeInfo;
import database.UserData;
import database.UserkeyList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class LoginForm {
	
	private static UserkeyList userkey;
	//css
//	private final static String css = ;
//	private final static String SCROLL = "scroll-pane";
	
	public LoginForm () throws Exception {}
	
	
	public static void display() throws Exception {
		
		AnchorPane mainPane = new AnchorPane();
		
		Stage stage = new Stage();
		try {
			stage.initModality(Modality.APPLICATION_MODAL);
		} catch (Exception e) {}
		
		//Login Bg
		Image img1 = new Image(new FileInputStream("src/citizenapp/img/LoginBg.jpg"));
		ImageView mainBg = new ImageView();
		mainBg.setImage(img1);
		mainBg.setFitWidth(600);
		mainBg.setFitHeight(450);
		
		
		VBox completeLoginBox = new VBox(20);
		HBox userLoginBox1 = new HBox(20);
		HBox userLoginBox2 = new HBox(20);
		TextField inputId = new TextField();
		PasswordField inputPw = new PasswordField();
		Button loginBtn = new Button("Login");
		loginBtn.setStyle("-fx-font-family: Ink Free; -fx-background-radius: 20px; -fx-text-fill: #919191; -fx-padding: 20px; -fx-font-color: #fff");
		Label idText = new Label("Username:");
		Label pwText = new Label("Password :");
		idText.setFont(Font.font("Open Sans",FontWeight.BOLD, 25));
		idText.setTextFill(Color.WHITE);
		idText.setStyle("-fx-background-color: rgba(200,200,200,0.5)");
		pwText.setFont(Font.font("Open Sans",FontWeight.BOLD, 25));
		pwText.setTextFill(Color.WHITE);
		completeLoginBox.setAlignment(Pos.CENTER);
		
		userLoginBox1.setAlignment(Pos.CENTER);
		userLoginBox2.setAlignment(Pos.CENTER);
		
		inputId.setPromptText("Enter your ID");
		inputPw.setPromptText("Enter your Password");

		inputId.setText("1100525633264");
		inputPw.setText("123");
		
		userLoginBox1.getChildren().addAll(idText, inputId);
		userLoginBox2.getChildren().addAll(pwText, inputPw);
		try {
			completeLoginBox.getChildren().addAll(userLoginBox1, userLoginBox2, loginBtn);	
		} catch (IllegalArgumentException ex) {}
		
		completeLoginBox.setLayoutX(175);
		completeLoginBox.setLayoutY(150);
			
		loginBtn.setOnAction(e -> {
			String userId = inputId.getText();
			String pw = inputPw.getText();
			try {
				UserkeyList u1 = new UserkeyList("src/database/keylist");
				userkey = u1;
				UserData user = u1.Login(userId, pw);
				CompleteHeader h1 = new CompleteHeader(stage, user);
				FirstPage.close();
				
			} catch (Exception ex) {
				Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
			}
		});
		
		mainPane.getChildren().addAll(mainBg, completeLoginBox);
		
		Scene scene = new Scene(mainPane,600,450);
		
		stage.setScene(scene);
		stage.setTitle("Citizen Card");
		stage.show();
		
		
	}
	
	public static UserkeyList getUserkey() {
		return userkey;
	}
	

}
