package edu.gatech.cs1331.hw04;

public class Fly {
    private static final int DEFAULT_MASS = 5;
    private static final int DEFAULT_SPEED = 10;
    private double mass;
    private double speed;

    public Fly() {
        this(DEFAULT_MASS);
    }

    public Fly(double mass) {
        this(mass, DEFAULT_SPEED);
    }

    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    public double getMass() {
        return mass;
    }

    public double getSpeed() {
        return speed;
    }

    public void setMass(double mass) {
        if (mass > 0) this.mass = mass;
    }

    public void setSpeed(double speed) {
        if (speed > 0) this.speed = speed;
    }

    public void grow(int addMass) {
        if (mass >= 20) {
            speed -= 0.5 * addMass;
        } else if (mass + addMass < 28) {
            speed += addMass;
        } else {
            int before20 = 20 - (int) mass;
            int after20 = (int) mass + addMass - 20;
            speed += before20 - 0.5 * after20;
        }

        mass += addMass;
    }

    public boolean isDead() {
        return (mass == 0);
    }

    public String toString() {
        if (mass == 0) {
            return String.format("I'm dead, but I used to be a fly with a speed of %.2f.", speed);
        } else {
            return String.format("I'm a speedy fly with a %.2f speed and %.2f mass.", speed, mass);
        }
    }
}
