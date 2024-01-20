package edu.gatech.cs1331.hw06;

public class InvalidPetException extends RuntimeException {
    public InvalidPetException() {
        super("Your pet is invalid!");
    }

    public InvalidPetException(String s) {
        super(s);
    }
}
