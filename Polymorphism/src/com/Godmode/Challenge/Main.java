package com.Godmode.Challenge;

class Car {
    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;
    private int speed;

    public Car(String name, int cylinders) {
        this.name = name;
        this.engine = true;
        this.cylinders = cylinders;
        this.wheels = 4;
    }

    public String getName() {
        return name;
    }

    public String startEngine() {
        return getClass().getSimpleName() + " -> startEngine";
    }

    public String accelerate() {
        return getClass().getSimpleName() + " -> accelerate";
    }

    public String brake() {
        return getClass().getSimpleName() + " -> brake";
    }
}

class Tesla extends Car {
    public Tesla(String name) {
        super(name, 0);
    }

    @Override
    public String startEngine() {
        return getClass().getSimpleName() + " -> startEngine";
    }

    @Override
    public String accelerate() {
        return getClass().getSimpleName() + " -> accelerate";
    }

    @Override
    public String brake() {
        return getClass().getSimpleName() + " -> decelerate";
    }
}

class VW extends Car {
    public VW(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public String startEngine() {
        return getClass().getSimpleName() + " -> startEngine";
    }

    @Override
    public String accelerate() {
        return getClass().getSimpleName() + " -> accelerate";
    }

    @Override
    public String brake() {
        return getClass().getSimpleName() + " -> decelerate";
    }
}

public class Main {
    public static void main(String[] args) {
    Car car = new Car("Base car", 8);
    System.out.println(car.startEngine());
    System.out.println(car.accelerate());
    System.out.println(car.brake());

    Tesla tesla = new Tesla("Tesla");
    System.out.println(tesla.startEngine());
    System.out.println(tesla.accelerate());
    System.out.println(tesla.brake());

    VW vw = new VW("VW", 4);
    System.out.println(vw.startEngine());
    System.out.println(vw.accelerate());
    System.out.println(vw.brake());
    }
}
