package com.Godmode;

public class Hamburger {
    private String name;
    private String breadType;
    private String meat;
    private double price;

    private String addOn1Name;
    private double addOn1Price;

    private String addOn2Name;
    private double addOn2Price;

    private String addOn3Name;
    private double addOn3Price;

    private String addOn4Name;
    private double addOn4Price;

    public Hamburger(String name, String breadType, String meat, double price) {
        this.name = name;
        this.breadType = breadType;
        this.meat = meat;
        this.price = price;
    }

    public void addHamburgerAddition1(String name, double price) {
        this.addOn1Name = name;
        this.addOn1Price = price;
    }

    public void addHamburgerAddition2(String name, double price) {
        this.addOn2Name = name;
        this.addOn2Price = price;
    }

    public void addHamburgerAddition3(String name, double price) {
        this.addOn3Name = name;
        this.addOn3Price = price;
    }

    public void addHamburgerAddition4(String name, double price) {
        this.addOn4Name = name;
        this.addOn4Price = price;
    }

    public double itemizeHamburger() {
        double hamburgerPrice = this.price;
        System.out.println(this.name + " hamburger on a " + this.breadType
                + " roll, the price is: " + this.price);
        if (this.addOn1Name != null) {
            hamburgerPrice += addOn1Price;
            System.out.println("Added " + addOn1Name + " for a price of " + addOn1Price);
        }

        if (this.addOn2Name != null) {
            hamburgerPrice += addOn2Price;
            System.out.println("Added " + addOn2Name + " for a price of " + addOn2Price);
        }

        if (this.addOn3Name != null) {
            hamburgerPrice += addOn3Price;
            System.out.println("Added " + addOn3Name + " for a price of " + addOn3Price);
        }

        if (this.addOn4Name != null) {
            hamburgerPrice += addOn4Price;
            System.out.println("Added " + addOn4Name + " for a price of " + addOn4Price);
        }
        return hamburgerPrice;
    }

}
