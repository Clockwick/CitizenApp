/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class UserkeyList implements Serializable {

    private static final long serialVersionUID = 1L;
    public ArrayList<UserKey> key;
    public ArrayList<adminLog> adminLogs;
    private static final String DATAPATH_SRC = "src/database/";

    public void addLogs(String head, String prev, String next) {
        adminLog temp = new adminLog();
        temp.setString("    prev : " + prev + "\n" + "    " + "next : " + next);
        temp.setHead(head);
        adminLogs.add(temp);
    }

    public void addLogs(String head, String detail) {
        adminLog temp = new adminLog();
        temp.setString("    Detail : " + detail);
        temp.setHead(head);
        adminLogs.add(temp);
    }

    public void addLogs(String id, String name, String surname, String gender, String nation, String religion, Date hbd, String phoneNumber, String address, Date dateExpire, Date dateOfIssue, String bloodgroup) {
        adminLog temp = new adminLog();
        temp.setHead("Register Account");
        String T = "                  ";
        DateFormat dateformat = new SimpleDateFormat("dd MM Y");
        temp.setString("    Detail :  ->  id : " + id + "\n" + T +
                "name : " + name + "\n" + T +
                "surname : " + surname + "\n" + T +
                "gender : " + gender + "\n" + T +
                "nationality : " + nation + "\n" + T +
                "religion : " + religion + "\n" + T +
                "HBD : " + dateformat.format(hbd) + "\n" + T +
                "phoneNumber : " + phoneNumber + "\n" + T +
                "address : " + address + "\n" + T +
                "dateExpire : " + dateformat.format(dateExpire) + "\n" + T +
                "dateOfIssue : " + dateformat.format(dateOfIssue) + "\n" + T +
                "bloodGroup : " + bloodgroup
        );
        adminLogs.add(temp);
    }

    public void SHOWADMINLOGS() {
        if (adminLogs.isEmpty()) {
            System.out.println("Admin logs is empty.");
            return;
        }
        System.out.println("----- Admin logs -----");
        adminLogs.forEach((x) -> {
            System.out.println(x.getDateString() + " : " + x.getHead() + "\n" + x.getDetailString());
        });
        System.out.println("----------------------");
    }

    public UserkeyList() {
        this.key = new ArrayList<>();
    }

    public UserkeyList(String KeyListPath) {
        this.key = new ArrayList<>();
        try {

            FileInputStream fileIn = new FileInputStream(KeyListPath);
            try (ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
                this.key = (ArrayList<UserKey>) objectIn.readObject();
            }

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("KeyListReadDataFail :" + ex.getMessage());
        }
    }

    public void WriteKeyList(String KeyListPath) {
        try {
            FileOutputStream fileOut = new FileOutputStream(KeyListPath);
            try (ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
                objectOut.writeObject(key);

            }

        } catch (IOException ex) {
            System.out.println("KeyListSaveFail");
        }
    }

    public void Register() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Id :");
        String id = scanner.nextLine();
//        System.out.println(id.matches("[0-9]+"));
//        System.out.println(id.matches("^[a-zA-Z]*$"));
//        System.out.println(id.length()==13);
        while (!id.matches("[0-9]+") || id.length() != 13) {
            System.out.println("id must contain only number and have lenght of 13 :");
            id = scanner.nextLine();
        }

        int i = 0;
        while (i < key.size()) {
            for (i = 0; i < key.size(); i++) {
                if (id.equals(key.get(i).getId())) {
                    System.out.println("this is is being used pls reenter id :");
                    id = scanner.nextLine();
                    break;
                }
            }
        }

        System.out.println("Enter Password:");
        String password = scanner.nextLine();
        UserKey uKey = new UserKey(id, password, DATAPATH_SRC + id);
        key.add(uKey);

        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        while (!name.matches("^[a-zA-Z]*$")) {
            System.out.println("name must contain only alphabets");
            name = scanner.nextLine();
        }

        System.out.println("Enter Surname: ");
        String surname = scanner.nextLine();
        while (!surname.matches("^[a-zA-Z]*$")) {
            System.out.println("surname must contain only alphabets");
            surname = scanner.nextLine();
        }

        System.out.println("Enter Gender: [M,F,O]");
        String gender = scanner.nextLine();
        while (!(gender.equals("M") || gender.equals("m") || gender.equals("F") || gender.equals("f") || gender.equals("O") || gender.equals("o"))) {
            System.out.println("pls,Enter the gender in the right format");
            gender = scanner.nextLine();

        }

        switch (gender) {
            case "M":
                gender = "Male";
                break;
            case "m":
                gender = "Male";
                break;
            case "F":
                gender = "Female";
                break;
            case "f":
                gender = "Female";
                break;
            case "o":
                gender = "Other";
                break;
            case "O":
                gender = "Other";
                break;
        }

        System.out.println("Enter nationality: ");
        String nationality = scanner.nextLine();
        System.out.println("Enter religion");
        String religion = scanner.nextLine();
        System.out.println("Enter Blood Group: [A,B,O,AB]");
        String blood = scanner.nextLine();
        while (!(blood.equals("A") || blood.equals("a") || blood.equals("B") || blood.equals("b") || blood.equals("O") || blood.equals("o") || blood.equals("AB") || blood.equals("ab") || blood.equals("aB") || blood.equals("Ab"))) {
            System.out.println("pls,Enter the Blood Group in the right format");
            blood = scanner.nextLine();
        }
        blood = blood.toUpperCase();
        System.out.println("Enter dateOfBirth: [dd mm yyyy]");
        int dateOfBirth = scanner.nextInt();
        int mounthOfBirth = scanner.nextInt();
        int yearOfBirth = scanner.nextInt();
        Date birthDate = new Date();
        //System.out.println(birthDate.getYear());
        while (dateOfBirth > 31 || mounthOfBirth > 12 || yearOfBirth > birthDate.getYear() + 1900 - 7) {
            System.out.println("pls,reenter dateOfBirth");
            dateOfBirth = scanner.nextInt();
            mounthOfBirth = scanner.nextInt();
            yearOfBirth = scanner.nextInt();
        }

        birthDate.setDate(dateOfBirth);
        birthDate.setMonth(mounthOfBirth);
        birthDate.setYear(yearOfBirth - 1900);
        String address = scanner.nextLine();
        System.out.println("Enter Address: ");
        address = scanner.nextLine();
        System.out.println("Enter phoneNumber");
        String phoneNumber = scanner.nextLine();
        while (!phoneNumber.matches("[0-9]+") || phoneNumber.length() != 10) {
            System.out.println("phonenumber must contain only number and have a lenght of 10 :");
            phoneNumber = scanner.nextLine();
        }

        Date isDate = new Date();
        Date expDate = new Date();
        expDate.setYear(isDate.getYear() + 7);
        //REGISTER HERE -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_
        UserData uData = new UserData(id, name, surname, gender, nationality, religion, birthDate, phoneNumber, address, expDate, isDate, blood);
        this.addLogs(id, name, surname, gender, nationality, religion, birthDate, phoneNumber, address, expDate, isDate, blood);
        uData.WriteData(DATAPATH_SRC + id);
        this.WriteKeyList(DATAPATH_SRC + "keylist");

    }

    public UserData Login(String id, String password) {
        for (int i = 0; i < key.size(); i++) {

            if (key.get(i).getId().equals(id)) {
                if (key.get(i).getPassword().equals(password))
                    return key.get(i).ReadData();
                else {
                    System.out.println("WrongPassword");
                    return new UserData();
                }

            }
        }
        if (id.equals("admin") && password.equals("admin"))
            this.adminMode();
        System.out.println("UserNotFound/AdminModeEnded");
        return new UserData();
    }

    @Override
    public String toString() {
        return "UserkeyList{" +
                "key=" + key +
                ", adminLogs=" + adminLogs +
                '}';
    }

    public ArrayList<adminLog> getAdminLogs() {
        return adminLogs;
    }


    public UserData getUserData(String id) {
        for (int i = 0; i < key.size(); i++) {
            if (key.get(i).getId().equals(id)) {
                return key.get(i).ReadData();

            }
        }
        return null;
    }

    public boolean delete(String id) {
        for (int i = 0; i < key.size(); i++) {

            if (key.get(i).getId().equals(id)) {
                File file = new File(key.get(i).getDataPath());
                file.delete();
                key.remove(i);
                System.out.println("finish delete file,");
                return true;

            }
        }
        System.out.println("file not found");
        return false;
    }

    public void adminMode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("adminMode ON!!");
        int inp = 99;
        int stage = 99;

        while (inp != 0) {
            stage = inp;

            switch (stage) {
                case 99:
                    System.out.println("******************");
                    System.out.println("[1]manageAccount");
                    System.out.println("[2]register");
                    System.out.println("[3]deleteAccount");
                    System.out.println("[9]showAdminLogs");
                    System.out.println("[0]Exit");
                    while ((inp < 0 || inp > 3) && inp != 9) {
                        try {
                            System.out.println("Enter The Number");
                            inp = sc.nextInt();
                            stage = inp;
                        } catch (Exception ex) {
                            System.exit(0);
                            break;
                        }
                    }
                    break;
                case 0:
                    inp = 0;
                    break;
                case 1:
                    System.out.println("******************");
                    //System.out.println(key.size());
                    if (key.size() > 0) {
                        int mUser;
                        if (key.size() > 1) {
                            System.out.println("What user do you want to manage :" + key.size());
                            for (int i = 0; i < key.size(); i++) {
                                System.out.println("User [" + (i + 1) + "] " + key.get(i).getId());
                            }
                            System.out.print("\nChoose user [UserNumber] or [0]to go back : ");

                            mUser = sc.nextInt();
                            while (mUser < 0 || mUser > key.size()) {
                                System.out.println("Enter the number in range of the array : ");
                                inp = sc.nextInt();
                            }
                            if (inp == 0) {
                                stage = 99;
                                break;
                            }

                        } else {
                            mUser = 1;
                        }


                        while (inp != 0) {
                            //System.out.println("debug" + "MU:"+mUser + " INP:" + inp + " STAGE" + stage);
                            System.out.println("******************");
                            UserData uk = key.get(mUser - 1).ReadData();
                            System.out.println(uk.toString());
                            System.out.println("[1]Id");
                            System.out.println("[2]Password");
                            System.out.println("[3]Name");
                            System.out.println("[4]Surname");
                            System.out.println("[5]Gender");
                            System.out.println("[6]nationlity");
                            System.out.println("[7]address");
                            System.out.println("[8]picturePath");
                            System.out.println("[9]Bank");
                            System.out.println("[10]Phone");
                            System.out.println("[11]BloodGroup");
                            System.out.println("[0]Back");
                            inp = sc.nextInt();

                            while (inp < 0 || inp > 11) {
                                System.out.println("please enter the number in range of menu");
                                inp = sc.nextInt();
                            }

                            UserData cofigData = key.get(mUser - 1).ReadData();
                            String prevState, nextState;
                            switch (inp) {
                                case 1:
                                    System.out.println("Enter New Id");
                                    prevState = key.get(mUser - 1).getId();
                                    File delFile = new File(key.get(mUser - 1).getDataPath());
                                    sc.nextLine();
                                    nextState = sc.nextLine();
                                    key.get(mUser - 1).setId(nextState);
                                    key.get(mUser - 1).setDataPath(DATAPATH_SRC + key.get(mUser - 1).getId());
                                    //System.out.println("Debug"+key.get(mUser).getId());
                                    cofigData.setId(key.get(mUser - 1).getId());
                                    delFile.delete();
                                    this.addLogs("User : " + (mUser - 1) + " Change id", prevState, nextState);
                                    break;
                                case 2:
                                    System.out.println("Enter New Password");
                                    prevState = key.get(mUser - 1).getPassword();
                                    sc.nextLine();
                                    String newpassword = sc.nextLine();
                                    key.get(mUser - 1).setPassword(newpassword);
                                    this.addLogs("User : " + (mUser - 1) + " Change password", prevState, newpassword);
                                    break;
                                case 3:
                                    System.out.println("Enter New Name");
                                    prevState = cofigData.getName();
                                    sc.nextLine();
                                    nextState = sc.nextLine();
                                    cofigData.setName(nextState);
                                    this.addLogs("User : " + (mUser - 1) + " Change name", prevState, nextState);
                                    break;
                                case 4:
                                    System.out.println("Enter New Surname");
                                    prevState = cofigData.getSurname();
                                    sc.nextLine();
                                    nextState = sc.nextLine();
                                    cofigData.setSurname(nextState);
                                    this.addLogs("User : " + (mUser - 1) + " Change surname", prevState, nextState);
                                    break;
                                case 5:
                                    System.out.println("Enter New Gender [M,F,O]");
                                    prevState = cofigData.getGender();
                                    String gender = sc.nextLine();
                                    while (!(gender.equals("M") || gender.equals("m") || gender.equals("F") || gender.equals("f") || gender.equals("O") || gender.equals("o"))) {
                                        System.out.println("pls,Enter the gender in the right format");
                                        sc.nextLine();
                                        gender = sc.nextLine();
                                    }
                                    switch (gender) {
                                        case "M":
                                            gender = "Male";
                                            break;
                                        case "m":
                                            gender = "Male";
                                            break;
                                        case "F":
                                            gender = "Female";
                                            break;
                                        case "f":
                                            gender = "Female";
                                            break;
                                        case "o":
                                            gender = "Other";
                                            break;
                                        case "O":
                                            gender = "Other";
                                            break;
                                    }
                                    cofigData.setGender(gender);
                                    this.addLogs("User : " + (mUser - 1) + " Change gender", prevState, gender);
                                    break;
                                case 6:
                                    System.out.println("Enter New Nationlity");
                                    prevState = cofigData.getNationality();
                                    sc.nextLine();
                                    nextState = sc.nextLine();
                                    cofigData.setNationality(nextState);
                                    this.addLogs("User : " + (mUser - 1) + " Change nationlity", prevState, nextState);
                                    break;
                                case 7:
                                    System.out.println("Enter New Address");
                                    prevState = cofigData.getAddress();
                                    sc.nextLine();
                                    nextState = sc.nextLine();
                                    cofigData.setAddress(nextState);
                                    this.addLogs("User : " + (mUser - 1) + " Change name", prevState, nextState);
                                    break;
                                case 8:
                                    System.out.println("Enter New PicturePath");
                                    prevState = cofigData.getPicturePath();
                                    sc.nextLine();
                                    nextState = sc.nextLine();
                                    cofigData.setPicturePath(nextState);
                                    this.addLogs("User : " + (mUser - 1) + " Change picturepath", prevState, nextState);
                                    break;
                                case 9:
                                    int bInp = 4;
                                    while (bInp != 0) {
                                        System.out.println("******************");
                                        System.out.println("ManageAccount");
                                        System.out.println("[1]ManageAccount");
                                        System.out.println("[2]RegisterAccount");
                                        System.out.println("[3]DeleteAccount");
                                        System.out.println("[0]Back");
                                        bInp = sc.nextInt();
                                        while (bInp < 0 || bInp > 3) {
                                            System.out.println("pls,Enter the number in range of the menu");
                                            bInp = sc.nextInt();
                                        }
                                        switch (bInp) {
                                            case 1:
                                                System.out.println("******************");
                                                if (cofigData.accountList.size() > 0) {
                                                    System.out.println("ManageAccount");
                                                    int accountToManage;
                                                    if (cofigData.accountList.size() > 1) {
                                                        System.out.println("Choose Account To Manage");
                                                        for (int i = 0; i < cofigData.accountList.size(); i++)
                                                            System.out.println('[' + (i + 1) + "] " + cofigData.accountList.get(i).getName() + ' ' + cofigData.accountList.get(i).getAccountNumber() + ' ' + cofigData.accountList.get(i).getBalance());
                                                        accountToManage = sc.nextInt();
                                                    } else {
                                                        accountToManage = 1;
                                                    }
                                                    int configMenuInp = 1000;
                                                    while (configMenuInp != 0) {

                                                        System.out.println(cofigData.accountList.get(accountToManage - 1).toString());
                                                        System.out.println("[1]ChangeName");
                                                        System.out.println("[2]ChangeAccountNumber");
                                                        System.out.println("[3]ChangeBalance");
                                                        System.out.println("[4]ChangePassword");
                                                        System.out.println("[0]Back");
                                                        configMenuInp = sc.nextInt();
                                                        while (configMenuInp < 0 || configMenuInp > 4) {
                                                            System.out.println("Enter the number within range of menu");
                                                            configMenuInp = sc.nextInt();
                                                        }
                                                        switch (configMenuInp) {
                                                            case 1:
                                                                System.out.println("Enter New Account Name");
                                                                prevState = cofigData.accountList.get(accountToManage - 1).getName();
                                                                sc.nextLine();
                                                                String AccountNameChangeInp = sc.nextLine();
                                                                cofigData.accountList.get(accountToManage - 1).setName(AccountNameChangeInp);
                                                                this.addLogs("User : " + (mUser - 1) + " -> Account : " + (accountToManage - 1) + " Change name", prevState, AccountNameChangeInp);
                                                                break;
                                                            case 2:
                                                                System.out.println("Enter New Account Number");
                                                                prevState = cofigData.accountList.get(accountToManage - 1).getAccountNumber();
                                                                String AccountNumberChangeInp = sc.nextLine();
                                                                for (int i = 0; i < key.size(); i++) {
                                                                    UserData tmpUser = key.get(i).ReadData();
                                                                    for (int j = 0; j < tmpUser.accountList.size(); j++) {
                                                                        if (tmpUser.accountList.get(j).getAccountNumber().equals(AccountNumberChangeInp)) {
                                                                            System.out.println("This Account Number is Being Used Pls Enter the New One");
                                                                            AccountNumberChangeInp = sc.nextLine();
                                                                            i = 0;
                                                                            j = 0;
                                                                        }
                                                                    }

                                                                }
                                                                cofigData.accountList.get(accountToManage - 1).setAccountNumber(AccountNumberChangeInp);
                                                                this.addLogs("User : " + (mUser - 1) + " -> Account : " + (accountToManage - 1) + " Change number", prevState, AccountNumberChangeInp);
                                                                break;
                                                            case 3:
                                                                System.out.println("Enter New Balance");
                                                                prevState = Double.toString(cofigData.accountList.get(accountToManage - 1).getBalance());
                                                                double balanceInp = sc.nextDouble();
                                                                cofigData.accountList.get(accountToManage - 1).setBalance(balanceInp);
                                                                this.addLogs("User : " + (mUser - 1) + " -> Account : " + (accountToManage - 1) + " Change balance", prevState, Double.toString(balanceInp));
                                                                break;
                                                            case 4:
                                                                System.out.println("Enter New Password");
                                                                prevState = cofigData.accountList.get(accountToManage - 1).getPassword();
                                                                String tmpNewPassword = sc.nextLine();
                                                                tmpNewPassword = sc.nextLine();
                                                                System.out.println(tmpNewPassword);
                                                                cofigData.accountList.get(accountToManage - 1).setPassword(tmpNewPassword);
                                                                this.addLogs("User : " + (mUser - 1) + " -> Account : " + (accountToManage - 1) + " Change password", prevState, tmpNewPassword);
                                                                break;

                                                        }
                                                    }


                                                } else {
                                                    System.out.println("You Have No Account To Config");

                                                }
                                                break;

                                            case 2:
                                                System.out.println("******************");
                                                System.out.println("RegisterAccount");
                                                Account creatingAccount = new Account();
                                                System.out.println("Enter Name Of Account");
                                                sc.nextLine();
                                                String RegisterName = sc.nextLine();
                                                creatingAccount.setName(RegisterName);
                                                System.out.println("Enter Your Balance");
                                                double RegisterBalance = sc.nextDouble();
                                                creatingAccount.setBalance(RegisterBalance);
                                                System.out.println("Enter Your Account Number");
                                                String tmpAccountNubmer = sc.nextLine();
                                                tmpAccountNubmer = sc.nextLine();
                                                //System.out.println(tmpAccountNubmer);
                                                creatingAccount.setAccountNumber(tmpAccountNubmer);
                                                cofigData.accountList.add(creatingAccount);
                                                System.out.println("Enter Your Password");
                                                String tmpAccountPassword = sc.nextLine();
                                                tmpAccountPassword = sc.nextLine();
                                                creatingAccount.setPassword(tmpAccountPassword);
                                                this.addLogs("User : " + (mUser - 1) + " Register Account", "name:" + RegisterName + ",balance:" + RegisterBalance + ",accountNumber:" + tmpAccountNubmer + ",password:" + tmpAccountPassword);
                                                break;
                                            case 3:
                                                System.out.println("******************");
                                                if (cofigData.accountList.size() > 0) {
                                                    System.out.println("Choose Account to Delete or [0] To Go Back");
                                                    for (int i = 0; i < cofigData.accountList.size(); i++)
                                                        System.out.println('[' + (i + 1) + "] " + cofigData.accountList.get(i).getName() + ' ' + cofigData.accountList.get(i).getAccountNumber() + ' ' + cofigData.accountList.get(i).getBalance());
                                                    int deleteAccountInp = sc.nextInt();
                                                    while (deleteAccountInp < 0 || deleteAccountInp > cofigData.accountList.size()) {
                                                        System.out.println("pls,Choose Account in range of the list");
                                                        deleteAccountInp = sc.nextInt();
                                                    }
                                                    Account temp = cofigData.accountList.get(deleteAccountInp - 1);
                                                    this.addLogs("User : " + (mUser - 1) + " Delete Account", "name:" + temp.getName() + ",balance:" + temp.getBalance() + ",accountNumber:" + temp.getAccountNumber() + ",password:" + temp.getPassword());
                                                    cofigData.accountList.remove(deleteAccountInp - 1);

                                                } else {
                                                    System.out.println("You Have No Account To Delete");
                                                }
                                                break;
                                        }
                                    }
                                    break;

                                case 10:

                                    int phoneInp = 1000;
                                    while (phoneInp != 0) {
                                        System.out.println("******************");
                                        System.out.println(cofigData.phone.toString());
                                        System.out.println("Manage Your Phone :");
                                        System.out.println("[1]Change Phone Number");
                                        System.out.println("[2]Change Package");
                                        System.out.println("[0]Back");
                                        phoneInp = sc.nextInt();
                                        while (phoneInp < 0 || phoneInp > 2) {
                                            switch (phoneInp) {
                                                case 1:
                                                    System.out.println("Enter new Phone number");
                                                    String newPhoneNumber = sc.nextLine();
                                                    prevState = key.get(mUser - 1).ReadData().phone.getPhoneNumber();
                                                    for (int i = 0; i < key.size(); i++) {
                                                        if (key.get(i).ReadData().phone.getPhoneNumber().equals(newPhoneNumber)) {
                                                            System.out.println("This Number is Being Used pls,Enter Again");
                                                            newPhoneNumber = sc.nextLine();
                                                            i = 0;
                                                        }
                                                    }
                                                    this.addLogs("User : " + (mUser - 1) + " Change phone number", prevState, newPhoneNumber);
                                                    cofigData.phone.setPhoneNumber(newPhoneNumber);
                                                    break;
                                                case 2:
                                                    System.out.println("Test");
                                                    System.out.println("Enter new price");
                                                    String t1 = cofigData.phone.getPrice(), t2 = cofigData.phone.getInternet(), t3 = cofigData.phone.getCallingTime();
                                                    sc.nextLine();
                                                    String tmpPrice = sc.nextLine();
                                                    System.out.println("Enter new internet");
                                                    sc.nextLine();
                                                    String tmpInternet = sc.nextLine();
                                                    System.out.println("Enter new callingtime");
                                                    sc.nextLine();
                                                    String tmpCallingTime = sc.nextLine();
                                                    Date dateNow = Calendar.getInstance(new Locale("en", "TH")).getTime();
                                                    DateFormat dateformat = new SimpleDateFormat("dd MM Y");
                                                    String dateNowS = dateformat.format(dateNow);
                                                    cofigData.phone.changePackage(tmpPrice, dateNowS, tmpInternet, tmpCallingTime);
                                                    this.addLogs("User : " + (mUser - 1) + " Change package",
                                                            "price:" + t1 + ",internet:" + t2 + ",callingTime:" + t3,
                                                            "price:" + tmpPrice + ",internet:" + tmpInternet + ",callingTime:" + tmpCallingTime);
                                                    break;

                                            }
                                        }
                                    }


                                    break;

                                case 11:
                                    String tempBloodGroup;
                                    System.out.println("Enter New Blood Group");
                                    prevState = cofigData.getGroupLaed();
                                    tempBloodGroup = sc.nextLine();
                                    cofigData.setGroupLaed(tempBloodGroup);
                                    this.addLogs("User : " + (mUser - 1) + " Change blood group", prevState, tempBloodGroup);
                                    break;

                            }
                            key.get(mUser - 1).WriteData(cofigData);
                        }
                        inp = 99;
                        break;
                    } else {
                        System.out.println("it's not thing to manage");
                        inp = 99;
                        break;
                    }

                case 2:
                    System.out.println("******************");
                    System.out.println("Regiter Account");
                    this.Register();
                    inp = 99;
                    break;

                case 3:
                    System.out.println("******************");
                    if (key.size() > 0) {
                        System.out.println("What user do you want to delete");
                        for (int i = 0; i < key.size(); i++) {
                            System.out.println("User [" + (i + 1) + "] " + key.get(i).getId());
                        }
                        System.out.println("\nChoose user [UserNumber] or [0] to go back : ");
                        inp = sc.nextInt();

                        if (inp == 0) {
                            inp = 99;
                            break;
                        }

                        while (inp < 0 || inp > key.size()) {
                            System.out.println("Enter the number in range of the array : ");
                            inp = sc.nextInt();
                        }

                        this.addLogs("Delete Account", "id:" + key.get(inp - 1).getId() + ",password:" + key.get(inp - 1).getPassword() + ",dataPath:" + key.get(inp - 1).getDataPath());
                        this.delete(key.get(inp - 1).getId());
                        inp = 99;
                        break;

                    } else
                        System.out.println("it's not thing to delete");
                    inp = 99;
                    break;

                case 9:
                    System.out.println("******************");
                    this.SHOWADMINLOGS();
                    inp = 99;
                    break;
            }
        }
    }
}

