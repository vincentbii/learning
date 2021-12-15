package io.bii.geeks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class KMPAlgorithmTest {

    private KMPAlgorithm kmpAlgorithm;

    @BeforeEach
    void setUp() {
        kmpAlgorithm = new KMPAlgorithm();
    }

    @Test
    void search() {
        assertEquals(Arrays.asList(1, 18), kmpAlgorithm.search("bat", "batmanandrobinarebat"));
        assertEquals(Collections.singletonList(-1), kmpAlgorithm.search("edu", "abesdu"));
    }

    @AfterEach
    void tearDown() {
        kmpAlgorithm = null;
    }
}