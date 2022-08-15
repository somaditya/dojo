package com.udacity.spacechallenge.simulation;

import com.udacity.spacechallenge.models.Item;
import com.udacity.spacechallenge.models.Rocket;
import com.udacity.spacechallenge.models.U1;
import com.udacity.spacechallenge.models.U2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {
    Simulation simulation = new Simulation();
    static final String PHASE_1 = "src/main/java/com/udacity/spacechallenge/phase-1.txt";
    static final String PHASE_2 = "src/main/java/com/udacity/spacechallenge/phase-2.txt";

    @Test
    void loadItems() {
        ArrayList<Item> items = simulation.loadItems(PHASE_1);

        assertEquals(new Item("building tools", 2000), items.get(0));
        assertEquals(new Item("water", 5000), items.get(14));
    }

    @Test
    void loadU1() {
        assertEquals(new U1(100000000, 10000, 6000, 18000), simulation.loadU1(simulation.loadItems(PHASE_1)).get(0));
        assertEquals(new U1(100000000, 10000, 6000, 18000), simulation.loadU1(simulation.loadItems(PHASE_1)).get(8));
    }

    @Test
    void loadU2() {
        System.out.println(simulation.loadU2(simulation.loadItems(PHASE_1)));
        assertEquals(new U2(120000000, 18000, 11000, 29000), simulation.loadU2(simulation.loadItems(PHASE_1)).get(0));
        assertEquals(new U2(120000000, 18000, 5000, 29000), simulation.loadU2(simulation.loadItems(PHASE_1)).get(5));
    }

    @Test
    void runSimulation() {
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