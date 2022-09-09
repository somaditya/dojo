package com.facebook.hackercup.a;

import java.io.*;
import java.util.TreeMap;

public class SecondHands {
    public static void main(String[] args) {
        File inputFile = new File("src/main/java/com/facebook/hackercup/a/second_hands_validation_input.txt");
        File outputFile = new File("src/main/java/com/facebook/hackercup/a/second_hands_output.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, false))) {
            int t = Integer.parseInt(br.readLine());

            for (int i = 1; i <= t; i++) {
                String answer = "YES";
                String line1 = br.readLine();
                int n = Integer.parseInt(line1.split(" ")[0]);
                int k = Integer.parseInt(line1.split(" ")[1]);

                String[] strS = br.readLine().split(" ");

                TreeMap<Integer, Integer>[] cases = new TreeMap[2];
                cases[0] = new TreeMap<>();
                cases[1] = new TreeMap<>();

                for (int j = 0; j < n; j++) {
                    int si = Integer.parseInt(strS[j]);

                    if (!cases[0].containsKey(si) && !cases[1].containsKey(si)) {
                        if (cases[0].size() <= cases[1].size()) {
                            cases[0].put(si, 1);
                        } else {
                            cases[1].put(si, 1);
                        }
                    } else if (cases[0].containsKey(si) && !cases[1].containsKey(si)) {
                        cases[1].put(si, 1);
                    } else if (!cases[0].containsKey(si) && cases[1].containsKey(si)) {
                        cases[0].put(si, 1);
                    } else {
                        if (cases[0].size() <= cases[1].size()) {
                            cases[0].put(si, cases[0].get(si) + 1);
                        } else {
                            cases[1].put(si, cases[1].get(si) + 1);
                        }
                    }
                }

                for (Integer freq : cases[0].values().stream().toList()) {
                    if (freq > 1) {
                        answer = "NO";
                        break;
                    }
                }

                for (Integer freq : cases[1].values().stream().toList()) {
                    if (freq > 1) {
                        answer = "NO";
                        break;
                    }
                }

                if (cases[0].size() > k || cases[1].size() > k) {
                    answer = "NO";
                }

                String output = "Case #" + i + ": " + answer;
                writer.write(output + "\n");
                System.out.println(output);
                PrintWriter out = new PrintWriter(writer);
                out.flush();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}