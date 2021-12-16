package io.bii.LeetCode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void wordPattern() {
        assertTrue(solution.wordPattern("abba", "dog cat cat dog"));
        assertFalse(solution.wordPattern("abba", "dog cat cat fish"));
        assertFalse(solution.wordPattern("aaaa", "dog cat cat dog"));
        assertFalse(solution.wordPattern("abba", "dog dog dog dog"));
    }

    @Test
    void updateMatrix() {
        assertEquals(Arrays.deepToString(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}), solution.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        assertEquals(Arrays.deepToString(new int[][]{{0}, {1}}), solution.updateMatrix(new int[][]{{0}, {1}}));
        assertEquals(Arrays.deepToString(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 2, 1}}), solution.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}));
        assertEquals(Arrays.deepToString(new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}}), solution.updateMatrix(new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}}));
    }

    @Test
    void floodFill() {
        //[[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
    }

    @Test
    void maxAreaOfIsland() {
        assertEquals(6, solution.maxAreaOfIsland(new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}));
        assertEquals(1, solution.maxAreaOfIsland(new int[][]{{0, 1}}));
    }
}