/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
/**
 *
 * @author admin
 */ 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author arthris
 */
public class adminLog implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date timeS;
	private String detailS;

	private static ArrayList<adminLog> logList = new ArrayList<>();

	public static ArrayList<adminLog> getLogList() {
		return logList;
                
	}
	
	public adminLog(Date time, String detail) {
		this.timeS = time;
		this.detailS = detail;
                
	}
	

	public static void add(adminLog e) {
		logList.add(e);
                
	}
        
        public ArrayList<adminLog> getLog(){
            return this.logList;
            
        }
        
        public void setLog(ArrayList<adminLog> inp){
            this.logList = inp;
            
            
        }
	
	public String toString() {
		return this.timeS + " " + this.detailS;
	}
	
	
}

