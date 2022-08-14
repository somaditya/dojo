package com.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpinWordsTest {

    @Test
    public void spinWordsTest() {
        assertEquals("Stop gninnipS My sdroW", new SpinWords().spinWords("Stop Spinning My Words"));
    }
}