package com.scaler.contest1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HighProd {
    public int maxp3(ArrayList<Integer> A) {
        int N = A.size();

        Collections.sort(A);

        return Math.max(A.get(N-1)*A.get(N-2)*A.get(N-3), A.get(0)*A.get(1)*A.get(N-1));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(Files.readString(Path.of("src/main/java/com/scaler/contest1/high_prod_input.txt")));
        int N = sc.nextInt();
        ArrayList<Integer> input = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            input.add(sc.nextInt());
        }
        HighProd hp = new HighProd();

        System.out.println(hp.maxp3(input));
    }
}
