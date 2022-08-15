package com.udacity.nd079.exceptions;

public class PhoneExceptionTester {

    public static void main(String[] args) {
        String[] numbers = new String[] { "123-4567", null, "234-4567", "345-5678" };

        for (String n : numbers) {
            try {
                System.out.println(new Phone("iPhone", n));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        }
    }
}
