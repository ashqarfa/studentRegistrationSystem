//import domain.Course;
//import domain.Student;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import javax.activity.InvalidActivityException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
//import static org.junit.Assert.assertThat;
//
//public class CourseRegistrationTest {
//    private static Student student;
//    private static FakeCourseRepository fakeCourseRepository = new FakeCourseRepository();
//
//    @BeforeClass
//    public static void setUp() {
//        Course.setCourseRepository(fakeCourseRepository);
//        student = new Student("Farah", "Ashqar", 1);
//    }
//
//    @Test
//    public void testAddingCourses() throws InvalidActivityException {
//        Course.addNewCourse("FRE1", "French");
//        student.registerStudentInCourse("FRE1","French");
//    }
//
//    @Test(expected = InvalidActivityException.class)
//    public void testRemovingCourses() throws InvalidActivityException {
//        Course.addNewCourse("GER1", "German");
//        Course.removeCourse("GER1");
//        student.registerStudentInCourse("GER1", "German");
//    }
//
//    @Test
//    public void checkRegisterStudentToCourse() throws InvalidActivityException {
//
//        Course.addNewCourse("MAT1", "Math");
//        Course.addNewCourse("HIS1", "History");
//        student.registerStudentInCourse("MAT1","Math");
//        student.registerStudentInCourse("HIS1","History");
//        List<Course> studentCourses = student.getStudentCourses();
//        List<Course> expectedCourses = new ArrayList<>();
//        expectedCourses.add(new Course("MAT1","Math"));
//        expectedCourses.add(new Course("HIS1","History"));
//        assertThat(studentCourses, containsInAnyOrder(expectedCourses.toArray()));
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testArgumentsInCourse() {
//        Course.addNewCourse("HIs1", "History");
//    }
//}
