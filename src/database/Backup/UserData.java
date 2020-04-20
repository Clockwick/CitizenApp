/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import citizenapp.Log;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
/**
 *
 * @author admin
 */
public class UserData implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    Locale locale = new Locale("en", "TH");
    private DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", locale);

	public DateFormat getDateFormat() {
		return dateFormat;
	}
    private String id;
    private String name;
    private String surname;
    private String gender;
    private String nationality;
    private String religion;
    private Date dateOfBirth;
    private String address;
    private String picturePath;
    Phone phone;
    ArrayList<Account> accountList;
    ArrayList<adminLog> adminLogList;
    ArrayList<Log> logList;
    private Date dateExpire;
    private Date dateOfIssue;
    private double balance;

    public void WriteData(String dataPath) {
 
        //System.out.println(this.toString());
        try {
                
                FileOutputStream fileOut = new FileOutputStream(dataPath);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                objectOut.writeObject(this);
                objectOut.close();
                //System.out.println("The Object  was succesfully written to a file");

        }catch(IOException ex) {
            System.out.println("UserDataWrtieDataFail");
            ex.printStackTrace();
        }
    }
    
    public UserData() {
        
    }

    public UserData(String id, String name, String surname, String gender, String nationality,String religion,Date hbd,String phoneNumber, String address, Date dateExpire, Date dateOfIssue) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.nationality = nationality;
        this.religion = religion;
        this.dateOfBirth = hbd;
        this.address = address;
        this.phone = new Phone();
        this.phone.setPhoneNumber(phoneNumber);
        this.dateExpire = dateExpire;
        this.dateOfIssue = dateOfIssue;
        accountList = new ArrayList<>() ;
        adminLogList = new ArrayList<>() ;
	logList = new ArrayList<>();

    }
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getNationality() {
        return nationality;
    }
    
    public String getAddress() {
        return address;
    }

    public String getDateOfBirth(){
        return dateFormat.format(dateOfBirth);
    }
    
    public String getDateExpire(){
        return dateFormat.format(dateExpire);
    }
    
    public String getDateOfIssue(){
        return dateFormat.format(dateOfIssue);
    }

    public double getBalance() {
        return balance;
    }  

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Phone getPhone() {
        return phone;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public ArrayList<adminLog> getAdminLogList() {
        return adminLogList;
    }

    public void setadminLogList(ArrayList<adminLog> adminLogList) {
        this.adminLogList = adminLogList;
    }

public ArrayList<Log> getLogList() {
	return logList;
}

public void setLogList(ArrayList<Log> logList) {
	this.logList = logList;
}
    
    
    
    
    
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public ArrayList<Account> getAccountList() {
	    return this.accountList;
    }

    @Override
    public String toString() {
        return "UserData\n{" +"balance="+ balance + ", id=" + id + ", name=" + name + ", surname=" + surname + "\n, gender=" + gender + ", nationality=" + nationality + ", dateOfBirth=" + dateFormat.format(dateOfBirth) + ", address=" + address + ", picturePath=" + picturePath + "\n, phone=" + phone.toString() + "\n, accountListSize=" + accountList.size() + ", logListSize=" + logList.size() + ", dateExpire=" + dateFormat.format(dateExpire) + ", dateOfIssue=" + dateFormat.format(dateOfIssue) + '}';
    }

    

    

    
    
    
    
    
}
