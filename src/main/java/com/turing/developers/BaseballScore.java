package com.turing.developers;

import java.util.Scanner;
import java.util.Stack;

public class BaseballScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] ops = sc.nextLine().split(" ");

        System.out.println(calcScore(ops));
    }

    public static int calcScore(String[] ops) {
        int result = 0;

        Stack<Integer> stack = new Stack<>();
        String symbols = "CD+";

        for (int i = 0; i < ops.length; i++) {
            if (!symbols.contains(ops[i])) {
                stack.push(Integer.parseInt(ops[i]));
            } else {
                char c = ops[i].charAt(0);

                if (c == 'C') {
                    stack.pop();
                } else if (c == 'D') {
                    stack.push(2 * stack.peek());
                } else {
                    int top = stack.pop();
                    int second = stack.peek();
                    int sum = top + second;

                    stack.push(top);
                    stack.push(sum);
                }
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
