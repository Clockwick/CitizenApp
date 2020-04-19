/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.Payphone;


import citizenapp.AccountCheck;
import citizenapp.Module.CompleteHeader;
import citizenapp.Module.LoginForm;
import citizenapp.Payphone.Account.WhichAccount;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
public class otherPhone {
	
	private static String otherPhoneNum;
	private static final String css = otherPhone.class.getResource("../style/darkbutton.css").toExternalForm();
	

	public static String getOtherPhoneNum() {
		return otherPhoneNum;
	}

	public static void display() throws FileNotFoundException {

		AnchorPane mainPane = new AnchorPane();
		Stage stage = new Stage();
		stage.setResizable(false);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setOnCloseRequest(e -> stage.close());
		VBox vbox = new VBox(20);
		Text t1 = new Text("Phone number that you want to pay the bill");
		t1.setWrappingWidth(200);
		t1.setFont(Font.font("Tempus Sans ITC", 20));
		Text t2= new Text("Phone number : ");
		t2.setFont(Font.font("Montserrat", 15));
		TextField t2Input = new TextField();
		t2Input.setPromptText("Enter the phone number");
		
		HBox hbox = new HBox(10);
		hbox.getChildren().addAll(t2, t2Input);
		hbox.setPadding(new Insets(0,0,0,0));
		
		Button confirmBtn = new Button("Confirm");
		confirmBtn.setOnAction(e -> {
			try {
				otherPhoneNum = t2Input.getText();
				int i;

				for (i = 0; i < LoginForm.getUserkey().key.size(); i++) {
					if (otherPhoneNum.equals(LoginForm.getUserkey().key.get(i).ReadData().getPhone().getPhoneNumber())) {
						stage.close();
						
						WhichAccount.displayOther(i);
						i = LoginForm.getUserkey().key.size() + 1;
						break;
					} 	
				}
				if (i == LoginForm.getUserkey().key.size()) {
					NoExistPayphone.display();
				}
				
			} catch (Exception ex) {
				Logger.getLogger(otherPhone.class.getName()).log(Level.SEVERE, null, ex);
			}
			//ต้องเชื่อม db ก่อน แล้วหา phoneNumber ถ้ามีก็จ่ายเด้งเป็นหน้า WhichAccount แล้วเเอาข้อมูล package มาแสดงตอน ConfirmAccount
			
		});
		Button cancelBtn = new Button("Cancel");
		cancelBtn.setOnAction(e -> {
			e.consume();
			stage.close();
		});
		HBox hbox1 = new HBox(10);
		hbox1.getChildren().addAll(confirmBtn, cancelBtn);
		hbox1.setPadding(new Insets(0,0,0,35));
		
		vbox.getChildren().addAll(t1, hbox, hbox1);
		vbox.setAlignment(Pos.CENTER);

		vbox.setLayoutX(60);
		vbox.setLayoutY(70);
		Image img1 = new Image(new FileInputStream(CompleteHeader.getPATH_TO_BG3()));
		ImageView mainBg = new ImageView();
		mainBg.setImage(img1);
		mainBg.setFitWidth(400);
		mainBg.setFitHeight(300);
		
		mainPane.getChildren().addAll(mainBg, vbox);
		mainPane.getStylesheets().add(css);
		Scene scene = new Scene(mainPane, 400, 300);
		stage.setScene(scene);
		stage.setTitle("PayPhone");
		stage.showAndWait();
		
	}

}
