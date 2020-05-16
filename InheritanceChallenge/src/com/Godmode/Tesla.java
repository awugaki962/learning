package com.Godmode;

public class Tesla extends Car {
    private int roadServiceMonth;

    public Tesla(String size, int wheels, int doors, int gears, int roadService) {
        super("Tesla", size, wheels, doors, gears, false);
        this.roadServiceMonth = roadService;
    }

    public void accelerate(int rate) {
        int newVelocity = getCurrentVelocity() + rate;
        if (newVelocity == 0) {
            stop();
            changeGear(1);
        } else if (newVelocity > 0 && newVelocity <= 10) {
            changeGear(1);
        } else if (newVelocity > 10 && newVelocity <= 20) {
            changeGear(2);
        } else if (newVelocity > 20 && newVelocity <= 30) {
            changeGear(3);
        } else if (newVelocity > 30 && newVelocity <= 55) {
            changeGear(4);
        } else if (newVelocity > 55 && newVelocity <= 70) {
            changeGear(5);
        } else {
            changeGear(6);
        }
        if (newVelocity > 0) {
            changeVelocity(newVelocity, getCurrentDirection());
        }
    }
}
