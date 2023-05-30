package com.amdocs.levelup;

import java.util.concurrent.ConcurrentLinkedQueue;

class Producer implements Runnable {
    private final ConcurrentLinkedQueue<String> buffer;
    private final int items;

    public Producer(ConcurrentLinkedQueue<String> buffer, int items) {
        this.buffer = buffer;
        this.items = items;
    }

    @Override
    public void run() {
        for (int i = 1; i <= items; i++) {
            buffer.add(String.valueOf(i));
            System.out.println(Thread.currentThread().getName() + " added " + i);
        }

        System.out.println(Thread.currentThread().getName() + " added EOF");
        buffer.add("EOF");
    }
}
