package com.udacity.spacechallenge;

public class U1 extends Rocket {

    public U1() {
        super(100000000, 10000, 0, 18000);
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
}
