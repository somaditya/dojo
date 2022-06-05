package com.oreilly.hfjava.game;

public class SimpleStartup {
    int[] locationCells;
    int numberOfHits = 0;

    public void setLocationCells(int[] locs) {
        locationCells = locs;
    }

    public String checkYourself(String userGuess) {
        int guess = Integer.parseInt(userGuess);

        String result = "miss";

        for (int cell : locationCells) {
            if (guess == cell) {
                result = "hit";
                numberOfHits++;

                break;
            }
        }

        if (numberOfHits == locationCells.length) {
            result = "kill";
        }

        System.out.println(result);

        return result;
    }
}
