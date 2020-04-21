/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp;

import citizenapp.Module.CompleteHeader;
import citizenapp.ChangePacket.ChangePackage;
import citizenapp.Module.LabelPerInput;
import citizenapp.Payphone.PayphoneBill;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * @author arthris
 */
public class PhoneInfo {


    private static final String css = PhoneInfo.class.getResource("style/generalButton.css").toExternalForm();
    private static final String TEXT = "text";
    private static Scene scene;

    private String phoneNumberS;
    private String priceS;
    private String dueDateS;
    private String gbS;
    private String minS;
    private String packAgeS;

    public void setPhoneNumberS(String phoneNumberS) {
        this.phoneNumberS = phoneNumberS;
    }

    public void setPriceS(String priceS) {
        this.priceS = priceS;
    }

    public void setDueDateS(String dueDateS) {
        this.dueDateS = dueDateS;
    }

    public void setGbS(String gbS) {
        this.gbS = gbS;
    }

    public void setMinS(String minS) {
        this.minS = minS;
    }

    public void setPackAgeS(String packAgeS) {
        this.packAgeS = packAgeS;
    }

    private final double balance;


    public PhoneInfo(String phoneNumber, String priceS, String dueDate, String gb, String min, double balance) throws Exception {
        this.phoneNumberS = phoneNumber;
        this.priceS = priceS;
        this.dueDateS = dueDate;
        this.gbS = gb;
        this.minS = min;
        this.packAgeS = gbS + " GB" + " (The internet won't run out) " + minS + " minutes" + " (Free calls to all network)";
        this.balance = balance;

        start();
    }

    public void start() throws Exception {

        AnchorPane mainPane = new AnchorPane();
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
        Text t1 = new Text("User Information");
        t1.setFont(Font.font("Neucha", 22));
        t1.setFill(Color.WHITE);
        LabelPerInput phoneNumber = new LabelPerInput("Phone number : ", phoneNumberS);
        LabelPerInput dueDate = new LabelPerInput("Due date :", dueDateS);
        LabelPerInput price = new LabelPerInput("Price :", priceS + " baht");
        LabelPerInput packAge = new LabelPerInput("Package :", packAgeS);
        double prices = Double.parseDouble(priceS);
        //Pay phone bill Button
        Button paybillBtn = new Button();
        Text textInPayBill = new Text("Pay phone bills");
        textInPayBill.getStyleClass().add(TEXT);
        paybillBtn.setGraphic(textInPayBill);

        paybillBtn.setOnAction(e -> {
            try {
                PayphoneBill.display(phoneNumberS, balance, prices);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PhoneInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Change package bill Button
        Button changePackageBtn = new Button();
        Text textInChangePackage = new Text("Change package");
        textInChangePackage.getStyleClass().add(TEXT);
        changePackageBtn.setGraphic(textInChangePackage);
        changePackageBtn.setOnAction(e -> {
            try {
                ChangePackage.display();
            } catch (Exception ex) {
            }

        });

        VBox bigVbox = new VBox(25);
        bigVbox.setLayoutX(110);
        bigVbox.setLayoutY(150);
        bigVbox.setPrefWidth(600);


        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(phoneNumber.setInfo1(), phoneNumber.setInfo2());

        HBox hbox1 = new HBox(10);
        hbox1.getChildren().addAll(dueDate.setInfo1(), dueDate.setInfo2());

        HBox hbox2 = new HBox(10);
        hbox2.getChildren().addAll(price.setInfo1(), price.setInfo2());

        HBox hbox3 = new HBox(10);
        packAge.getHbox1().setMinHeight(Control.USE_PREF_SIZE);
        packAge.getHbox1().setMaxHeight(Control.USE_PREF_SIZE);

        hbox3.getChildren().addAll(packAge.setInfo1(), packAge.setInfo2());

        HBox hbox4 = new HBox(10);
        hbox4.getChildren().addAll(paybillBtn, changePackageBtn);

        VBox vbox1 = new VBox(20);
        vbox1.getChildren().addAll(hbox, hbox1);
        VBox vbox2 = new VBox(20);
        vbox2.getChildren().addAll(hbox2, hbox3);

        HBox hbox0 = new HBox();
        hbox0.getChildren().addAll(vbox1, vbox2);
        bigVbox.setMargin(t1, new Insets(0, 40, 0, 0));
        hbox4.setPadding(new Insets(0, 0, 0, 110));
        bigVbox.getChildren().addAll(t1, hbox0, hbox4);
        bigVbox.setAlignment(Pos.BASELINE_CENTER);

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

        mainPane.getChildren().addAll(mainBg, secondBg, CompleteHeader.getLogo(), CompleteHeader.getNavbar(), CompleteHeader.getTopRight(), nameHBox, bigVbox);
        mainPane.getStylesheets().add(css);
//		//Scene
        Scene scene = new Scene(mainPane, 800, 600);
        this.scene = scene;
    }

    public static Scene getScene() {
        return scene;
    }


}
