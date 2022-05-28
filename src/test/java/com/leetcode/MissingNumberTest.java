package com.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumberTest {
    MissingNumber mn = new MissingNumber();

    @Test
    @DisplayName("Should find missing number")
    void shouldFindMissingNum() {
        int[] arr = {5, 0, 1, 2, 3};

        assertEquals(4, mn.missingNumber(arr));
    }

}