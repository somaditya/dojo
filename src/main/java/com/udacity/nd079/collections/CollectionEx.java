package com.udacity.nd079.collections;

import java.util.ArrayList;
import java.util.List;

public class CollectionEx {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Mike");
        list.add("Bob");
        list.add("Alice");

        for (String item : list) {
            System.out.println(item);
        }
    }
}
