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
        ArrayList<Rocket> rockets = new ArrayList<>();
        simulation.loadU1(simulation.loadItems(PHASE_1)).forEach(u1 -> rockets.add(u1));

        System.out.println(simulation.runSimulation(rockets));
    }
}