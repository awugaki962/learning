package com.Godmode;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal("Animal", 1, 1, 5, 5);
        Dog dog = new Dog("Yorkie", 8, 20, 2, 4, 1, 20, "Long");
//        Fish fish = new Fish();

        animal.eat();
        dog.eat();
//        dog.walk();
        dog.run();
    }
}
