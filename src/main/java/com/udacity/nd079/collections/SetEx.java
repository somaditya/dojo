package com.udacity.nd079.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetEx {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1234567890");
        list.add("2345678901");
        list.add("3456789012");
        list.add("1234567890");
        list.add("2345678901");

        Set<String> set = new HashSet<>(list);

        for (String num : set) {
            System.out.println(num);
        }
    }
}
