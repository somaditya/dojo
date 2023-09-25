package jp.atcoder.abc321.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int X = s.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N-1; i++) {
            list.add(s.nextInt());
        }

        Collections.sort(list);
        int sum = 0;

        for (int i = 1; i < list.size(); i++) {
            sum += list.get(i);
        }

        int result = X - sum;

        if (result > 100) result = -1;

        System.out.println(result);
    }
}
