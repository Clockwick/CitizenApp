package citizenapp;


import citizenapp.Module.CompleteHeader;
import citizenapp.Module.CitizenLogo;
import citizenapp.Module.LabelPerInput;
import citizenapp.Module.TextWithIcon;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class HomeInfo implements EventHandler<ActionEvent>{
	// เชื่อม Database ตรงนี้
	private final String iden; // Identification Number
	private final String firstName; // FirstName
	private final String surName; // SurName
	private final String genderS; // Gender
	private final String nationS; // National
	private final String dobS; // Date
	private final String religS; // Religion 
	private final String addrS; //Address
	private final String doiS; // Date of Issue
	private final String doeS; // Date of Expiry 
	private final String bloodS;
	private AnchorPane mainPane = new AnchorPane();

	public AnchorPane getMainPane() {
		return mainPane;
	}
	
	
	private Scene scene;
	
	
	public HomeInfo(String iden, String fname, String lname, String gender, String nation,
		String dob, String relig, String addr, String doi, String doe,String blood) throws Exception {
		this.iden = iden;
		firstName = fname;
		surName = lname;
		genderS = gender;
		nationS = nation;
		dobS = dob;
		religS = relig;
		addrS = addr;
		doiS = doi;
		doeS = doe;
		bloodS = blood;
		start();
	}
	
	public void start() throws Exception {
		Image img = new Image(new FileInputStream(CompleteHeader.getPATH_TO_HUMANPIC()));
		ImageView pic = new ImageView();
		pic.setImage(img);
		pic.setFitWidth(112.5);
		pic.setFitHeight(150);
		pic.setLayoutX(530);
		pic.setLayoutY(150);
		//Prepared
		String fullName = this.firstName + " " + this.surName;
		
		LabelPerInput idNumber = new LabelPerInput("Identification Number :", iden);
		LabelPerInput name = new LabelPerInput("Name :", fullName);
		LabelPerInput gender = new LabelPerInput("Gender :", genderS);
		LabelPerInput nation = new LabelPerInput("Nationality :", nationS);
		LabelPerInput dob = new LabelPerInput("Date of Birth :", dobS);
		LabelPerInput relig = new LabelPerInput("Religion :", religS);
		LabelPerInput addr = new LabelPerInput("Address :", addrS);
		LabelPerInput doi = new LabelPerInput("Date of Issue :", doiS);
		LabelPerInput doe = new LabelPerInput("Date of Expiry :", doeS);
		LabelPerInput blood = new LabelPerInput("Blood group :", bloodS);
		
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
		
		//hbox
		HBox hbox1 = new HBox(10);
		hbox1.getChildren().addAll(idNumber.setInfo1(), idNumber.setInfo2());
		HBox hbox2 = new HBox(10);
		hbox2.getChildren().addAll(name.setInfo1(), name.setInfo2());
		HBox hbox3 = new HBox(10);
		hbox3.getChildren().addAll(gender.setInfo1(), gender.setInfo2());
		HBox hbox4 = new HBox(10);
		hbox4.getChildren().addAll(dob.setInfo1(), dob.setInfo2());
		HBox hbox5 = new HBox(10);
		addr.getHbox1().setMinHeight(Control.USE_PREF_SIZE);
		addr.getHbox1().setMaxHeight(Control.USE_PREF_SIZE);
		hbox5.getChildren().addAll(addr.setInfo1(), addr.setInfo2());
		HBox hbox6 = new HBox(10);
		hbox6.getChildren().addAll(doi.setInfo1(), doi.setInfo2());
		hbox6.setLayoutX(100);
		hbox6.setLayoutY(521);		
//		hbox7.getChildren().addAll(surname.setInfo1(), surname.setInfo2());
		HBox hbox8 = new HBox(10);
		hbox8.getChildren().addAll(nation.setInfo1(), nation.setInfo2());
		HBox hbox9 = new HBox(10);
		hbox9.setPadding(new Insets(125,0,0,0));
		hbox9.getChildren().addAll(blood.setInfo1(), blood.setInfo2());
		//vbox-left
		VBox vbox1 = new VBox(30);
		vbox1.setLayoutX(110);
		vbox1.setLayoutY(175);
		vbox1.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, hbox5);
		

		//special-vbox
		VBox vbox3 = new VBox();
		vbox3.setPadding(new Insets(50,0,0,0));
		HBox hbox0 = new HBox(10);
		hbox0.getChildren().addAll(doe.setInfo1(), doe.setInfo2());
		hbox0.setPadding(new Insets(0,0,0,0));
		vbox3.getChildren().add(hbox0);

		
		//vbox-right
		//114.23 - 67 = 47.23
		VBox vbox2 = new VBox(30);
		vbox2.setLayoutX(200);
		vbox2.setPadding(new Insets(67, 0, 0 , 0));
		vbox2.getChildren().addAll(hbox9 ,hbox8, vbox3);

		HBox mainHBox = new HBox();
		mainHBox.setLayoutX(100);
		mainHBox.setLayoutY(150);
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
		
		
		mainHBox.getChildren().addAll(vbox1, vbox2);
		mainPane.getChildren().addAll(mainBg, secondBg, CompleteHeader.getLogo(),  CompleteHeader.getNavbar(), CompleteHeader.getTopRight(), nameHBox, mainHBox, pic, hbox6);
		
		//Scene
		Scene scene = new Scene(mainPane, 800, 600);
		this.scene = scene;
		
		
	}
		
	@Override
	public void handle(ActionEvent event) {
		
	}
	
	public Scene getScene() {
		return this.scene;
	}
	
	
		
	
	
	
}
