package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CourseTest {


    @Test
    public void createValidCourseTest() {
        Course actualCourse = Course.create("MAT1", "Math");
        Course expectedCourse = new Course("MAT1", "Math");
        assertEquals(expectedCourse, actualCourse);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidCourseTest() {
        Course.create("Mat1", "Math");

    }
}