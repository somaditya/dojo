package com.codechef.idship;

import java.util.*;
import java.lang.*;

/* Name of the class has to be "Main" only if the class is public. */
class CodeChef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        Map<String, String> hm = new HashMap<>();

        hm.put("B", "BattleShip");
        hm.put("C", "Cruiser");
        hm.put("D", "Destroyer");
        hm.put("F", "Frigate");

        for (int i = 1; i <= T; i++) {
            System.out.println(hm.get(sc.next().toUpperCase()));
        }
    }
}
