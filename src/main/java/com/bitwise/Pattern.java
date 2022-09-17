package com.bitwise;

public class Pattern {
    public static void main(String[] args) {
        diamond(42);
    }

    static void diamond(int size) {
        int rows = 2 * size - 1;

        for (int i = 1; i <= rows; i++) {
            int stars = i <= size ? i : 2*size-i;
            int offset = Math.abs(size - i);

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
