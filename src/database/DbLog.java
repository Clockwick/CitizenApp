/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import citizenapp.Log;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author arthris
 */
public class DbLog {
	
	public static void writeLog(ArrayList<Log> logList, String path) {
		try {
 
		    FileOutputStream fileOut = new FileOutputStream(path);
		    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
		    objectOut.writeObject(logList);
		    objectOut.close();
		    System.out.println("File write at " + path);
            
 
		 } catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static ArrayList<Log> readLog(String path) throws IOException, ClassNotFoundException {
		FileInputStream fileIn = new FileInputStream(path);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                ArrayList<Log> rLog = (ArrayList<Log>) objectIn.readObject();
                objectIn.close();
		System.out.println("Read from " + path);
		
		return rLog;
	}
}
