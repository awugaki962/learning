package com.Godmode;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	int[] array = readIntegers(5);
	System.out.println(findMin(array));
    }

    private static int[] readIntegers(int count) {
        int[] intArray = new int[count];
        System.out.println("Enter " + count + " integers:\r");
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = scanner.nextInt();
        }
        return intArray;
    }

    private static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
