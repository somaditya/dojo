package com.oreilly.hfjava.game;

import java.util.ArrayList;

class SimpleStartupTest {

    public static void main(String[] args) {
        Startup dot = new Startup();

        ArrayList<String> locations = new ArrayList<String>();
        locations.add("2");
        locations.add("3");
        locations.add("4");

        dot.setLocationCells(locations);

        String userGuess = "2";

        String result = dot.checkYourself(userGuess);

        String testResult = "failed";

        if (result.equals("hit")) {
            testResult = "passed";
        }

        System.out.println(testResult);
    }
}