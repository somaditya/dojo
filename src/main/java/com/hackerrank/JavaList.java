package com.hackerrank;

import java.io.*;
import java.util.*;

public class JavaList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(scanner.nextInt());
        }

        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            if (scanner.next().equals("Insert")) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                list.add(x, y);
            } else {
                int x = scanner.nextInt();

                list.remove(x);
            }
        }

        scanner.close();

        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
