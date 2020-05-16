package com.Godmode;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("06/70-320-8668");

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        startPhone();
        printInstructions();

        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Shutting down...");
                    quit = true;
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printInstructions();
                    break;
            }

        }
    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To shutdown");
        System.out.println("\t 1 - To print the contact list");
        System.out.println("\t 2 - To add a contact to your contact list");
        System.out.println("\t 3 - To update a contact on the contact list");
        System.out.println("\t 4 - To remove a contact from the contact list");
        System.out.println("\t 5 - To query the contacts on the contact list");
        System.out.println("\t 6 - To print the available actions");
    }

    private static void printContacts() {
        mobilePhone.printContacts();
    }

    private static void addNewContact() {
        System.out.print("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String number = scanner.nextLine();
        Contact newContact = Contact.createContact(name, number);
        if (mobilePhone.addContact(newContact)) {
            System.out.printf("New contact added: name = %s, number = %s\n", name, number);
        } else {
            System.out.printf("Cannot add, %s is already on file.\n", name);
        }
    }

    private static void updateContact() {
        System.out.println("Enter the existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Enter the new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter the new contact number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if (mobilePhone.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating the record");
        }
    }

    private static void removeContact() {
        System.out.println("Enter the existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        if (mobilePhone.removeContact(existingContactRecord)) {
            System.out.println("Successfully deleted contact");
        } else {
            System.out.println("Error deleting the contact");
        }
    }

    private static void queryContact() {
        System.out.println("Enter the existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.printf("Name: %s, phone number is: %s\n",
                existingContactRecord.getName(), existingContactRecord.getPhoneNumber());
    }
}
