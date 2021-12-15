package io.bii.geeks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GFGTest {

    GFG gfg = new GFG();


    @Test
    void totalAnimal() {
        assertEquals(2, gfg.TotalAnimal(2));
        assertEquals(5, gfg.TotalAnimal(4));
    }

    @BeforeEach
    void setUp() {

    }
}