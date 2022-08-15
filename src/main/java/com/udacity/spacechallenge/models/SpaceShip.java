package com.udacity.spacechallenge.models;

public interface SpaceShip {
    boolean launch();
    boolean land();
    boolean canCarry(Item item);
    void carry(Item item); //updates weight of the rocket
}
