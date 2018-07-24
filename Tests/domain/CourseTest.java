package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CourseTest {


    @Test
    public void overrideEqualsTest() {
        Course actualCourse = new Course(CourseCode.create("MAT1"), "Math");
        Course expectedCourse = new Course(CourseCode.create("MAT1"), "Math");
        assertEquals(actualCourse, expectedCourse);
    }
}