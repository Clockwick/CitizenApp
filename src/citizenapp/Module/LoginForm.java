
package citizenapp.Module;


import citizenapp.FirstPage;
import database.UserData;
import database.UserkeyList;
import java.io.FileInputStream;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;


public class LoginForm {
	
	private static UserkeyList userkey;
	//css
//	private final static String css = ;
//	private final static String SCROLL = "scroll-pane";
	private final static String css = LoginForm.class.getResource("../style/loginForm.css").toExternalForm();
	private final static String VBOX = "vbox";
	private final static String BTN = "button";
	private final static String BG = "background";
	private final static String INPUT = "input";
	public LoginForm () throws Exception {}
	
	
	public static void display() throws Exception {
		
	
		AnchorPane mainPane = new AnchorPane();
		
		Stage stage = new Stage();
		stage.setResizable(false);
		try {
			stage.initModality(Modality.APPLICATION_MODAL);
		} catch (Exception e) {}
		
		
		//Login Bg
		Image img1 = new Image(new FileInputStream("src/citizenapp/img/cafe.jpg"));
		ImageView mainBg = new ImageView();
		mainBg.setImage(img1);
		mainBg.setFitWidth(600);
		mainBg.setFitHeight(450);
		
		//Id
		Image idImage = new Image(new FileInputStream("src/citizenapp/img/idUser.png"));
		ImageView idImageView = new ImageView();
		idImageView.setImage(idImage);
		
		HBox userLoginBox1 = new HBox();
		
		
		TextField inputId = new TextField();
		inputId.setPrefWidth(250);
		
		inputId.setPromptText("Identification Number");

		//Password
		Image pwImage = new Image(new FileInputStream("src/citizenapp/img/pwUser.png"));
		ImageView pwImageView = new ImageView();
		pwImageView.setImage(pwImage);
		HBox userLoginBox2 = new HBox();
		PasswordField inputPw = new PasswordField();
		inputPw.setPrefWidth(250);
		inputPw.setPromptText("Password");
		

		
		
		FadeTransition fTransition = new FadeTransition();
		
		VBox completeLoginBox = new VBox(20);
		fTransition.setDuration(Duration.seconds(1));
		fTransition.setFromValue(0);
		fTransition.setToValue(1);
		fTransition.setNode(completeLoginBox);
		fTransition.play();
		completeLoginBox.getStyleClass().add(VBOX);
		
		
		Button loginBtn = new Button("Sign in");
		
		completeLoginBox.setAlignment(Pos.CENTER);
		
		Text wrong = new Text("Sorry, Please try again");
		wrong.setFill(Color.ORANGE);
		wrong.setFont(Font.font("Arial", 14));
		
		
		inputId.setText("1100254668954");
		inputPw.setText("123");
		
		userLoginBox1.getChildren().addAll(idImageView, inputId);
		userLoginBox2.getChildren().addAll(pwImageView, inputPw);
		try {
			completeLoginBox.getChildren().addAll(userLoginBox1, userLoginBox2, loginBtn);	
		} catch (IllegalArgumentException ex) {}
		
		completeLoginBox.setLayoutX(150);
		completeLoginBox.setLayoutY(130);
		inputPw.setOnKeyPressed((KeyEvent key) -> {
			if (key.getCode().equals(KeyCode.ENTER))
			{
				String userId = inputId.getText();
				String pw = inputPw.getText();
				try {
					UserkeyList u1 = new UserkeyList("src/database/keylist");
					userkey = u1;
					UserData user = u1.Login(userId, pw);
					user.sortAccountList();
					CompleteHeader h1 = new CompleteHeader(stage, user);
					FirstPage.close();

				} catch (Exception ex) {
					if (completeLoginBox.getChildren().size() < 4) {
						completeLoginBox.getChildren().remove(loginBtn);
						completeLoginBox.getChildren().addAll(wrong, loginBtn);
					}
					
				}
			}
		});
		loginBtn.setOnAction(e -> {
			String userId = inputId.getText();
			String pw = inputPw.getText();
			try {
				UserkeyList u1 = new UserkeyList("src/database/keylist");
				userkey = u1;
				UserData user = u1.Login(userId, pw);
				user.sortAccountList();
				CompleteHeader h1 = new CompleteHeader(stage, user);
				FirstPage.close();
				
			} catch (Exception ex) {
//				if (completeLoginBox.getChildren().size() < 4) {
//					completeLoginBox.getChildren().remove(loginBtn);
//					completeLoginBox.getChildren().addAll(wrong, loginBtn);
//				} 
				ex.printStackTrace();
				
				
			}
		});
		
		mainPane.getChildren().addAll(mainBg, completeLoginBox);
		mainPane.getStylesheets().add(css);
		mainBg.setEffect(new GaussianBlur(10));
		
		
		Scene scene = new Scene(mainPane,600,450);
		
		stage.setScene(scene);
		stage.setTitle("Citizen Card");
		stage.show();
	
		
		//Mainpane
		
		
			
			
			
			
		
		
		
		
	}
	
	public static UserkeyList getUserkey() {
		return userkey;
	}
//	

}
