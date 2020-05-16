package com.Godmode;

public class Main {

    public static void main(String[] args) {
	double one = 20.00;
	double two = 80.00;
	double result = (one + two) * 100.00;
	double remainder = result % 40.00;
	boolean whatWas = remainder == 0 ? true : false;

	System.out.println(whatWas);
    if (whatWas == false) {
        System.out.println("Gpt some remainder");
    }
    }
}
