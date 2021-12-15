package io;

import io.bii.pinreset.Channel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamoTest {

    App app = new App();

    @Test
    void ispar() {
        assertTrue(app.ispar("[()]{}{[()()]()}"));
        assertTrue(app.ispar("{([])}"));
        assertFalse(app.ispar("([]"));
        assertTrue(app.ispar("()"));
    }

    @Test
    void countRev() {
        assertEquals(3, app.countRev("}{{}}{{{"));
    }

    @Test
    void Dynamo() {
        Servlet.InitiateRequestFromChannel();
    }

    @Test
    void minimumWalk() {
        assertEquals(2, app.MinimumWalk(new int[][]{{0, 1, 1, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 0}}, 0, 3, 2));
    }

    @Test
    void isHeap() {
//        assertTrue(app.isHeap(new int[]{90, 15, 10, 7, 12, 2, 7, 3}));
        assertFalse(app.isHeap(new int[]{9, 15, 10, 7, 12, 11}));
    }
}