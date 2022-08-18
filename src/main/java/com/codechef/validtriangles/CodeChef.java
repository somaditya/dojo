package com.codechef.validtriangles;

import java.util.*;
import java.lang.*;

/* Name of the class has to be "Main" only if the class is public. */
class CodeChef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();

            if (A + B + C == 180) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
