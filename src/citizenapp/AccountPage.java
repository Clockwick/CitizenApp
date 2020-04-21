/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp;


//import citizenapp.Module.RoundButton;

import citizenapp.Module.CompleteHeader;
import citizenapp.Transfer.TransferPopUp;
import citizenapp.WithDraw.WithDrawPopUp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
public class AccountPage extends Application implements EventHandler<ActionEvent> {

    private static Stage window;

    private final String fullName;
    private String firstName = "Paratthakorn";
    private String lastName = "Sribunyong";
    private final double money;
    private final int number;

    private final String accNum;

    private final String OREO = "-fx-background-color: #BBBAC0; -fx-background-radius: 1em;";


    //UI
    private final Text nameOfAcc = new Text();
    private final Text accNumText = new Text();
    private final Button withDrawBtn = new Button("Withdraw");
    private final Button transferBtn = new Button("Transfer");

    private static Account ownAccount;


    public AccountPage(int number, String firstName, String lastName, String accNum, double money) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = this.firstName + " " + this.lastName;
        this.accNum = accNum;
        this.money = money;

    }


    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setResizable(false);
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

        //Account Holder Name
        Text accountName = new Text("Account Name: " + this.fullName);
        accountName.setFont(Font.font("Neucha", 18));
        accountName.setFill(Color.WHITE);
        accountName.setLayoutX(180);
        accountName.setLayoutY(150);
        accountName.setWrappingWidth(400);
        accountName.setTextAlignment(TextAlignment.CENTER);

        //Name of Account
        this.nameOfAcc.setText("Name of Account : " + this.firstName);
        this.nameOfAcc.setFont(Font.font("Neucha", 18));
        this.nameOfAcc.setFill(Color.WHITE);
        this.nameOfAcc.setLayoutX(20);
        this.nameOfAcc.setLayoutY(180);

        //Account Number
        this.accNumText.setText("Account No. " + this.accNum);
        this.accNumText.setFont(Font.font("Neucha", 18));
        this.accNumText.setFill(Color.WHITE);
        this.accNumText.setLayoutX(600);
        this.accNumText.setLayoutY(180);

        //Withdraw Button
        this.withDrawBtn.setStyle(OREO);
        this.withDrawBtn.setFont(Font.font("Open Sans", 18));
        this.withDrawBtn.setTextFill(Color.web("#1F2322"));
        this.withDrawBtn.setLayoutX(330);
        this.withDrawBtn.setLayoutY(350);
        this.withDrawBtn.setPadding(new Insets(10, 15, 10, 15));
        this.withDrawBtn.setOnAction(e -> {
            e.consume();
            try {
                WithDrawPopUp.display(this.number, this.firstName, this.lastName, this.accNum, this.money);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AccountPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Transfer Button
        this.transferBtn.setStyle(OREO);
        this.transferBtn.setFont(Font.font("Open Sans", 18));
        this.transferBtn.setTextFill(Color.web("#1F2322"));
        this.transferBtn.setLayoutX(335);
        this.transferBtn.setLayoutY(420);
        this.transferBtn.setPadding(new Insets(10, 15, 10, 15));
        this.transferBtn.setOnAction(e -> {
            e.consume();
            try {
                TransferPopUp.display(this.number, this.firstName, this.lastName, this.accNum, this.money);
            } catch (Exception ex) {
            }
        });


        //MainPane
        AnchorPane mainPane = new AnchorPane();
        RoundButton balanceBtn = new RoundButton(this.money);
        balanceBtn.getBtn().setLayoutX(300);
        balanceBtn.getBtn().setLayoutY(180);

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

        mainPane.getChildren().addAll(
                mainBg, secondBg, CompleteHeader.getLogo(), CompleteHeader.getNavbar(),
                CompleteHeader.getTopRight(), nameHBox, accountName, this.nameOfAcc, this.accNumText, this.withDrawBtn,
                this.transferBtn, balanceBtn.active()
        );
        Scene scene = new Scene(mainPane, 800, 600);
        window.setTitle("AccountPage");
        window.setScene(scene);
        window.show();


    }

    @Override
    public void handle(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void closeProgram() {
        window.close();
    }

    private class RoundButton {
        private final double moneyLeft;
        private final String moneyLeftS;
        private Text balanceText = new Text();
        private Button button = new Button();
        private VBox vbox = new VBox(20);

        private final String css = this.getClass().getResource("style/RoundButton.css").toExternalForm();
        private final String ROUND_BUTTON = "round-button";

        public RoundButton(double moneyLeft) {
            this.moneyLeft = moneyLeft;

            this.moneyLeftS = String.format("%.2f", this.moneyLeft);

            this.button.getStyleClass().add(ROUND_BUTTON);
            this.button.getStylesheets().add(css);
        }

        public Button active() {
            this.balanceText.setText("Balance " + this.moneyLeftS);
            this.balanceText.setFont(Font.font("FreesiaUPC", 25));
            this.balanceText.setFill(Color.WHITE);
            this.balanceText.setWrappingWidth(100);
            this.balanceText.setTextAlignment(TextAlignment.CENTER);
            this.balanceText.setLineSpacing(30);
            this.vbox.setAlignment(Pos.CENTER);
            vbox.getChildren().addAll(this.balanceText);
            this.button.setGraphic(this.vbox);
            return this.button;
        }

        public Button getBtn() {
            return this.button;
        }
    }

    public static Stage getStage() {
        return window;
    }

    public void setAccount(Account a1) {
        this.ownAccount = a1;
    }

    public static Account getAccount() {
        return ownAccount;
    }


}
