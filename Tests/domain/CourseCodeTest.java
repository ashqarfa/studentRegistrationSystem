package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CourseCodeTest {

    @Test
    public void validCourseCodeTest() {
        CourseCode courseCode = CourseCode.create("MAT1");
        assertEquals("MAT1", courseCode.getCourseCode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidCourseCodeTest() {
        CourseCode.create("Mat1");

    }
}