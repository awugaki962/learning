package com.Godmode;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("Raiffeisen Bank");

        bank.addBranch("Budapest");
        bank.addCustomer("Budapest", "Gergő", 100.05);
        bank.addCustomer("Budapest", "Tim", 111.34);
        bank.addCustomer("Budapest", "John", 95.6);

        bank.addBranch("Sydney");
        bank.addCustomer("Sydney", "Bob", 63.56);

        bank.addCustomerTransaction("Budapest", "Gergő", 44.22);
        bank.addCustomerTransaction("Budapest", "Gergő", 1.64);
        bank.addCustomerTransaction("Budapest", "Tim", 41.12);

        bank.listCustomers("Budapest", true);
        bank.listCustomers("Sydney", true);

//        bank.addBranch("Melbourne");

        if (!bank.addCustomer("Melbourne", "Brian", 5.55)) {
            System.out.println("Error Melbourne branch does not exists");
        }

        if (!bank.addBranch("Budapest")) {
            System.out.println("Budapest branch already exists");
        }

        if (!bank.addCustomerTransaction("Budapest", "Jim", 53.55)) {
            System.out.println("Customer does not exists at branch");
        }

        if (!bank.addCustomer("Budapest", "Gergő", 4.51)) {
            System.out.println("Customer already exists");
        }
    }
}
