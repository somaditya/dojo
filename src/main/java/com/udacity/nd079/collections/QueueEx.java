package com.udacity.nd079.collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {
    public static void main(String[] args) {
        Queue<String> customers = new LinkedList<>();
        customers.add("cust1");
        customers.add("cust2");
        customers.add("cust3");
        customers.add("cust4");
        customers.add("cust5");

        while (!customers.isEmpty()) {
            System.out.println(customers.poll());
        }
    }
}
