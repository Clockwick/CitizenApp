/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp;

import citizenapp.Module.CompleteHeader;
import database.UserData;
import java.io.FileInputStream;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class AccountList implements EventHandler<ActionEvent>{
	
	private AnchorPane mainPane = new AnchorPane();	

	public AnchorPane getMainPane() {
		return mainPane;
	}
	private final String firstName;
	private final String lastName;
	private final String fullName;
	private static VBox vbox1;
	private static String phoneNumber1;
	private final ScrollPane scrollPane = new ScrollPane();
	private static ArrayList<Account> accountList = new ArrayList<>();
	private Scene scene;
	private UserData user;
	

	private final String SCROLL = "scroll-pane";
	private final String css = this.getClass().getResource("style/ScrollBar.css").toExternalForm();
	
	public AccountList(UserData user,String firstName, String lastName, String phoneNumber) throws Exception {
		this.firstName = firstName;
		this.lastName = lastName;
		phoneNumber1 = phoneNumber;
		this.user = user;
		this.fullName = this.firstName + " " + this.lastName;
		start();
		
	}

	public void start() throws Exception {
		
		VBox vbox = new VBox(20);
		vbox1= vbox;
		//Set-Up
		scrollPane.setLayoutX(145);
		scrollPane.setLayoutY(230);
		scrollPane.setPrefWidth(510);
		scrollPane.setPrefHeight(191.66);
		scrollPane.getStyleClass().add(SCROLL);
		scrollPane.getStylesheets().add(css);
		scrollPane.setVbarPolicy(ScrollBarPolicy.NEVER);
		scrollPane.setOnMouseEntered(e -> scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED));
		scrollPane.setOnMouseExited(e -> scrollPane.setVbarPolicy(ScrollBarPolicy.NEVER));
		
		HBox nameHBox = new HBox();
		Label fullNameLabel = new Label(CompleteHeader.getFullName());
		fullNameLabel.setTextFill(Color.WHITE);
		fullNameLabel.setFont(Font.font("MV Boli", 18));
		fullNameLabel.setTextAlignment(TextAlignment.RIGHT);
		nameHBox.setMinWidth(Control.USE_PREF_SIZE);
		nameHBox.setMinHeight(Control.USE_PREF_SIZE);
		nameHBox.setMaxWidth(Control.USE_PREF_SIZE);
		nameHBox.setMaxHeight(Control.USE_PREF_SIZE);
		nameHBox.setPrefWidth(300);
		nameHBox.setPrefHeight(30);
		nameHBox.setLayoutX(465);
		nameHBox.setLayoutY(40);
		nameHBox.getChildren().add(fullNameLabel);
		nameHBox.setAlignment(Pos.CENTER_RIGHT);
		
		mainPane.setPrefWidth(800);
		mainPane.setPrefHeight(600);

		Text accountName = new Text("Account Name: "); 
		accountName.setFont(Font.font("Neucha", 28));
		accountName.setFill(Color.WHITE);
		accountName.setLayoutX(190);
		accountName.setLayoutY(185);
		
		accountName.setTextAlignment(TextAlignment.CENTER);
		Text accountFullName = new Text(this.fullName);
		accountFullName.setFont(Font.font("Neucha", 28));
		accountFullName.setFill(Color.WHITE);
		accountFullName.setLayoutX(330);
		accountFullName.setLayoutY(185);
		accountFullName.setTextAlignment(TextAlignment.CENTER);
		accountFullName.setWrappingWidth(350);
		
		
		//เชื่อมข้อมูลจาก Database ตรงนี้
		
		for (int i = 0;i < user.getAccountList().size(); i++) {	
			Account account = new Account(user.getAccountList().get(i).getName(), "", String.valueOf(user.getAccountList().get(i).getAccountNumber()), user.getAccountList().get(i).getBalance(), "1234", i);
			if (CompleteHeader.getUser1().getAccountList().size() == Account.getAccountList().size())
				accountList.add(account);	
		}
		
		vbox.setMinWidth(Control.USE_PREF_SIZE);
		vbox.setMaxWidth(Control.USE_PREF_SIZE);
		vbox.setPrefWidth(380);
		vbox.setStyle("-fx-background-color: transparent;");
		for (int i = 0; i < Account.getAccountBox().size(); i++) {
			vbox.getChildren().add(Account.getAccountBox().get(i));
		}	
		scrollPane.setContent(vbox);
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollPane.setPrefViewportHeight(400);

		//Primary Background
		Image img1 = new Image(new FileInputStream(CompleteHeader.getPATH_TO_BG1()));
		ImageView mainBg = new ImageView();
		mainBg.setImage(img1);
		mainBg.setFitWidth(800);
		mainBg.setFitHeight(600);
		//Secondary Background
		Image img2 = new Image(new FileInputStream(CompleteHeader.getPATH_TO_BG2()));
		ImageView secondBg = new ImageView();
		secondBg.setFitWidth(600);
		secondBg.setFitHeight(450);
		secondBg.setLayoutX(-75);
		secondBg.setLayoutY(-240);
		Rectangle clip = new Rectangle(secondBg.getFitWidth(), secondBg.getFitHeight() - 75);
		clip.setArcWidth(300);
		clip.setArcHeight(300);
		secondBg.setClip(clip);
		secondBg.setImage(img2);
		secondBg.setEffect(new DropShadow(20, Color.GRAY));
		secondBg.setOpacity(0.8);
		
		mainPane.getChildren().addAll(mainBg, secondBg, CompleteHeader.getLogo(), CompleteHeader.getNavbar(), CompleteHeader.getTopRight(), nameHBox, accountName, accountFullName, scrollPane);
		
		/**
		 * MainBG √
		 * SecondBG √
		 * getLogo √
		 * Navbar √
		 * getTopRight √
		 */
		
		
		Scene scene = new Scene(mainPane, 800, 600);
		this.scene = scene;
	
	}

	@Override
	public void handle(ActionEvent event) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	
	public Scene getScene() {
		
		return this.scene;
	}
	
	public static String getPhoneNumber() {
		return phoneNumber1;
	}

	public static ArrayList<Account> getAccountList() {
		return accountList;
	}
	
	public static VBox getVBox1() {
		return vbox1;
	}
	
	
	
	

	
	
}
