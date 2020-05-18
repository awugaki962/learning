package com.Godmode;

public class Main {

    public static void main(String[] args) {
	Dog dog = new Dog("Yorkie");
	dog.breathe();
	dog.eat();

	Parrot bird = new Parrot("Gyurrrika");
	bird.breathe();
	bird.eat();
	bird.fly();

	Penguin penguin = new Penguin("Toty");
	penguin.fly();
    }
}
