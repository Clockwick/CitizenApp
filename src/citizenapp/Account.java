/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp;

/**
 *
 * @author arthris
 */


import citizenapp.Module.CompleteHeader;
import citizenapp.Module.LoginForm;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Account {
	
	private Text nameText = new Text();
	private Text accNumText = new Text();
	private HBox hbox = new HBox();
	private final String fullName;
	private String firstName;
	private String lastName;
	private double balance = 300000; // Connect from database
	private String accNum;
	private static ArrayList<Account> accountList = new ArrayList<>();
	private String password;
	private int number;
	private Account self = this;

public static ArrayList<HBox> getAccountBox() {
		return accountBox;
	}

	public static ArrayList<Account> getAccountList() {
		return accountList;
	}
	private final static String BOX_STYLE = "box";
	private String css = this.getClass().getResource("style/AccountList.css").toExternalForm();
	private static ArrayList<HBox> accountBox = new ArrayList<>();
	
	public Account(String firstName, String lastName, String accNum1, double balance, String password, int number) {
		this.number = number;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.fullName = this.firstName + " " + this.lastName;
		this.accNum = accNum1;
		this.balance = balance;
		this.nameText.setText("Name of Account : " + this.firstName);
		this.accNumText.setText("Account No." + this.accNum);
		this.nameText.setFill(Color.WHITE);
		this.accNumText.setFill(Color.WHITE);
		this.nameText.setFont(Font.font("Neucha", 20));
		this.accNumText.setFont(Font.font("Neucha", 20));
		this.nameText.setWrappingWidth(300);
		this.accNumText.setWrappingWidth(400);
		
		HBox.setMargin(this.nameText, new Insets(5,0,5,5));
		HBox.setMargin(this.accNumText, new Insets(5,0,5,0));
		
		hbox.setPrefHeight(19.0);
		hbox.setMinWidth(Control.USE_PREF_SIZE);
		hbox.setMaxWidth(Control.USE_PREF_SIZE);
		hbox.setPrefWidth(500.0);
//		System.out.println(CompleteHeader.getUser1().getAccountList().get(getNumber()).getBalance());
		hbox.getStylesheets().add(css);
		hbox.getStyleClass().add(BOX_STYLE);
		hbox.getChildren().addAll(this.nameText, this.accNumText);
		hbox.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
    			@Override
     			public void handle(MouseEvent event) {
        	 		event.consume();
				    try {
					    CompleteHeader.getUser1().getAccountList().get(number).addClick();
					    System.out.println("Account "  + number + ": " + CompleteHeader.getUser1().getAccountList().get(number).getCountClick());
					    AccountCheck.display(getNumber(), firstName,lastName, accNum, LoginForm.getUserkey().getUserData(CompleteHeader.getUser1().getId()).getAccountList().get(number).getBalance());
				    } catch (FileNotFoundException ex) {
					    Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
				    }
//				System.out.println("Account from database" + getNumber() + ":" + LoginForm.getUserkey().getUserData(CompleteHeader.getUser1().getId()).getAccountList().get(number).getBalance());
//				System.out.println("Account in CompleteHeader" + getNumber() + ":" + CompleteHeader.getUser1().getAccountList().get(getNumber()).getBalance());
				AccountCheck.setAccount(self);
     			}
		});
		accountBox.add(hbox);
		accountList.add(self);
		
	}

	public Text getNameText() {
		return nameText;
	}

	public Text getAccNumText() {
		return accNumText;
	}
	
	public HBox active() {
		return this.hbox;
	}
	public void setBalance(double money) {
		balance = money;
	}

	public void addBalance(double money) {
		this.balance += money;
	} 
	public String getAccNum() {
		return this.accNum;
	}
	
	public String getPassword() {
		return this.password;
	}

	public double getBalance() {
		return this.balance;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
	
	
}
