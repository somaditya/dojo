package com.adventofcode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/adventofcode/input.txt";

        try (Scanner scanner = new Scanner(new File(filePath))) {
            ArrayList<Integer> elves = new ArrayList<>();

            int sum = 0;
            int index = 0;

            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                if (!line.isBlank()) {
                    sum += Integer.parseInt(line);
                } else {
                    elves.add(index, sum);
                    index++;
                    sum = 0;
                }
            }

            System.out.println(maxOfList(elves));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int maxOfList(ArrayList<Integer> list) {
        return list.stream().mapToInt(i -> i).max().getAsInt();
    }
}
