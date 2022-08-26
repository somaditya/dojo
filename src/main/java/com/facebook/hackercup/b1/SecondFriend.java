package com.facebook.hackercup.b1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class SecondFriend {
    static final String FILE_NAME = "second_friend_sample_input";

    static void solve(Scanner in, PrintWriter out) {
        int T = in.nextInt();
        System.out.println(T);

        for (int tc = 1; tc <= T; tc++) {
            int R = in.nextInt();
            int C = in.nextInt();
//            System.out.println("R=" + R + " " + "C=" + C);

            char[][] matrix = new char[R][C];

            for (int row = 0; row < R; row++) {
                char[] line = in.next().toCharArray();
                for (int col = 0; col < C; col++) {
                    matrix[row][col] = line[col];
                }
//                System.out.println(matrix[row]);
            }

            String answer = "Impossible";
            out.println("Case #" + tc + ": " + answer);
        }
        out.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        solve(new Scanner(new File(FILE_NAME + ".txt")), new PrintWriter(new File(FILE_NAME + ".out")));
    }
}
