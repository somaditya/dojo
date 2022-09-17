package com.amdocs.codeninja;

public class Diamond {

    public static void main(String[] args) {
        drawDiamond(7);
    }

    private static void drawDiamond(int size) {
        // top half till middle
        for (int line = 1; line <= size; line++) {
            printSpaces(size, line);
            printStars(line);
        }

        // bottom half after middle
        for (int line = size - 1; line > 0; line--) {
            printSpaces(size, line);
            printStars(line);
        }
    }

    private static void printStars(int line) {
        for (int star = 1; star <= line * 2 - 1; star++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void printSpaces(int size, int line) {
        for (int space = size - line; space > 0; space--) {
            System.out.print("  ");
        }
    }
}
