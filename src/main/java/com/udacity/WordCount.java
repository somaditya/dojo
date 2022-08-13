package com.udacity;

import java.io.File;
import java.util.Scanner;

public class WordCount {

    public static void main(String[] args) throws Exception {
        
        File file = new File("src/main/java/com/udacity/98-0.txt");

        Scanner scan = new Scanner(file);

        int wordCount = 0;

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            wordCount += line.split(" ").length;
        }   

        System.out.println("Word count: " + wordCount);
    }
}
