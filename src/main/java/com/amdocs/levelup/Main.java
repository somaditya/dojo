package com.amdocs.levelup;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) {
        final int items = Integer.parseInt(args[0]);
        final int numOfCons = Integer.parseInt(args[1]);

        ConcurrentLinkedQueue<String> buffer = new ConcurrentLinkedQueue<>();

        Thread producerThread = new Thread(new Producer(buffer, items));
        producerThread.setName("producerThread");

        producerThread.start();

        for (int i = 1; i <= numOfCons; i++) {
            Thread t = new Thread(new Consumer(buffer));
            t.setName("consumerThread" + (i));
            t.start();
        }
    }
}
