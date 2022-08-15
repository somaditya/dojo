package com.udacity.nd079.polymorphism;

public class Boat extends Vehicle {

    public Boat() {
        super("Boat start", "Boat stop", "Boat speed", "Boat direction");
    }

    @Override
    public void speed() {
        System.out.println("Boat class method.");
    }
}
