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
    private String address; // Users address
    private String password; // Users password
    private String bankBranch; // The user's bank's name
    private String phoneNumber; // The user's phone number
    private String emailAddress; // The user's email address;
    // Here we'll add the banking accounts [No need to construct this yet]
    private ArrayList<transaction> transactions; // Users transactions
    // Let's add the types of banking here
    private double balanceSavings = 0;
    private double balanceChequing = 0;
    private double balanceVisa = 0; 
    private double visaLimit = 2000; // Basic limit for visa
    
    
    // Constructor
    user(int accNo, String accHolderName, double deposit, String address,
            String password, String bankBranch, String phoneNumber, String emailAddress, ArrayList<transaction> transactions) {
        this.accNo = accNo;
        this.accHolderName = accHolderName;
        this.balanceSavings = deposit;
        this.address = address;
        this.password = password;
        this.bankBranch = bankBranch;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.transactions = transactions;
    }
    
    // Methods
    
    public void updateTransactions(transaction t) {
        this.transactions.add(t);
    }
    
    public void internalTransfer(String from, String to, double amount) {
        System.out.println(from + " | " + to + " | " + amount);
        switch (from) {
            case "Chequing" -> {
                if (to.equals("Savings")) {
                    // Chequing -> Savings
                    this.balanceChequing -= amount;
                    this.balanceSavings += amount;
                } else if (to.equals("Visa")) {
                    // Chequing -> Visa
                    this.balanceChequing -= amount;
                    this.balanceVisa += amount;
                }
            }
            case "Savings" -> {
                if (to.equals("Chequing")) {
                    // Savings -> Chequing
                    System.out.println("HERE");
                    this.balanceSavings -= amount;
                    this.balanceChequing += amount;
                } else if (to.equals("Visa")) {
                    // Savings -> Visa
                    this.balanceSavings -= amount;
                    this.balanceVisa += amount;
                }
            }
            case "Visa" -> {
                if (to.equals("Chequing")) {
                    // Visa -> Chequing
                    this.balanceVisa -= amount;
                    this.balanceChequing += amount;
                } else if (to.equals("Savings")) {
                    // Visa -> Savings
                    this.balanceVisa -= amount;
                    this.balanceSavings += amount;
                }
            }
            default -> {
            }
        }
    }
    
    public void externalTransfer() {
        
    }
    
    // Accessors
    
    public int getAccNo() {
        return this.accNo;
    }
    
    public String getAccName() {
        return this.accHolderName;
    }
    
    public double getSavings() {
        return this.balanceSavings;
    }
    
    public double getChequing(){
        return this.balanceChequing;
    }
    
    public double getVisa() {
        return this.balanceVisa;
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
    
    public String getPhoneNum() {
        return this.phoneNumber;
    }
    
    public String getEmail(){
        return this.emailAddress;
    }
    
    public ArrayList<transaction> getTransactions() {
        return this.transactions;
    }
}

