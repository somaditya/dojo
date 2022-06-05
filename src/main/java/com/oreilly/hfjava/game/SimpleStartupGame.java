package com.oreilly.hfjava.game;

public class SimpleStartupGame {

    public static void main(String[] args) {
        int numberOfGuesses = 0;

        GameHelper helper = new GameHelper();

        SimpleStartup startup = new SimpleStartup();

        int randomNum = (int) (Math.random() * 5);

        int[] locations = {randomNum, randomNum + 1, randomNum + 2};

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
