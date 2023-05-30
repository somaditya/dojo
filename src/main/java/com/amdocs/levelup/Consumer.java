package com.amdocs.levelup;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

class Consumer implements Runnable {
    private ConcurrentLinkedQueue<String> buffer;

    public Consumer(ConcurrentLinkedQueue<String> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (buffer.isEmpty()) {
                    continue;
                } else if (buffer.peek().equals("EOF")) {
                    System.out.println(Thread.currentThread().getName() + " exiting.");
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + " removed " + buffer.poll());
                }

                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
