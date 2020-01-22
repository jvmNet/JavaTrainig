package com.javarush.task.task15.task1529;

public class Plane implements CanFly, IAmountPassengers {

    private int amountPassengers;

    public Plane(int amountPassengers) {
        this.amountPassengers = amountPassengers;
    }

    public int getAmountPassengers() {
        return amountPassengers;
    }

    @Override
    public void fly() {
        // TODO ...
    }
}
