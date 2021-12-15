//package io.bii.geeks;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class Solution20211025Test {
//
//    Solution_20211025 solution20211025 = new Solution_20211025();
//
//    @Test
//    void minCost() {
//        assertEquals(62, solution20211025.minCost(new long[]{4, 2, 7, 6, 9}, 5));
//        assertEquals(29, solution20211025.minCost(new long[]{4, 3, 2, 6}, 4));
//    }
//
//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    @Test
//    void isPossible() {
//        assertTrue(solution20211025.isPossible(4, new int[][]{{1, 0}, {2, 1}, {3, 2}}));
//        assertFalse(solution20211025.isPossible(20, new int[][]{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}}));
//        assertFalse(solution20211025.isPossible(2, new int[][]{{1, 0}, {0, 1}}));
//    }
//
//    @Test
//    void maxArea() {
//        assertEquals(8, solution20211025.maxArea(new int[][]{{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}}, 4, 4));
//    }
//}