package com.oreilly.hfjava.game;

import java.util.ArrayList;

public class SimpleStartupGame {

    public static void main(String[] args) {
        int numberOfGuesses = 0;
        GameHelper helper = new GameHelper();
        DotCom startup = new DotCom();

        int randomNum = (int) (Math.random() * 5);
        ArrayList<String> locations = new ArrayList<String>();

        locations.add(String.valueOf(randomNum));
        locations.add(String.valueOf(randomNum + 1));
        locations.add(String.valueOf(randomNum + 2));

        startup.setLocationCells(locations);

        boolean isAlive = true;
        
        while (isAlive) {
            String guess = helper.getUserInput("enter a number");
            String result = startup.checkYourself(guess);
            numberOfGuesses++;

            if (result.equals("kill")) {
                isAlive = false;
                System.out.println("You took " + numberOfGuesses + " guesses");
            }
        }
    }
}
