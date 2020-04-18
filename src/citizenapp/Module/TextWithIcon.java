/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.Module;

import java.io.FileInputStream;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author arthris
 */
public class TextWithIcon {
	private final String string;
	private final String path;
	private HBox hbox = new HBox(5);
	private Text text =  new Text();
	private ImageView image = new ImageView();
	
	
	public TextWithIcon(String string, String path) {
		this.string = string;
		this.path = path;
	
	}
	
	public HBox active() throws Exception{
		text.setText(this.string);
		text.setFill(Color.WHITE);
		Image icon = new Image(new FileInputStream("src/citizenapp/img/" + this.path));
		this.image.setImage(icon);
		HBox.setMargin(this.image, new Insets(5, 0, 0, 0));
		
		text.setFont(Font.font("Mv Boli", 18));
		hbox.getChildren().addAll(text, image);
		return this.hbox;
	}

	public String getString() {
		return string;
	}

	public String getPath() {
		return path;
	}

	public HBox getHbox() {
		return hbox;
	}

	public Text getText() {
		return text;
	}

	public ImageView getImage() {
		return image;
	}

	
	
}
