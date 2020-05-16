package com.Godmode;

public class Main {

    public static void main(String[] args) {
        System.out.println(calcFeetAndInchesToCentimeters(-10));
    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inch) {
        if (feet >= 0 && (inch >= 0 && inch <= 12)) {
            return (inch * 2.54 + feet * 12 * 2.54);
        }
        System.out.println("Invalid");
        return -1;
    }

    public static double calcFeetAndInchesToCentimeters(double inch) {
        if (inch >= 0) {
            double feet = (int) inch / 12;
            double remain = (int) inch % 12;
            return calcFeetAndInchesToCentimeters(feet, remain);
        }
        return -1;
    }
}
