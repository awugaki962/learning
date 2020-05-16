package com.Godmode;

public class Fish extends Animal{

    private int gills;
    private int eyes;
    private int fins;

    public Fish(String name, int brain, int body, int size, int weight,
                int gills, int eyes, int fins) {
        super(name, 1, 1, size, weight);
        this.gills = gills;
        this.eyes = eyes;
        this.fins = fins;
    }

    private void rest() {
        System.out.println("Fishes rest");
    }

    private void moveMuscles() {
        System.out.println("Fishes move the muscles");
    }

    private void moveBackFin() {
        System.out.println("Fishes move the back fin");
    }

    private void swim(int speed) {
        moveMuscles();
        moveBackFin();
        super.move(speed);
    }
}
