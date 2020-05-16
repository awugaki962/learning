package com.Godmode;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Main {

    public static void main(String[] args) {
//        BankAccount first = new BankAccount("12345", "Bob", "email@email.hu", "12345678910");
//        BankAccount second = new BankAccount();
//        BankAccount third = new BankAccount("", "","");
//
//        first.setBalance(100);
//        System.out.println(first.getBalance());
//        first.depositMoney(10);
//        first.withdrawMoney(25);

        VipCustomer person1 = new VipCustomer();
        System.out.println(person1.getName());

        VipCustomer person2 = new VipCustomer("Bob", "email@");
        System.out.println(person2.getName());

        VipCustomer person3 = new VipCustomer("Tim", 23, "tim@");
        System.out.println(person3.getName());
        System.out.println(person3.getEmail());
        }
}
