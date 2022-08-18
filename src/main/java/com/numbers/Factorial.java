package com.numbers;

import java.io.*;
import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        var n = BigInteger.valueOf(1);

        for (int i = 2; i <= 500_000 ; i++) {
            n = n.multiply(BigInteger.valueOf(i));
        }

        File file = new File("src/main/java/com/numbers/fact_500_000.txt");

        try (FileWriter fw = new FileWriter(file)) {
            PrintWriter out = new PrintWriter(new BufferedWriter(fw));
            out.println(n);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}