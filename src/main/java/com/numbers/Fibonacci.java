package com.numbers;

import java.io.*;
import java.math.BigInteger;

public class Fibonacci {
    static BigInteger fib(int n) {
        var a = BigInteger.valueOf(0);
        var b = BigInteger.valueOf(1);
        var c = BigInteger.valueOf(0);

        if (n <= 1) return BigInteger.valueOf(n);

        for (int i = 1; i < n; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        File file = new File("src/main/java/com/numbers/fib_2_000_000.txt");

        try (FileWriter fw = new FileWriter(file)) {
            PrintWriter out = new PrintWriter(new BufferedWriter(fw));
            out.println(fib(2_000_000));
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}