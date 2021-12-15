package io.bii.geeks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WordLadderTest {

    private WordLadder wordLadder;

    @BeforeEach
    void setUp() {

        this.wordLadder = new WordLadder();

    }

    @Test
    void ladderLength() {
        assertEquals(5, wordLadder.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        assertEquals(0, wordLadder.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
        assertEquals(4, wordLadder.ladderLength("ABCV", "EBAD", Arrays.asList("ABCD", "EBAD", "EBCD", "XYZA")));
        assertEquals(7, wordLadder.ladderLength("TOON", "PLEA", Arrays.asList("POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN")));
    }

    @Test
    void canFinish() {
        /*
        20
[[0,10],[3,18],[5,5],[6,11],[11,14],[13,1],[15,1],[17,4]]
         */
        assertFalse(wordLadder.canFinish(20, new int[][]{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}}));
        assertFalse(wordLadder.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        assertTrue(wordLadder.canFinish(2, new int[][]{{1, 0}}));
    }
}