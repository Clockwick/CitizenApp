/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.Module;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author arthris
 */
public class Header {
	
	private String topic;
	Pane pane = new Pane();
	Text historyText = new Text();
	Button backBtn = new Button("< Back ");
	
	public Header(String topic) {
		this.topic = topic;
		
		historyText.setText(topic);
	}
	
	public Pane active() {
		
		historyText.setFont(new Font(28));
		historyText.setLayoutX(330.0);
		historyText.setLayoutY(39.0);
		pane.setPrefHeight(50);
		pane.setPrefWidth(600);
		pane.setStyle("-fx-background-color:gray");
		
		backBtn.setLayoutX(10.0);
		backBtn.setLayoutY(10.0);
		
		pane.getChildren().addAll(historyText, backBtn);
		
		return pane;
	}
	
	public Button getBackBtn() {
		return this.backBtn;
	}
}
