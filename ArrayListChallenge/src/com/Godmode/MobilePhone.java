package com.Godmode;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts = new ArrayList<Contact>();

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already in the system!");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public void printContacts() {
        System.out.println("Contact list");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.printf("%d. %s -> %s\n", i + 1, myContacts.get(i).getName(),
                    myContacts.get(i).getPhoneNumber());
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if (position < 0) {
            System.out.printf("%s was not found.\n", oldContact.getName());
            return false;
        } else if (findContact(newContact.getName()) != -1){
            System.out.printf("Contact with name %s already exists!\n", newContact.getName());
            return false;
        }
        this.myContacts.set(position, newContact);
        System.out.printf("%s was replaced with %s.\n", oldContact.getName(), newContact.getName());
        return true;

    }

    public boolean removeContact(Contact contact) {
        int position = findContact(contact);
        if (position < 0) {
            System.out.printf("%s was not found.\n", contact.getName());
            return false;
        }
        this.myContacts.remove(position);
        System.out.printf("%s was deleted.\n", contact.getName());
        return true;
    }

    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }
}
