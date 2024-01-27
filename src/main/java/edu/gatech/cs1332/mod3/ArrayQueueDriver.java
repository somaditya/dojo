package edu.gatech.cs1332.mod3;

public class ArrayQueueDriver {
    public static void main(String[] args) {
        ArrayQueue<Integer> aq = new ArrayQueue<>();

        for (int i = 1; i < 10; i++) {
            aq.enqueue(i);
        }

        while (aq.size() > 0) {
            System.out.println(aq.dequeue());
        }
    }
}
