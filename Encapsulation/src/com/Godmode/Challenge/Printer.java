package com.Godmode.Challenge;

public class Printer {
    private double tonerLevel;
    private int pagesPrinted;
    private boolean isItDuplex;

    public Printer(boolean isItDuplex) {
        this.tonerLevel = 100.0;
        this.pagesPrinted = 0;
        this.isItDuplex = isItDuplex;
    }

    public void fillUpToner(int ink) {
        if ((this.tonerLevel + ink) <= 100) {
            this.tonerLevel += ink;
        }
        System.out.printf("Toner level is: %5.2f%n", tonerLevel);
    }

    public void printing(int pages) {
        System.out.println("Printing " + pages + " page(s)");
        if (isItDuplex) {
            pagesPrinted += (pages / 2) + (pages % 2);
        } else {
            pagesPrinted += pages;
        }
        tonerLevel -= pagesPrinted * 1.345;
        System.out.println("Total printed  " + pagesPrinted + " pages");
    }

    public void getTonerLevel() {
        System.out.printf("Toner level is: %5.2f%n", tonerLevel);
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
