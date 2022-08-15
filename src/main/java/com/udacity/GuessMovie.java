package com.udacity;

import java.io.File;
import java.util.*;

public class GuessMovie {
    public static void main(String[] args) throws Exception {

        File file = new File("src/main/java/com/udacity/movies.txt");
        Scanner scan = new Scanner(file);
        List<String> movies = new ArrayList<>();

        while (scan.hasNextLine()) {
            movies.add(scan.nextLine());
        }

        int random = (int) (Math.random() * movies.size());
        String movie = movies.get(random);
        int spaces = 0;

        for (char c : movie.toCharArray()) {
            if (c == ' ') {
                spaces++;
            }
        }

        Set<Character> wrongGuesses = new HashSet<>();
        int right = 0;
        boolean[] correct = new boolean[100];

        while (right < (movie.length() - spaces)) {
            System.out.println("You are guessing:");

            for (int i = 0; i < movie.length(); i++) {
                if (correct[i]) {
                    System.out.print(movie.toCharArray()[i]);
                } else {
                    System.out.print("_");
                }
            }

            System.out.println();
            System.out.println("You have guessed " + wrongGuesses.size() + " wrong letters.");
            System.out.println("Guess a letter: ");

            Scanner scanner = new Scanner(System.in);
            String guess = scanner.next();
            boolean found = false;
            
            for (int i = 0; i < movie.length(); i++) {
                if ((guess.charAt(0) == movie.charAt(i)) && (correct[i] == false)) {
                    correct[i] = true;
                    right++;
                    found = true;
                }
            }

            if (!found && !wrongGuesses.contains(guess.charAt(0))) {
                wrongGuesses.add(guess.charAt(0));
            }
        }

        System.out.println("You win!");
        System.out.printf("You have guessed '%s' correctly.", movie);
    }
}
