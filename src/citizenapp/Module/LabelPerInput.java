
package citizenapp.Module;

import javafx.geometry.Insets;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class LabelPerInput {
	private String name;
	private String info;
	private Label label = new Label();
	private HBox hbox1 = new HBox();
	private HBox hbox2 = new HBox();
	public LabelPerInput(String labelName, String info) {
		this.name = labelName;
		this.info = info;
		
	}
	public LabelPerInput() {
		
	}
	
	public HBox setInfo1() {
		Text t1 = new Text(name);
		t1.setFont(Font.font("Neucha",20));
		t1.setFill(Color.WHITE);
		hbox1.setStyle(
			"-fx-border-radius: 10; -fx-background-color: #A49295; -fx-border-color: #000; -fx-background-radius: 10"
		);
		hbox1.setPadding(new Insets(5));
		hbox1.getChildren().add(t1);
		hbox1.setMinWidth(Control.USE_PREF_SIZE);
		hbox1.setMaxWidth(Control.USE_PREF_SIZE);
		hbox1.setPrefWidth(hbox1.getPrefWidth());
		hbox1.setPrefHeight(30);
		
		return this.hbox1;
	} 
	
	
	public HBox setInfo2() {
		label.setText(info);
		label.setTextFill(Color.WHITE);
		label.setFont(Font.font("Neucha",20));
		label.setWrapText(true);
		label.setPrefWidth(200);
		hbox2.getChildren().add(label);
		
		return this.hbox2;
	}
	
	
	
	public HBox active() {
		Text t1 = new Text(name);
		t1.setFont(new Font(20));
		label.setText(info);
		label.setFont(new Font(20));
		label.setWrapText(true);
		label.setPrefWidth(200);
		HBox.setMargin(t1, new Insets(50, 0, 50, 20));
		HBox.setMargin(label, new Insets(50, 0, 50, 20));
		hbox1.getChildren().addAll(t1, label);
		
		return hbox1;
	}

	public Label getLabel() {
		return this.label;
	}
	
	public HBox getHbox1() {
		return this.hbox1;
	}
	
	 
}
