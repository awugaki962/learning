package com.Godmode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] intArray = {1, 2, 3, 4, 5};
	    reverse(intArray);
	    System.out.println(Arrays.toString(intArray));
    }

    private static void reverse(int[] array) {
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;
        for (int i = 0; i < halfLength; i++) {
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }
//        int counter = array.length;
//        int[] reversedArray = new int[counter];
//        for (int i = 0; i < reversedArray.length; i++) {
//            reversedArray[i] = array[counter - 1];
//            counter--;
//        }
//        array = reversedArray;
    }
}
