package com.udacity.nd079.polymorphism;

public class VehicleTester {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car();
        vehicles[1] = new Plane();
        vehicles[2] = new Boat();

        for (Vehicle v : vehicles) {
            v.speed();
        }
    }
}
