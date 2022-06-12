package com.oreilly.hfjava.game;

import java.util.ArrayList;

public class DotCom {
    ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String checkYourself(String userInput) {
        String result = "miss";
        int index = locationCells.indexOf(userInput);

        if (index >= 0) {
            locationCells.remove(userInput);

            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("You sank: " + name);
            } else {
                result = "hit";
            }
        }

        return result;
    }
}
