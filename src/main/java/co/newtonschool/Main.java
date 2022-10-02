package co.newtonschool;

import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        if (Math.pow(a, b) > Math.pow(b,a)) {
            System.out.println("First");
        } else if (Math.pow(a, b) < Math.pow(b,a)) {
            System.out.println("Second");
        } else {
            System.out.println("Equal");
        }
    }
}