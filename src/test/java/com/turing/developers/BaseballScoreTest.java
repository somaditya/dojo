package com.turing.developers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballScoreTest {

    @Test
    void calcScore() {
        String[] ops = {"5", "2", "C", "D", "+"};

        Assertions.assertEquals(30, BaseballScore.calcScore(ops));
    }
}