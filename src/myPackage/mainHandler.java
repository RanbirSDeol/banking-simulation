/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myPackage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ranbir
 * @ 
 */
public class mainHandler {
    
    // Our bank branches
    static String[] bankBranches = {"CB Branch Brampton", "CB Branch Townsvilla", "CB Branch Longtown", "CB Branch Toronto", "CB Branch USA", "CB Branch Mexico"};
    
    private static ArrayList<user> userList = new ArrayList(); // List of all our users [no data saving, only restricted to session]
    private static Set<Integer> existingAccountNumbers = new HashSet<>(); // A list of all our users account IDs
    private static Random rnd = new Random(); 
    
    // Generating a accNo value
    public static int generateID() {
        int tempID = 100000 + rnd.nextInt(90000000); // 8 Digit Random Number
        return tempID;
    }
    
    // Generating a accNo for our new user 
    public static int generateAccountNo() {
        // If our userList is empty [won't ever be, but just incase we remove users]
        if (userList.isEmpty()) {
            return generateID();
        }
        
        // We'll loop until we generate a new and unique ID
        while (true) {
            int id = generateID();
            if (!existingAccountNumbers.contains(id)) {
                return id;
            }
        }
    }
    
    /**
     * This function generates a new account for the user using the registerFrame
     * 
     * @param accNo: the account number of the user [unique]
     * @param accHolderName: the account users name
     * @param balance: the accounts balance
     * @param address: the address of the user
     * @param password: the password of the account
     * @param bankBranch: the bank branch the user registered with
     * @return returns the status of the generation, success or an error message that'll display
     */
    public static String generateNewUser(int accNo, String accHolderName, BigDecimal balance, String address,
            String password, String bankBranch) {
        
        // Here let's check to make sure our values are valid [We already did a soft check from the registerFrame]
        
        // Let's check if this person already has an account
        
        for (user localUser : userList) {
            if (accHolderName.equals(localUser.getAccName())) {
                if (address.equals(localUser.getAddress())) {
                    // Same address and name, they must be the same person
                    return "This User Already Has An Account!";
                }
            }
        }
        
        // Let's make sure their name doesn't have any characters other than letters
        
        // Regular expression to check if the name contains only letters
        String lettersOnlyRegex = "^[A-Za-z ]+$";

        // Check if accHolderName contains only letters
        if (!accHolderName.matches(lettersOnlyRegex)) {
            return "Invalid Name!\nName's Don't Contain Numbers";
        }
        
        // Let's make sure they have a valid address
        // Format: [Two Numbers+] [Space] [Street, Length > 3]
        
        // Regex to match format
        String regexAddress = "^\\d{2,}\\s.+"; // \d{2,} matches two or more digits
        Pattern patternAddress = Pattern.compile(regexAddress);
        Matcher matcherAddress = patternAddress.matcher(address);
        
        if (matcherAddress.matches() == false) {
            return "Invalid Address\n\n[Address Format]:\n[Two Numbers][Street, Length Greater Than 3]";
        }
        
        
        // Let's check if they have a valid password
        // Conditions: [One Capital] [One Lowercase] [Length > 7]
        
        String regexPassword = "^(?=.*[a-z])(?=.*[A-Z]).{8,}$"; // Regex to make our conditions
        Pattern patternPassword = Pattern.compile(regexPassword);
        Matcher matcherPassword = patternPassword.matcher(password);
        
        // Return whether the password matches the regex
        if (matcherPassword.matches() == false) {
            return "Invalid Password\n\n[Passmust Must Contain]:\n1 Uppercase, 1 Lowercase, and a Length Greater Than 7";
        }
        
        // If we pass all the conditions, let's create the account and register it!
        
        ArrayList<String> transactions = new ArrayList<>(); // Transactions will be empty, new account
        user newUser = new user(accNo, accHolderName, balance, address, password, bankBranch, transactions); // Feeding the params
        userList.add(newUser); // Adding our new user to our list
        existingAccountNumbers.add(accNo); // Adding the users ID to our list, since here we've done all our checks
        
        return "Success"; 
    }
    
    /**
     * attemptLogin is a function where we attempt to log in the user 
     * with his username and password, if they don't match we alert to loginFrame
     * 
     * @param accountNumber: account number of the user
     * @param password: password for the account number
     * @return 
     */
    public static String attemptLogin(String accountNumber, String password) {
        for (user localUser : userList) {
            if (Integer.parseInt(accountNumber) == localUser.getAccNo()) {
                // Account Number's Matched
                if (password.equals(localUser.getPassword())) {
                    return "Success";
                } else {
                    // Maybe add reset password feature in the future?
                }
            }
        }
        return "Username or Password Incorrect!";
    }
    
    /**
     * This function starts the mainHandler, it runs after the loadingFrame has finished loading
     */
    public static void run() {
        // Creating our "Admin" user, it'll be used for testing
        BigDecimal initialBalance = new BigDecimal("24.2");
        ArrayList<String> initialTransactions = new ArrayList<>();
        user adminUser = new user(generateAccountNo(), "Admin", initialBalance, "31 Main Street", "Admin12345", bankBranches[0], initialTransactions);
        System.out.println("Admin ID: " + adminUser.getAccNo());
        
        // Adding the admin user, this is a testing account
        userList.add(adminUser);
    }
    
    public static void main(String args[]) {
        
    }
}
