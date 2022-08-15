package com.udacity.spacechallenge.simulation;

import com.udacity.spacechallenge.models.Item;
import com.udacity.spacechallenge.models.Rocket;
import com.udacity.spacechallenge.models.U1;
import com.udacity.spacechallenge.models.U2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Simulation {

    public ArrayList<Item> loadItems(String path) {
        ArrayList<Item> result = new ArrayList<>();
        File file = new File(path);

        try {
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                result.add(new Item(line.split("=")[0], Integer.parseInt(line.split("=")[1])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ArrayList<U1> loadU1(ArrayList<Item> items) {
        ArrayList<U1> arrU1 = new ArrayList<>();
        Queue<Item> itemQueue = new LinkedList(items);

        while (!itemQueue.isEmpty()) {
            U1 u1 = new U1();

            while (u1.canCarry(itemQueue.peek())) {
                u1.carry(itemQueue.poll());

                if (itemQueue.isEmpty()) break;
            }

            arrU1.add(u1);
        }

        return arrU1;
    }

    public ArrayList<U2> loadU2(ArrayList<Item> items) {
        ArrayList<U2> arrU2 = new ArrayList<>();
        Queue<Item> itemQueue = new LinkedList(items);

        while (!itemQueue.isEmpty()) {
            U2 u2 = new U2();

            while (u2.canCarry(itemQueue.peek())) {
                u2.carry(itemQueue.poll());

                if (itemQueue.isEmpty()) break;
            }

            arrU2.add(u2);
        }

        return arrU2;
    }

    public int runSimulation(ArrayList<Rocket> rockets) {
        int budget = 0;
        Queue<Rocket> rocketQueue = new LinkedList(rockets);

        while (!rocketQueue.isEmpty()) {
            if (rocketQueue.peek().launch() && rocketQueue.peek().land()) {
                budget += rocketQueue.poll().getCost();
            } else {
                rocketQueue.add(rocketQueue.poll());
            }
        }

        return budget;
    }
}
