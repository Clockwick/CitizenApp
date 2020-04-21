/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
/**
 * @author admin
 */

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

/**
 * @author arthris
 */
public class adminLog implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date timeS;
    private String detailS;
    private String head;

    public adminLog() {
        this(new Date(), "", "");
    }

    public String getDetailString() {
        return detailS;
    }

    public String getDateString() {
        DateFormat t = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return t.format(this.timeS);
    }

    public adminLog(Date time, String head, String detail) {
        this.timeS = time;
        this.detailS = detail;
        this.head = head;

    }

    public void setString(String detailS) {
        this.detailS = detailS;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "adminLog{" +
                "timeS=" + timeS +
                ", detailS='" + detailS + '\'' +
                ", head='" + head + '\'' +
                '}';
    }
}

