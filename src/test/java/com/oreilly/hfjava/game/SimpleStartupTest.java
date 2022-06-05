package com.oreilly.hfjava.game;

class SimpleStartupTest {

    public static void main(String[] args) {
        SimpleStartup dot = new SimpleStartup();

        int[] locations = {2, 3, 4};

        dot.setLocationCells(locations);

        String userGuess = "2";

        String result = dot.checkYourself(userGuess);
    }
}