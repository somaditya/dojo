package edu.gatech.cs1331.hw03;

import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] p1Board = new char[5][5];
        char[][] p2Board = new char[5][5];

        char[][] p1TgtHist = new char[5][5];
        char[][] p2TgtHist = new char[5][5];

        int p1Score = 0;
        int p2Score = 0;

        // initialize both player's board
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                p1Board[i][j] = '-';
                p2Board[i][j] = '-';
                p1TgtHist[i][j] = '-';
                p2TgtHist[i][j] = '-';
            }
        }

        System.out.println("Welcome to Battleship!\n");
        System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");
        input(p1Board, scanner);
        System.out.println("PLAYER 2, ENTER YOUR SHIPS' COORDINATES.");
        input(p2Board, scanner);

        int player = 1;

        do {
            if (player == 1) {
                if (hit(player, p2Board, p1TgtHist, scanner)) {
                    p1Score++;
                }

                printBattleShip(p1TgtHist);
            } else {
                if (hit(player, p1Board, p2TgtHist, scanner)) {
                    p2Score++;
                }

                printBattleShip(p2TgtHist);
            }

            player = (player % 2) + 1;
        } while (p1Score < 5 && p2Score < 5);

        System.out.print("PLAYER " + (p1Score > p2Score ? 1 : 0) + " WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!\n");

        System.out.println("\nFinal boards:\n");
        printBattleShip(p1Board);
        System.out.println("");
        printBattleShip(p2Board);
    }

    public static void input(char[][] board, Scanner sc) {
        int cnt = 1;

        do {
            System.out.println("Enter ship " + cnt + " location:");
            int r = sc.nextInt();
            int c = sc.nextInt();

            if (isInvalid(r, c)) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
                continue;
            }

            if (board[r][c] == '@') {
                System.out.println("You already have a ship there. Choose different coordinates.");
                continue;
            }

            board[r][c] = '@';
            cnt++;
        } while (cnt <= 5);

        printBattleShip(board);

        for (int i = 0; i < 100; i++) {
            System.out.print("\n");
        }
    }

    public static boolean hit(int player, char[][] board, char[][] tgtHist, Scanner sc) {
        while (true) {
            System.out.printf("\nPlayer %d, enter hit row/column:\n", player);
            int r = sc.nextInt();
            int c = sc.nextInt();

            if (isInvalid(r, c)) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
                continue;
            }

            if (fired(r, c, tgtHist)) {
                System.out.println("You already fired on this spot. Choose different coordinates.");
                continue;
            }

            if (board[r][c] == '@') {
                System.out.printf("PLAYER %d HIT PLAYER %d's SHIP!\n", player, player%2 + 1);
                board[r][c] = 'X';
                tgtHist[r][c] = 'X';
                return true;
            } else {
                System.out.printf("PLAYER %d MISSED!\n", player);
                board[r][c] = 'O';
                tgtHist[r][c] = 'O';
                return false;
            }
        }
    }

    private static boolean isInvalid(int row, int col) {
        return row < 0 || row > 4 || col < 0 || col > 4;
    }

    private static boolean fired(int row, int col, char[][] tgtHist) {
        return tgtHist[row][col] == 'X' || tgtHist[row][col] == 'O';
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
