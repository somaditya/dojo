package com.udacity.spacechallenge;

public class Rocket implements SpaceShip {
    int cost;
    int weight;
    int cargo;
    int max_weight;

    public Rocket(int cost, int weight, int cargo, int max_weight) {
        this.cost = cost;
        this.weight = weight;
        this.cargo = cargo;
        this.max_weight = max_weight;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return (weight + cargo + item.getWeight()) <= max_weight;
    }

    @Override
    public void carry(Item item) {
        cargo += item.getWeight();
    }
}
