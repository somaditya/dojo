package com.udacity.spacechallenge.models;

import java.util.Objects;

public class Rocket implements SpaceShip {
    final int cost;
    final int weight;
    int cargo;
    final int max_weight;

    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public int getMax_weight() {
        return max_weight;
    }

    public Rocket(int cost, int weight, int cargo, int max_weight) {
        this.cost = cost;
        this.weight = weight;
        this.cargo = cargo;
        this.max_weight = max_weight;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return (weight + cargo + item.getWeight()) <= max_weight;
    }

    @Override
    public void carry(Item item) {
        cargo += item.getWeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rocket rocket = (Rocket) o;
        return cost == rocket.cost && weight == rocket.weight && cargo == rocket.cargo && max_weight == rocket.max_weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, weight, cargo, max_weight);
    }
}
