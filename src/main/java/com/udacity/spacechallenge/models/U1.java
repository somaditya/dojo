package com.udacity.spacechallenge.models;

public class U1 extends Rocket {

    public U1() {
        super(100000000, 10000, 0, 18000);
    }

    public U1(int cost, int weight, int cargo, int max_weight) {
        super(cost, weight, cargo, max_weight);
    }

    @Override
    public boolean launch() {
        double explosionProbability = 0.05 * ( (float) cargo / (max_weight - weight) );
        double random = Math.random();

        if (random <= explosionProbability) {
            return false;
        }

        return true;
    }

    @Override
    public boolean land() {
        double crashProbability = 0.01 * ( (float) cargo / (max_weight - weight) );
        double random = Math.random();

        if (random <= crashProbability) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "U1{" +
                "cost=" + cost +
                ", weight=" + weight +
                ", cargo=" + cargo +
                ", max_weight=" + max_weight +
                '}';
    }
}
