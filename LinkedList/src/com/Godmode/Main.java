package com.Godmode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    LinkedList<String> placesToVisit = new LinkedList<>();
	    addInOrder(placesToVisit, "Sydney");
	    addInOrder(placesToVisit,"Melbourne");
	    addInOrder(placesToVisit,"Brisbane");
	    addInOrder(placesToVisit,"Perth");
	    addInOrder(placesToVisit,"Canberra");
	    addInOrder(placesToVisit,"Adelaide");
	    addInOrder(placesToVisit,"Darwin");
	    addInOrder(placesToVisit,"Perth");

	    visit(placesToVisit);
    }

    private static void printlist(LinkedList<String> linkedList) {
	    Iterator<String> i = linkedList.listIterator();
	    while (i.hasNext()) {
		    System.out.println("Now visiting: " + i.next());
	    }
	    System.out.println("==========================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
	    ListIterator<String> stringListIterator = linkedList.listIterator();

	    while (stringListIterator.hasNext()) {
	    	int comparison = stringListIterator.next().compareTo(newCity);
	    	if (comparison == 0) {
	    		//equal, no adding
			    System.out.println(newCity + " is already included as a destination");
			    return false;
		    } else if (comparison > 0) {
	    		//Brisbane -> Adelaide, need to move back
				stringListIterator.previous();
				stringListIterator.add(newCity);
				return true;
		    }
	    }
	    stringListIterator.add(newCity);
	    return true;
    }

    private static void visit(LinkedList cities) {
	    Scanner scanner = new Scanner(System.in);
	    boolean quit = false;
	    boolean goingForward = true;
	    ListIterator<String> listIterator = cities.listIterator();

	    if (cities.isEmpty()) {
		    System.out.println("No cities in the itinerary");
		    return;
	    } else {
		    System.out.println("Now visiting " + listIterator.next());
		    printMenu();
	    }
	    while (!quit) {
	    	int action = scanner.nextInt();
	    	scanner.nextLine();

	    	switch (action) {
			    case 0:
				    System.out.println("Vacation is over!");
				    quit = true;
				    break;
			    case 1:
			    	if (!goingForward) {
			    		if (listIterator.hasNext()) {
			    			listIterator.next();
					    }
			    		goingForward = true;
				    }
			    	if (listIterator.hasNext()) {
					    System.out.println("Now visiting: " + listIterator.next());
				    } else {
					    System.out.println("Reached the end of the list");
					    goingForward = false;
				    }
				    break;
			    case 2:
			    	if (goingForward) {
			    		if (listIterator.hasPrevious()) {
			    			listIterator.previous();
					    }
			    		goingForward = false;
				    }
			    	if (listIterator.hasPrevious()) {
					    System.out.println("Now visiting: " + listIterator.previous());
				    } else {
					    System.out.println("We are at the start of the list");
					    goingForward = true;
				    }
				    break;
			    case 3:
			    	printMenu();
			    	break;
		    }
	    }
    }

    private static void printMenu() {
	    System.out.println("Avaible actions: \nPress ");
	    System.out.println("0 - to quit\n" +
			    "1 - go to the next\n" +
			    "2 - go to the previous\n" +
			    "3 - print the menu again");
    }
}
