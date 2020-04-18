/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.Module;

import java.io.FileInputStream;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class CitizenLogo {
	
	private static final Text text = new Text("Citizen");
	private static final ImageView bg = new ImageView();
	private static final HBox hbox = new HBox();
	
	public static HBox active() throws Exception {
		Image icon = new Image(new FileInputStream("src/citizenapp/img/CircleLogo.png"));	
		text.setFont(Font.font("Baloo Thambi 2", 72));
		text.setStyle("-fx-fill: #9B8B8B; -fx-stroke: white; -fx-stroke-width: 2px");
		bg.setImage(icon);
		hbox.getChildren().addAll(text, bg);
		return hbox;
	}

	public static HBox getHBox() {
		return hbox;
	} 

	public Text getText() {
		return text;
	}

	public ImageView getBg() {
		return bg;
	}

	public HBox getHbox() {
		return hbox;
	}
	
	
}
