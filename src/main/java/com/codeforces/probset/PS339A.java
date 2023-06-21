package com.codeforces.probset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PS339A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        String[] numArr = input.split("\\+");

        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < numArr.length; i++) {
            numList.add(Integer.valueOf(numArr[i]));
        }

        Collections.sort(numList);

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < numList.size(); i++) {
            out.append(numList.get(i)).append("+");
        }

        System.out.println(out.substring(0, out.length() - 1));
    }
}
