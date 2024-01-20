package edu.gatech.cs1331.hw06;

public class Cat extends Pet {
    private int miceCaught;

    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        this.miceCaught = Math.max(miceCaught, 0);
    }

    public Cat(String name, double health, int painLevel) {
        this(name, health, painLevel, 0);
    }

    public int getMiceCaught() {
        return miceCaught;
    }

    @Override
    public int treat() {
        int tTime;

        if (miceCaught < 4) {
            tTime = (int) Math.ceil((getPainLevel() * 2) / getHealth());
        } else if (miceCaught <= 7) {
            tTime = (int) Math.ceil(getPainLevel() / getHealth());
        } else {
            tTime = (int) Math.ceil(getPainLevel() / (getHealth() * 2));
        }

        heal();

        return tTime;
    }

    public void speak() {
        super.speak();
        String sound = (getPainLevel() > 5) ? "MEOW" : "meow";
        String out = "";

        for (int i = 1; i <= miceCaught; i++) {
            out += sound;
        }

        System.out.println(out.trim());
    }

    public boolean equals(Object o) {
        return (super.equals(o) && (((Cat) o).miceCaught == miceCaught));
    }
}
