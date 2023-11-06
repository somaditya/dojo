package com.scaler.arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        StringBuilder sb = new StringBuilder();

        int n = A.size();

        for (int i = 0; i<n; i++) {
            sb.append(A.get(i));
        }

        BigInteger num = new BigInteger(sb.toString());
        num = num.add(BigInteger.ONE);

        StringBuilder add1 = new StringBuilder();

        while (num.compareTo(BigInteger.valueOf(0)) > 0) {
            add1.append(num.remainder(BigInteger.TEN));
            num = num.divide(BigInteger.TEN);
        }

        add1.reverse();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i<add1.length(); i++) {
            list.add(Integer.parseInt(String.valueOf(add1.charAt(i))));
        }

        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(List.of(1, 1, 1, 3, 2, 1, 1, 2, 5, 9, 6, 6));
        AddOneToNumber a = new AddOneToNumber();

        System.out.println(a.plusOne(input));
    }
}
