import org.junit.Before;
import org.junit.Test;

import javax.activity.InvalidActivityException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class CourseRegistrationTest {
    private FakeCourseRepository fakeCourseRepository = new FakeCourseRepository();
    private FakeStudentRepository fakeStudentRepository = new FakeStudentRepository();
    private Student student;

    @Before
    public void setUp() {
        fakeStudentRepository.addStudent(new Student("Jozef", "Bernat", 1));

        fakeCourseRepository.addCourse("History","HIS1");
        fakeCourseRepository.addCourse("Math","MAT1");

        student = fakeStudentRepository.getAllStudents().get(0);
    }

    @Test
    public void testAddingCourses() throws InvalidActivityException {
        fakeCourseRepository.addCourse("French","FRE1");

        student.registerStudentInCourse("FRE1","French");
    }

    @Test(expected = InvalidActivityException.class)
    public void testRemovingCourses() throws InvalidActivityException {
        fakeCourseRepository.addCourse("GER1", "German");
        fakeCourseRepository.removeCourse("GER1");

        student.registerStudentInCourse("GER1", "German");
    }

    @Test
    public void checkRegisterStudentToCourse() throws InvalidActivityException {
        student.registerStudentInCourse("MAT1","Math");
        student.registerStudentInCourse("HIS1","History");
        List<Course> studentCourses = student.getStudentCourses();
        List<Course> expectedCourses = new ArrayList<>();
        expectedCourses.add(new Course("MAT1","Math"));
        expectedCourses.add(new Course("HIS1","History"));

        assertThat(studentCourses, containsInAnyOrder(expectedCourses.toArray()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArgumentsInCourse() {
        Course.addNewCourse("HIs1", "History");
    }


}
