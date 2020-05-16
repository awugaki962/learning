package com.Godmode;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	DB db = new DB();
	User u = new User("Béla", "Szekszárd");

//	db.addUser(u);
//	db.preparedAddUser("Géza", "Budapest");
	db.showUsersMeta();
	db.showAllUsers();

//	ArrayList<User> users = db.getAllUsers();
//	for (User u : users) {
//	    System.out.println(u.getName());
//	}

    }
}