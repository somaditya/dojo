package edu.gatech.cs1331.hw06;

public abstract class Pet {
    private String name;
    private double health;
    private int painLevel;

    /**
     * @param name
     * @param health
     * @param painLevel
     */
    public Pet(String name, double health, int painLevel) {
        this.name = name;

        if (health >= 1.0) {
            this.health = 1.0;
        } else if (health <= 0.0) {
            this.health = 0.0;
        } else {
            this.health = health;
        }

        if (painLevel >= 10) {
            this.painLevel = 10;
        } else if (painLevel <= 1) {
            this.painLevel = 1;
        } else {
            this.painLevel = painLevel;
        }
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public int getPainLevel() {
        return painLevel;
    }

    public abstract int treat();

    public void speak() {
        String out = String.format("Hello, My name is %s", name);
        out = (painLevel > 5) ? out.toUpperCase() : out;
        System.out.println(out);
    }

    protected void heal() {
        health = 1.0;
        painLevel = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        return name.equals(pet.name);
    }
}
