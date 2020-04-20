/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author arthris
 */
public class Log implements Serializable{
	private static final long serialVersionUID = 1L;
	private Text timeText = new Text();
	private Text detailText = new Text();
	private HBox hbox = new HBox();
	private String timeS;
	private String detailS;

	private final static ArrayList<Log> logList = new ArrayList<>();

	public static ArrayList<Log> getLogList() {
		return logList;
	}
	
	public Log(String time, String detail) {
		this.timeS = time;
		this.detailS = detail;
		//HBox
		HBox hbox = new HBox(10);
		
		//Text-setup
		timeText.setFont(Font.font("MV Boli", 16));
		timeText.setStyle("-fx-font-style: italic; -fx-underline: true");
		timeText.setFill(Color.WHITE);
		timeText.setText(time);

		detailText.setFont(Font.font("Serithai", 16));
		detailText.setText(detail);
		detailText.setWrappingWidth(400);

		hbox.getChildren().addAll(timeText, detailText);
		
		this.hbox = hbox;
		
	}
	
	public HBox active() {
		return this.hbox;
	}

	public static void add(Log e) {
		logList.add(e);
	}
	
	public String toString() {
		return this.timeS + " " + this.detailS;
	}

	public String getTimeS() {
		return timeS;
	}

	public void setTimeS(String timeS) {
		this.timeS = timeS;
	}

	public String getDetailS() {
		return detailS;
	}

	public void setDetailS(String detailS) {
		this.detailS = detailS;
	}
	
	
	
	
}
