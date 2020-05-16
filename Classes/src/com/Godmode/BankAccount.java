package com.Godmode;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount(String customerName, String email, String phoneNumber) {
        this("99999",  customerName, email, phoneNumber);
    }

    public BankAccount() {
        this("00000", "Unknown", "Default email",
                "Default phone");
        System.out.println("Empty constructor");
    }

    public BankAccount(String accountNumber, String customerName, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance > 0) {
            this.balance = balance;
        } else {
            System.out.println("Wrong amount, setting the balance failed!");
        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void depositMoney(double money) {
        System.out.println("Current balance is: " + this.getBalance());
        if (money > 0 ) {
            this.balance += money;
            System.out.println("Successfull deposit, balance is: " + this.getBalance());
        } else {
            System.out.println("Amount less than 0, deposit wasn't successfull!");
        }
    }

    public void withdrawMoney(double money) {
        if (balance > money && money > 0) {
            System.out.println("Current balance is: " + this.getBalance());
            this.balance -= money;
            System.out.println("Withdraw successfull, balance is: " + this.getBalance());
        } else if (money > 0){
            System.out.println("Too much to withdraw!");
            System.out.println("Your balance stayed: " + this.getBalance());
        } else {
            System.out.println("Withdraw should be over 0!");
        }
    }
}
