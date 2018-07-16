import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTest {


    @Before
    public void setUp() throws Exception {
        Course.addNewCourse("HIS1", "History");
        Course.addNewCourse("MAT1", "Math");
    }

    @Test
    public void addNewCourse() {
        assertEquals("History", Course.getCoursesOffered().get("HIS1").toString());
        assertEquals("Math", Course.getCoursesOffered().get("MAT1").toString());
    }

    @Test
    public void removeCourse() {
        Course.removeCourse("HIS1");
        assertNull(Course.getCoursesOffered().get("HIS1"));
    }
}