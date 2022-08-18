package com.codechef.atm;

import java.util.*;

class Solution{
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        float x = scanner.nextFloat();
        float y = scanner.nextFloat();

        if( (x % 5 == 0)  && (y >= (x + 0.5f) ) ) {
            System.out.println(y - x - 0.5f);
        } else {
            System.out.println(y);
        }
    }
}