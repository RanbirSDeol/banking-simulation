/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myPackage;

import java.awt.List;
import java.math.BigDecimal;
import java.util.ArrayList;
/**
 *
 * @author Ranbir
 */
public class user extends mainHandler {
    // Info for a user registered with this bank
    
    private int accNo; // Users account number
    private String accHolderName; // Users account holder name
    private BigDecimal balance; // Users balance
    private String address; // Users address
    private String password; // Users password
    private String bankBranch; // The user's bank's name
    private String phoneNumber; // The user's phone number
    private String emailAddress; // The user's email address;
    // Here we'll add the banking accounts [No need to construct this yet]
    private ArrayList<String> transactions; // Users transactions
    
    // Constructor
    user(int accNo, String accHolderName, BigDecimal balance, String address,
            String password, String bankBranch, String phoneNumber, String emailAddress, ArrayList<String> transactions) {
        this.accNo = accNo;
        this.accHolderName = accHolderName;
        this.balance = balance;
        this.address = address;
        this.password = password;
        this.bankBranch = bankBranch;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.transactions = transactions;
    }
    
    // Methods
    
    // Accessors
    
    public int getAccNo() {
        return this.accNo;
    }
    
    public String getAccName() {
        return this.accHolderName;
    }
    
    public BigDecimal getBalance() {
        return this.balance;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getBankBranch(){
        return this.bankBranch;
    }
    
    public ArrayList<String> getTransactions() {
        return this.transactions;
    }
}

