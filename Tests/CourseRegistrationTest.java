import org.junit.Before;
import org.junit.Test;

import javax.activity.InvalidActivityException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class CourseRegistrationTest {

    private MockTestingData mockTestingDataClass;

    @Before
    public void setUp() {
        mockTestingDataClass = new MockTestingData();
    }


    @Test
    public void testAddingCourses() throws InvalidActivityException {

        Course.addNewCourse("MAT1", "Math");
        Student student = mockTestingDataClass.getStudents().get(0);
        student.registerStudentInCourse("MAT1");
    }

    @Test(expected = InvalidActivityException.class)
    public void testRemovingCourses() throws InvalidActivityException {

        Course.addNewCourse("HIS1", "History");
        Course.removeCourse("HIS1");
        Student student = mockTestingDataClass.getStudents().get(0);
        student.registerStudentInCourse("HIS1");
    }

    @Test
    public void checkRegisterStudentToCourse() throws InvalidActivityException {

        Course.addNewCourse("HIS1", "History");
        Course.addNewCourse("MAT1", "Math");

        Student student = mockTestingDataClass.getStudents().get(0);
        student.registerStudentInCourse("MAT1");
        student.registerStudentInCourse("HIS1");
        List<Course> studentCourses = student.getStudentCourses();
        List<Course> expectedCourses = new ArrayList<>();
        expectedCourses.add(new Course("MAT1"));
        expectedCourses.add(new Course("HIS1"));
        assertThat(studentCourses, containsInAnyOrder(expectedCourses.toArray()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArgumentsInCourse() {
        Course.addNewCourse("HIs1", "History");
    }
}
