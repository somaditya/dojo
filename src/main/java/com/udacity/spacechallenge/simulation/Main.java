package com.udacity.spacechallenge.simulation;

import com.udacity.spacechallenge.models.Item;
import com.udacity.spacechallenge.models.Rocket;
import com.udacity.spacechallenge.models.U1;
import com.udacity.spacechallenge.models.U2;

import java.util.ArrayList;

public class Main {
    static final String PHASE_1 = "src/main/java/com/udacity/spacechallenge/phase-1.txt";
    static final String PHASE_2 = "src/main/java/com/udacity/spacechallenge/phase-2.txt";
    public static void main(String[] args) {
        Simulation simulation = new Simulation();

        ArrayList<Item> phase1Items = simulation.loadItems(PHASE_1);
        ArrayList<Item> phase2Items = simulation.loadItems(PHASE_2);

        ArrayList<U1> u1Phase1 = simulation.loadU1(phase1Items);
        ArrayList<U1> u1Phase2 = simulation.loadU1(phase2Items);

        ArrayList<Rocket> u1Rockets = new ArrayList<>();
        u1Phase1.forEach(u1 -> u1Rockets.add(u1));
        u1Phase2.forEach(u1 -> u1Rockets.add(u1));

        System.out.println("U1 Budget: $" + simulation.runSimulation(u1Rockets));

        ArrayList<U2> u2Phase1 = simulation.loadU2(phase1Items);
        ArrayList<U2> u2Phase2 = simulation.loadU2(phase2Items);

        ArrayList<Rocket> u2Rockets = new ArrayList<>();
        u2Phase1.forEach(u1 -> u2Rockets.add(u1));
        u2Phase2.forEach(u1 -> u2Rockets.add(u1));

        System.out.println("U2 Budget: $" + simulation.runSimulation(u2Rockets));
    }
}
