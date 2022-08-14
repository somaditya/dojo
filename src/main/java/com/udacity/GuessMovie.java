package com.udacity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuessMovie {
    public static void main(String[] args) throws Exception {

        File file = new File("src/main/java/com/udacity/movies.txt");
        Scanner scan = new Scanner(file);
        List<String> movies = new ArrayList<>();

        while (scan.hasNextLine()) {
            movies.add(scan.nextLine());
        }

        int random = (int) Math.random() * movies.size();

        String movie = movies.get(random);

        int length = movie.length();

        for (char c : movie.toCharArray()) {
            System.out.print("_");
        }


    }
}
