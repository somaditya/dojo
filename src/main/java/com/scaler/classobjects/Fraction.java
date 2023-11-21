package com.scaler.classobjects;

class Fraction {
    int numerator, denominator;

    // Define constructor here
    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }


    Fraction add(Fraction a) {
// Complete the function
        Fraction f = new Fraction(0, 0);
        if (denominator == a.denominator) {
            f.numerator = numerator + a.numerator;
            f.denominator = denominator;
        } else {
            f.numerator = (numerator * a.denominator) + (denominator * a.numerator);
            f.denominator = denominator * a.denominator;
        }
        return gcd(f);
    }


    Fraction subtract(Fraction a) {
// Complete the function
        Fraction f = new Fraction(0, 0);
        if (denominator == a.denominator) {
            f.numerator = numerator - a.numerator;
            f.denominator = denominator;
        } else {
            f.numerator = (numerator * a.denominator) - (denominator * a.numerator);
            f.denominator = denominator * a.denominator;
        }
        return gcd(f);
    }


    Fraction multiply(Fraction a) {
// Complete the function
        Fraction f = new Fraction(0, 0);
        f.numerator = numerator * a.numerator;
        f.denominator = denominator * a.denominator;
        return gcd(f);
    }


    Fraction gcd(Fraction a) {
        int num = (a.numerator);
        int den = (a.denominator);
        int num1 = Math.abs(num);
        int num2 = Math.abs(den);
        int rem = num1 % num2;
        while (rem != 0) {
            num1 = num2;
            num2 = rem;
            rem = num1 % num2;
        }
        return new Fraction(num / num2, den / num2);
    }
}