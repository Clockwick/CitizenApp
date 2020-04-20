/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp;


import javafx.application.Application;
import javafx.stage.Stage;
import database.UserkeyList;

/**
 *
 * @author arthris
 */
public class Main extends Application {
	
	private static final String PATH = "src/database/keylist"; 
	public static void main(String[] args) throws Exception {
		if (!true) {
			UserkeyList ukl = new UserkeyList(PATH);
//			ukl.WriteKeyList(PATH);
			ukl.Login("admin", "admin");
		}
		else launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		FirstPage p1 = new FirstPage();
		p1.start(stage);
	}
}
