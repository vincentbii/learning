package io.bii.LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleTest {

    private CourseSchedule courseSchedule;

    @BeforeEach
    void setUp() {
        courseSchedule = new CourseSchedule();
    }

    @Test
    void canFinish() {
        assertFalse(courseSchedule.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        assertTrue(courseSchedule.canFinish(2, new int[][]{{1, 0}}));
    }
}