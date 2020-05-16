package com.Godmode.Challenge;

public class Main {
    public static void main(String[] args) {
    Printer printer = new Printer(true);

    printer.fillUpToner(50);
    System.out.println(printer.getPagesPrinted());
    printer.printing(13);
    printer.printing(65);
    printer.getTonerLevel();
    printer.fillUpToner(10);
    }
}
