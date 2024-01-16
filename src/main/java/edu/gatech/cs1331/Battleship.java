package edu.gatech.cs1331;

import java.util.Scanner;

public class Battleship {

    static final Scanner sc = new Scanner(System.in);

    static int[] p1Rows = new int[5];
    static int[] p1Cols = new int[5];
    static int[] p2Rows = new int[5];
    static int[] p2Cols = new int[5];

    public static void main(String[] args) {
        System.out.println("Welcome to Battleship!");
        System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");

        input(p1Rows, p1Cols);
        input(p2Rows, p2Cols);
    }

    public static void input(int[] rows, int[] cols) {
        int i = 0;

        do {
            int r = sc.nextInt();
            int c = sc.nextInt();

            if (isRepeated(r, c)) {
                System.out.println("You already have a ship there. Choose different coordinates.");
                continue;
            }
            if (r < 0 || r > 4 || c < 0 || c > 4) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
                continue;
            }
            rows[i++] = r;
            cols[i] = c;
        } while (i < 5);
    }

    private static boolean isRepeated(int r, int c) {
        for (int i = 0; i < 5; i++) {

        }
    }

    // Use this method to print game boards to the console.
    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }
}
