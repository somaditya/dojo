package com.bitwise;

public class Pattern {
    public static void main(String[] args) {
        diamond(42);
    }

    static void diamond(int n) {
        int rows = 2 * n - 1;

        for (int i = 1; i <= rows; i++) {
            int stars = i <= n ? i : 2*n-i;
            int offset = Math.abs(n - i);

            while(offset-- > 0) {
                System.out.print(" ");
            }

            while (stars-- > 0) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}
