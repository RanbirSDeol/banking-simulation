/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myPackage;

/**
 *
 * @author Ranbir
 * Desc: This class is how we handle our transactions, it'll be used to create a
 * transaction object, which we can use to better handle and organize transactions
 * from within the mainHandler
 */
public class transaction {
    static String[] transactionTypes = {"Withdraw", "Deposit", "E-Transfer"};
    
    String ID; // The ID of the transaction
    String transactionType; // The type of transaction
    String amount; // The amount that the transaction
    String from; // The starting account
    String to; // The recieving account
    
    // Constructor
    
    transaction(String ID, String transactionType, String amount, String from, String to) {
        this.ID = ID;
        this.transactionType = transactionType;
        this.amount = amount;
        this.from = from;
        this.to = to;
    }
    
    // Accessors
    
    public String getID() {
        return this.ID;
    }
    
    public String getTransactionType() {
        return this.transactionType;
    }
    
    public String getAmount() {
        return this.amount;
    }
    
    public String getFrom() {
        return this.from;
    }
    
    public String getTo() {
        return this.to;
    }
}
