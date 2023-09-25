package jp.atcoder.abc321.a;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        while (N > 0) {
            list.add(N % 10);
            N /= 10;
        }

        String result = "Yes";

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i-1)) result = "No";
        }

        System.out.println(result);
    }
}
