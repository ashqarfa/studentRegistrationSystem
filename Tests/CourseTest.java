import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CourseTest {


    @Before
    public void setUp() {
        Course.addNewCourse("HIS1", "History");
        Course.addNewCourse("MAT1", "Math");
    }

    @Test
    public void addNewCourseTest() {
        assertEquals("History", Course.getCoursesOffered().get("HIS1"));
        assertEquals("Math", Course.getCoursesOffered().get("MAT1"));
      //  assertEquals("Math", Course.getCoursesOffered().clear());
    }

    @Test
    public void removeCourseTest() {
        Course.removeCourse("HIS1");
        assertNull(Course.getCoursesOffered().get("HIS1"));
    }
}