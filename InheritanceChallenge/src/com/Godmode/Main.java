package com.Godmode;

public class Main {

    public static void main(String[] args) {
        Tesla tesla = new Tesla("Sedan", 4,5,6,36);
        tesla.steer(45);
        tesla.accelerate(30);
        tesla.accelerate(-20);
    }
}
