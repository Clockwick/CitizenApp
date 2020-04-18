/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Phone implements Serializable{
    private static final long serialVersionUID = 1L;
    private String phoneNumber;
    private String price;
    private String billingDate;
    private String internet;
    private String callingTime;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    private Date date;
 

    public Phone(){
	date = Calendar.getInstance(new Locale("en", "TH")).getTime();
	DateFormat dateformat = new SimpleDateFormat("dd MMM Y");
        this.billingDate = dateformat.format(date);
        this.price = "399";
        this.callingTime = "150";
        this.internet = "5";
    }

    public Phone(String phoneNumber, String price, String billingDate, String internet, String callingTime) {
        this.phoneNumber = phoneNumber;
        this.price = price;
        this.billingDate = billingDate;
        this.internet = internet;
        this.callingTime = callingTime;
    }

    public void changePackage(String price, String billingDate, String internet, String callingTime) {
        this.price = price;
        this.billingDate = billingDate;
        this.internet = internet;
        this.callingTime = callingTime;
    }
      
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPrice() {
        return price;
    }

    public String getBillingDate() {
        return billingDate;
    }

    public String getInternet() {
        return internet;
    }

    public String getCallingTime() {
        return callingTime;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setBillingDate(String billingDate) {
        this.billingDate = billingDate;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public void setCallingTime(String callingTime) {
        this.callingTime = callingTime;
    }

    @Override
    public String toString() {
        return "Phone{" + "phoneNumber=" + phoneNumber + ", price=" + price + ", billingDate=" + date.toString() + " internet=" + internet + ", callingTime=" + callingTime + '}';
    }
    
    
    
    
    
}
