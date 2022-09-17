package com.amdocs.codeninja;

import java.util.Scanner;

public class Palindrome {

    public static boolean isPalindrome(String input) {
        StringBuilder inputSB = new StringBuilder(input.toLowerCase());

        return String.valueOf(inputSB).equals(inputSB.reverse().toString());
    }

    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter a string:");
            String input = scanner.next();

            String result = isPalindrome(input) ? " is a palindrome." : " is not a palindrome.";

            System.out.println("The string " + input + result);
        }
    }
}
