package com.Godmode;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Player gergo = new Player("Gergő", 100, 80);
	System.out.println(gergo.toString());
	saveObject(gergo);

	gergo.setHitPoints(8);
	System.out.println(gergo);
	gergo.setWeapon("Stormbringer");
	saveObject(gergo);
//	loadObject(gergo);
	System.out.println(gergo);

	ISaveable werewolf = new Monster("Werewolf", 20, 40);
	System.out.println(werewolf);
	System.out.println("Strength = " + ((Monster) werewolf).getStrength());
	saveObject(werewolf);

    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.printf("Choose\n1 - to enter a string\n0 - to quit\n");

        while (!quit) {
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
                default:
                    System.out.println("Invalid");
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave) {
        for (int i = 0; i < objectToSave.write().size(); i++) {
            System.out.printf("Saving %s to storage device\n", objectToSave.write().get(i));
        }
    }

    public static void loadObject(ISaveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }
}
