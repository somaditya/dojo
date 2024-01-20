package edu.gatech.cs1331.hw06;

public class Dog extends Pet {
    private double droolRate;

    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        this.droolRate = (droolRate <= 0) ? 0.5 : droolRate;
    }

    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, 5.0);
    }

    public double getDroolRate() {
        return droolRate;
    }

    public int treat() {
        int tTime;

        if (droolRate < 3.5) {
            tTime = (int) Math.ceil((getPainLevel() * 2) / getHealth());
        } else if (droolRate <= 7.5) {
            tTime = (int) Math.ceil(getPainLevel() / getHealth());
        } else {
            tTime = (int) Math.ceil(getPainLevel() / (getHealth() * 2));
        }

        heal();
        return tTime;
    }

    public void speak() {
        super.speak();
        String sound = (getPainLevel() > 5) ? "BARK" : "bark";
        String out = "";

        for (int i = 1; i <= getPainLevel(); i++) {
            out = out + sound;
        }

        System.out.println(out.trim());
    }

    @Override
    public boolean equals(Object o) {
        return (super.equals(o) && ((Dog) o).droolRate == droolRate);
    }
}
