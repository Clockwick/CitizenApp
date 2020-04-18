/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 *
 * @author admin
 */
public class UserKey implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String password;
    private String dataPath;

    public UserKey(String id, String password, String dataPath) {
        this.id = id;
        this.password = password;
        this.dataPath = dataPath;
    }
    
    public UserData ReadData() {
        try {

                FileInputStream fileIn = new FileInputStream(dataPath);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                UserData wUserData = (UserData) objectIn.readObject();
                objectIn.close();
                return wUserData;

        }catch(IOException | ClassNotFoundException ex) {
                System.out.println("UserKeyReadDataFail");
                return new UserData();
        }
    }
    
    public void WriteData(UserData data){
        System.out.println("saved to "+dataPath);
        data.WriteData(dataPath);
        
    }
    
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getDataPath() {
        return dataPath;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDataPath(String dataPath) {
        this.dataPath = dataPath;
    }

    @Override
    public String toString() {
        return "UserKey{" + "id=" + id + ", password=" + password + ", dataPath=" + dataPath + '}';
    }
    
    
}
