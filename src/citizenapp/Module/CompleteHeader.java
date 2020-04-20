package citizenapp.Module;

import citizenapp.Account;
import citizenapp.AccountCheck;
import citizenapp.AccountList;
import citizenapp.FirstPage;
import citizenapp.History;
import citizenapp.HomeInfo;
import citizenapp.Log;
import citizenapp.PhoneInfo;
import database.UserData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Pair;

public class CompleteHeader {

    // ไฟล์รููปภาพ
    private static final String PATH_TO_BG1 = "src/citizenapp/img/92801.jpg";
    private static final String PATH_TO_BG2 = "src/citizenapp/img/2250.jpg";
    private static final String PATH_TO_BG3 = "src/citizenapp/img/grayBg.jpg";
    private static final String DATAPATH = "src/database/";

    public static String getDATAPATH() {
        return DATAPATH;
    }

    private static String PATH_TO_HUMANPIC = "src/citizenapp/img/ronaldo.jpg";


    private static String iden = "1101700292924";
    private static String firstName = "Paratthakorn";
    private static String priceS = "699";
    private static String dueDatePackage = "3 Apr 2020";
    private static String gbS = "20";

    public static UserData getUser1() {
        return user1;
    }

    private static String surName = "Sribunyong";
    private static String fullName = firstName + " " + surName;
    private static String gender = "Male"; // Gender
    private static String nation = "Thai"; // National
    private static String dob = "11 Dec 2000"; // Date
    private static String relig = "Christ"; // Religion
    private static String addr = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. "; //Address
    private static String doi = "12/12/2012"; // Date of Issue
    private static String doe = "12/11/2017"; // Date of Expiry
    private static String bloodGroup = "A";

	public static String getBloodGroup() {
		return bloodGroup;
	}

	public static void setBloodGroup(String bloodGroup) {
		CompleteHeader.bloodGroup = bloodGroup;
	}
    private static String phoneNumber = "0846657615";
    

    public static String getPATH_TO_HUMANPIC() {
        return PATH_TO_HUMANPIC;
    }


    public static void setIden(String iden) {
        CompleteHeader.iden = iden;
    }

    public static void setFirstName(String firstName) {
        CompleteHeader.firstName = firstName;
    }

    public static void setPriceS(String priceS) {
        CompleteHeader.priceS = priceS;
    }

    public static void setDueDatePackage(String dueDatePackage) {
        CompleteHeader.dueDatePackage = dueDatePackage;
    }

    public static void setGbS(String gbS) {
        CompleteHeader.gbS = gbS;
    }

    public static void setMinS(String minS) {
        CompleteHeader.minS = minS;
    }

    public static void setMainBg(ImageView mainBg) {
        CompleteHeader.mainBg = mainBg;
    }

    public static void setSecondBg(ImageView secondBg) {
        CompleteHeader.secondBg = secondBg;
    }

    public static void setBalance(double balance) {
        CompleteHeader.balance = balance;
    }

    public static void setSurName(String surName) {
        CompleteHeader.surName = surName;
    }

    public static void setFullName(String fullName) {
        CompleteHeader.fullName = fullName;
    }

    public static void setGender(String gender) {
        CompleteHeader.gender = gender;
    }

    public static void setNation(String nation) {
        CompleteHeader.nation = nation;
    }

    public static void setDob(String dob) {
        CompleteHeader.dob = dob;
    }

    public static void setRelig(String relig) {
        CompleteHeader.relig = relig;
    }

    public static void setAddr(String addr) {
        CompleteHeader.addr = addr;
    }

    public static void setDoi(String doi) {
        CompleteHeader.doi = doi;
    }

    public static void setDoe(String doe) {
        CompleteHeader.doe = doe;
    }

    public static void setPhoneNumber(String phoneNumber) {
        CompleteHeader.phoneNumber = phoneNumber;
    }

    public void setNavBar(HBox navBar) {
        this.navBar = navBar;
    }

    public static void setStage1(Stage stage1) {
        CompleteHeader.stage1 = stage1;
    }

    public static void setPhoneInfoScene(Scene phoneInfoScene) {
        CompleteHeader.phoneInfoScene = phoneInfoScene;
    }

    public static void setHistoryScene(Scene historyScene) {
        CompleteHeader.historyScene = historyScene;
    }


    public static void setUser1(UserData user1) {
        CompleteHeader.user1 = user1;
    }

    public static void setPhoneObj(PhoneInfo phoneObj) {
        CompleteHeader.phoneObj = phoneObj;
    }

    public static void setPATH_TO_HUMANPIC(String PATH_TO_HUMANPIC) {
        CompleteHeader.PATH_TO_HUMANPIC = PATH_TO_HUMANPIC;
    }

    private static String minS = "150";
    private static ImageView mainBg = new ImageView();
    private static ImageView secondBg = new ImageView();
    private static double balance = 30000.00;


    public static String getPATH_TO_BG3() {
        return PATH_TO_BG3;
    }


    public static String getIden() {
        return iden;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static String getSurName() {
        return surName;
    }

    public static String getFullName() {
        return fullName;
    }

    public static String getGender() {
        return gender;
    }

    public static String getNation() {
        return nation;
    }

    public static String getDob() {
        return dob;
    }

    public static String getRelig() {
        return relig;
    }

    public static String getAddr() {
        return addr;
    }

    public static String getDoi() {
        return doi;
    }

    public static String getDoe() {
        return doe;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static String getPriceS() {
        return priceS;
    }

    public static String getDueDatePackage() {
        return dueDatePackage;
    }

    public static String getGbS() {
        return gbS;
    }

    public static String getMinS() {
        return minS;
    }

    public static double getBalance() {
        return balance;
    }

    public HBox getNavBar() {
        return navBar;
    }


    public static Stage getStage1() {
        return stage1;
    }

    public static Scene getAccountListScene() {
        return accountListScene;
    }

    public static Scene getHomeInfoScene() {
        return HomeInfoScene;
    }

    public static Scene getPhoneInfoScene() {
        return phoneInfoScene;
    }

    public static Scene getHistoryScene() {
        return historyScene;
    }


    private HBox navBar = new HBox();

    /**
     * Label fullNameLabeLabel fullNameLabel = new Label();l = new Label();
     * fullNameLabel.setTextFill(Color.WHITE);
     * fullNameLabel.setText(fullName);
     * fullNameLabel.setFont(Font.font("MV Boli", 15));
     * fullNameLabel.setLayoutX(500);
     * fullNameLabel.setLayoutY(40);
     */
//	private	static Label fullNameLabel = new Label();
    private static Stage stage1 = new Stage();
    private static Scene accountListScene;
    private static Scene HomeInfoScene;
    private static Scene phoneInfoScene;
    private static Scene historyScene;
    private static AccountList accountList;
    private static DropShadow hoverIconEffect = new DropShadow();
    private static DropShadow activeIconEffect = new DropShadow();


    private static UserData user1;

    private static PhoneInfo phoneObj;
    private static boolean isFirstTime = true;

    public CompleteHeader(Stage stage, UserData user) throws Exception {
//		UserkeyList u = new UserkeyList("src/database/keylist");

	user1 = user;
	System.out.println(user1.toString());
//		System.out.println(user1.toString());
//		System.out.println(user1.getId());
//		System.out.println(user1.getName());
//		System.out.println(user1.getSurname());
//		System.out.println(user1.getGender());
//		System.out.println(user1.getNationality());
//		System.out.println(user1.getDateOfBirth());
//		System.out.println(user1.getReligion());
//		System.out.println(user1.getAddress());
//		System.out.println(user1.getDateOfIssue());
//		System.out.println(user1.getDateExpire());
//		System.out.println(user1.getPhone().getPhoneNumber());
//		System.out.println(user1.getPhone().getPrice());
//		System.out.println((user1.getDateFormat().format(user1.getPhone().getBillingDate())));
//		System.out.println(user1.getPhone().getInternet());
//		System.out.println(user1.getPhone().getCallingTime());
//		System.out.println(user1.getBalance());

        setIden(user1.getId());
	

        setFirstName(user1.getName());
        setSurName(user1.getSurname());
        setFullName(user1.getName() + " " + user1.getSurname());
        setGender(user1.getGender());
	    
        setNation(user1.getNationality());
	
	setBloodGroup(user1.getGroupLaed());
	
        setDob(user1.getDateOfBirth());
	
        setRelig(user1.getReligion());
        setAddr(user1.getAddress());
        setDoi(user1.getDateOfIssue());
	
        setDoe(user1.getDateExpire());
        setPhoneNumber(user1.getPhone().getPhoneNumber());
        setPriceS(user1.getPhone().getPrice());
	
        setDueDatePackage(user1.getPhone().getBillingDate());
        setGbS(user1.getPhone().getInternet());
        setMinS(user1.getPhone().getCallingTime());
	
  
	
        setPATH_TO_HUMANPIC(user1.getPicturePath());
	
	
        //Set up info
        stage1 = stage;
        stage1.setResizable(false);
	stage1.setOnCloseRequest(e -> {
		System.out.println("Save Log");
                user1.WriteData("src/database/" + user1.getId());
	});
	    

        HomeInfo h1 = new HomeInfo(iden, firstName, surName, gender, nation, dob, relig, addr, doi, doe, bloodGroup);
        HomeInfoScene = h1.getScene();
        AccountList a1 = new AccountList(user1, firstName, surName, phoneNumber);
        accountListScene = a1.getScene();
        accountList = a1;
        PhoneInfo p1 = new PhoneInfo(phoneNumber, priceS, dueDatePackage, gbS, minS, balance);
        phoneObj = p1;
        phoneInfoScene = p1.getScene();
        History.start();
        stage1.setScene(HomeInfoScene);
        stage1.setX(440);
        stage1.setY(140);

        //Set effect
        hoverIconEffect.setWidth(15);
        hoverIconEffect.setHeight(15);
        hoverIconEffect.setRadius(5.0);
        hoverIconEffect.setColor(Color.WHITESMOKE);

        activeIconEffect.setWidth(15);
        activeIconEffect.setHeight(15);
        activeIconEffect.setRadius(5.0);
        activeIconEffect.setColor(Color.GREY);
    }

    public static PhoneInfo getPhoneObj() {
        return phoneObj;
    }

    public static ImageView getMainBg() throws FileNotFoundException {
        //Primary Background
        Image img1 = new Image(new FileInputStream(PATH_TO_BG1));
        mainBg.setImage(img1);
        mainBg.setFitWidth(800);
        mainBg.setFitHeight(600);
        return mainBg;
    }

    public static ImageView getSecondBg() throws FileNotFoundException {
        //Secondary Background
        Image img2 = new Image(new FileInputStream(PATH_TO_BG2));
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

        return secondBg;
    }

    public static HBox getLogo() throws Exception {
        Text text = new Text("Citizen");
        ImageView bg = new ImageView();
        HBox hbox = new HBox();
        Image icon = new Image(new FileInputStream("src/citizenapp/img/CircleLogo.png"));
        text.setFont(Font.font("Baloo Thambi 2", 72));
        text.setStyle("-fx-fill: #9B8B8B; -fx-stroke: white; -fx-stroke-width: 2px");
        bg.setImage(icon);
        hbox.getChildren().addAll(text, bg);
        hbox.setLayoutX(20);
        hbox.setLayoutY(20);
        return hbox;
    }

    public static HBox getNavbar() throws Exception {
        //HomeInfo

        //Home
        TextWithIcon homeIcon = new TextWithIcon("Home", "Home.png");
        homeIcon.getHbox().addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent event) -> {
            event.consume();

            homeIcon.getText().setEffect(hoverIconEffect);
            homeIcon.getImage().setEffect(hoverIconEffect);
        });
        homeIcon.getHbox().addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent event) -> {
            event.consume();
            homeIcon.getText().setEffect(null);
            homeIcon.getImage().setEffect(null);
        });
        homeIcon.getHbox().addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            event.consume();
	    
//			System.out.println(user1.toString());
            homeIcon.getText().setEffect(activeIconEffect);
            homeIcon.getImage().setEffect(activeIconEffect);
            stage1.setScene(HomeInfoScene);
            stage1.setX(stage1.getX());
            stage1.setY(stage1.getY());
        });
        //Phone
        TextWithIcon phoneIcon = new TextWithIcon("Phone", "Phone.png");
        phoneIcon.getHbox().addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent event) -> {
            event.consume();

            phoneIcon.getText().setEffect(hoverIconEffect);
            phoneIcon.getImage().setEffect(hoverIconEffect);
        });
        phoneIcon.getHbox().addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent event) -> {
            event.consume();
            phoneIcon.getText().setEffect(null);
            phoneIcon.getImage().setEffect(null);
        });
        phoneIcon.getHbox().addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            event.consume();
//			System.out.println(user1.toString());
            phoneIcon.getText().setEffect(activeIconEffect);
            phoneIcon.getImage().setEffect(activeIconEffect);
            stage1.setScene(PhoneInfo.getScene());
            stage1.setX(stage1.getX());
            stage1.setY(stage1.getY());
        });
        //Bank
        TextWithIcon bankIcon = new TextWithIcon("Bank", "Bank.png");
        bankIcon.getHbox().addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent event) -> {
            event.consume();

            bankIcon.getText().setEffect(hoverIconEffect);
            bankIcon.getImage().setEffect(hoverIconEffect);
        });
        bankIcon.getHbox().addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent event) -> {
            event.consume();
            bankIcon.getText().setEffect(null);
            bankIcon.getImage().setEffect(null);
        });
        bankIcon.getHbox().addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            event.consume();
            bankIcon.getText().setEffect(activeIconEffect);
            bankIcon.getImage().setEffect(activeIconEffect);
//			System.out.println(user1.toString());
//			System.out.println("User account size : " + CompleteHeader.getUser1().getAccountList().size());
//			System.out.println("Current account size : " + Account.getAccountList().size());

            try {
//				System.out.println(Account.getAccountBox().size());
                AccountCheck.setPayphone(false);
                for (int i = 0; i < Account.getAccountBox().size(); i++) {
                    //Set before goto accountList
                    Account.getAccountList().get(i).getNameText().setFont(Font.font("Neucha", 20));
                    Account.getAccountList().get(i).getAccNumText().setFont(Font.font("Neucha", 20));
                    Account.getAccountBox().get(i).setPrefWidth(500);
                    Account.getAccountList().get(i).getNameText().setWrappingWidth(300);
                    AccountList.getVBox1().getChildren().add(Account.getAccountBox().get(i));
                }
            } catch (Exception e) {
            }

            stage1.setScene(accountListScene);
            stage1.setX(stage1.getX());
            stage1.setY(stage1.getY());
        });
        //History
        TextWithIcon historyIcon = new TextWithIcon("History", "Bookmark.png");
        historyIcon.getHbox().addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent event) -> {
            event.consume();

            historyIcon.getText().setEffect(hoverIconEffect);
            historyIcon.getImage().setEffect(hoverIconEffect);
        });
        historyIcon.getHbox().addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent event) -> {
            event.consume();
            historyIcon.getText().setEffect(null);
            historyIcon.getImage().setEffect(null);
        });

        historyIcon.getHbox().addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            event.consume();
//			System.out.println(user1.toString());
            historyIcon.getText().setEffect(activeIconEffect);
            historyIcon.getImage().setEffect(activeIconEffect);
            try {
                History.start();
            } catch (Exception ex) {
                Logger.getLogger(CompleteHeader.class.getName()).log(Level.SEVERE, null, ex);
            }
            stage1.setScene(History.getScene());
            stage1.setX(stage1.getX());
            stage1.setY(stage1.getY());
        });
        //Setting
        TextWithIcon settingIcon = new TextWithIcon("Setting", "Setting.png");
        settingIcon.getHbox().addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent event) -> {
            event.consume();

            settingIcon.getText().setEffect(hoverIconEffect);
            settingIcon.getImage().setEffect(hoverIconEffect);
        });
        settingIcon.getHbox().addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent event) -> {
            event.consume();
            settingIcon.getText().setEffect(null);
            historyIcon.getImage().setEffect(null);
        });
	 settingIcon.getHbox().addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            event.consume();
	    user1.getLogy().clear();
	    Log.getLogList().clear();
	    System.out.println("Clean Log");
        });

        //Top HBox
        HBox hbox = new HBox(20);
        hbox.setPrefHeight(44);
        hbox.setPrefWidth(600);
        hbox.getChildren().add(homeIcon.active());
        hbox.getChildren().add(bankIcon.active());
        hbox.getChildren().add(phoneIcon.active());
        hbox.getChildren().add(historyIcon.active());
        hbox.getChildren().add(settingIcon.active());
        hbox.setLayoutY(80);
        hbox.setLayoutX(280);

        return hbox;
    }

    public static VBox getTopRight() throws Exception {
        VBox topRightBox = new VBox();
        TextWithIcon logoutIcon = new TextWithIcon("Log out", "logout.png");
        logoutIcon.getText().setFont(Font.font("MV Boli", 10));
        logoutIcon.getImage().setFitWidth(20);
        logoutIcon.getImage().setFitHeight(20);
        logoutIcon.getText().setWrappingWidth(150);
        logoutIcon.getText().setTextAlignment(TextAlignment.RIGHT);
        topRightBox.setLayoutX(600);
        topRightBox.setLayoutY(10);
        topRightBox.setPadding(new Insets(0, 100, 0, 0));
        topRightBox.getChildren().addAll(logoutIcon.active());
        logoutIcon.getHbox().addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent event) -> {
            event.consume();

            logoutIcon.getText().setEffect(hoverIconEffect);
            logoutIcon.getImage().setEffect(hoverIconEffect);
        });
        logoutIcon.getHbox().addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent event) -> {
            event.consume();
            logoutIcon.getText().setEffect(null);
            logoutIcon.getImage().setEffect(null);
        });
        logoutIcon.getHbox().addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            event.consume();
            try {
                AccountList.getVBox1().getChildren().clear();
                Account.getAccountList().clear();
                Account.getAccountBox().clear();
                user1.WriteData("src/database/" + user1.getId());
                FirstPage f1 = new FirstPage();
                f1.start(stage1);


            } catch (Exception ex) {
                Logger.getLogger(CompleteHeader.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return topRightBox;

    }

    public void setAccountListScene(Scene scene) {
        this.accountListScene = scene;
    }

    public void setHomeInfoScene(Scene scene) {
        this.HomeInfoScene = scene;
    }

    public static String getPATH_TO_BG1() {
        return PATH_TO_BG1;
    }

    public static String getPATH_TO_BG2() {
        return PATH_TO_BG2;
    }

    public static Stage getStage() {
        return stage1;
    }

    public static void setMoney(double money) {
        balance = money;
    }


}
