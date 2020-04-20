/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;

/**
 * @author admin
 */
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String accountNumber;
    private double balance;
    private String password;
    private int countClick = 0;
    Account() {
        this.countClick = 0;
    }

    public int compareTo(Account b) {
        if (this.countClick > b.countClick) return 1;
        if (this.countClick < b.countClick) return -1;
        return 0;
    }

    public int getCountClick() {
        return countClick;
    }

    public void setCountClick(int countClick) {
        this.countClick = countClick;
    }

    public void addClick() {
        ++this.countClick;
    }

    public void addClick(int t) {
        this.countClick = this.countClick + t;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Account{" + "name=" + name + ", accountNumber=" + accountNumber + ", balance=" + balance + '}';
    }


}