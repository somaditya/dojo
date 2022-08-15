package com.udacity.spacechallenge.models;

public class U2 extends Rocket {

    public U2() {
        super(120000000, 18000, 0, 29000);
    }

    public U2(int cost, int weight, int cargo, int max_weight) {
        super(cost, weight, cargo, max_weight);
    }

    @Override
    public boolean launch() {
        double explosionProbability = 0.04 * ( (float) cargo / (max_weight - weight) );
        double random = Math.random();

        if (random <= explosionProbability) {
            return false;
        }

        return true;
    }

    @Override
    public boolean land() {
        double crashProbability = 0.08 * ( (float) cargo / (max_weight - weight) );
        double random = Math.random();

        if (random <= crashProbability) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "U2{" +
                "cost=" + cost +
                ", weight=" + weight +
                ", cargo=" + cargo +
                ", max_weight=" + max_weight +
                '}';
    }
}
