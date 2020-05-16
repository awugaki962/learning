package com.Godmode.Challenge;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arry = getIntegers(5);
        int[] sorted = sortIntegers(arry);
        printArray(sorted);
    }

    public static int[] getIntegers(int numbers) {
        int[] intArray = new int[numbers];
        System.out.println("Enter " + numbers + " integers:\r");

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = scanner.nextInt();
        }
        return intArray;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Array " + (i + 1) + " element is " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        boolean flag = true;
        int temp;
        while (flag) {
            flag = false;
            for (int i = 0; i < newArray.length - 1; i++) {
                if (newArray[i] < newArray[i + 1]) {
                    temp = newArray[i];
                    newArray[i] = newArray[i + 1];
                    newArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
//        int max = Integer.MAX_VALUE;
//        int min = Integer.MIN_VALUE;
//        for (int i = 0; i < newArray.length; i++) {
//            for (int j = 0; j < array.length; j++) {
//                if (array[j] > min && array[j] < max) {
//                    min = array[j];
//                    newArray[i] = min;
//                }
//            }
//            min = Integer.MIN_VALUE;
//            max = newArray[i];
//        }
        return newArray;
    }
}
