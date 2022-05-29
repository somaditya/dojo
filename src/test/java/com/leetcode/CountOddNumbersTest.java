package com.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountOddNumbersTest {

    @Test
    @DisplayName("Should count odds")
    void countOdds() {
        CountOddNumbers c = new CountOddNumbers();

        assertEquals(3, c.countOdds(3, 7));
        assertEquals(1, c.countOdds(8, 10));
    }
}