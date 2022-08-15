package com.udacity.nd079.regex;

import java.util.regex.Pattern;

public class RegExTester {

    public static void main(String[] args) {
        String emailRegex = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);

        String email = "sb@gmail.com";
        System.out.println(pattern.matcher(email).matches());
    }
}
