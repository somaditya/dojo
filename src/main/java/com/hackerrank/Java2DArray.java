package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Java2DArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

        int max = Integer.MIN_VALUE;

        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                int sum = arr.get(r).get(c)
                        + arr.get(r).get(c + 1)
                        + arr.get(r).get(c + 2)
                        + arr.get(r + 1).get(c + 1)
                        + arr.get(r + 2).get(c)
                        + arr.get(r + 2).get(c + 1)
                        + arr.get(r + 2).get(c + 2);

                if (sum > max) max = sum;
            }
        }

        System.out.println(max);
    }
}