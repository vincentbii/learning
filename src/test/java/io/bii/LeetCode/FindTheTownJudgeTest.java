package io.bii.LeetCode;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTheTownJudgeTest {

    private FindTheTownJudge judge;

    @BeforeEach
    void setUp() {
        judge = new FindTheTownJudge();
    }

    @AfterEach
    void tearDown() {
        judge = null;
    }

    @Test
    void findJudge() {
        assertEquals(2, judge.findJudge(2, new int[][]{{1, 2}}));
        assertEquals(3, judge.findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        assertEquals(-1, judge.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
        assertEquals(-1, judge.findJudge(3, new int[][]{{1, 2}, {2, 3}}));
        assertEquals(3, judge.findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
    }
}