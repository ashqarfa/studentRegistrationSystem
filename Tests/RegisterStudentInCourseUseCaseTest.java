import domain.Course;
import domain.Student;
import org.junit.Test;
import usecases.RegisterStudentInCourseUseCase;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;


public class RegisterStudentInCourseUseCaseTest {

    private static FakeCourseRepository fakeCourseRepository = new FakeCourseRepository();
    private static FakeStudentRepository fakeStudentRepository = new FakeStudentRepository();
    private static RegisterStudentInCourseUseCase registerStudentInCourseUseCase = new RegisterStudentInCourseUseCase(fakeStudentRepository, fakeCourseRepository);

    @Test
    public void testRegisteringStudentInCourses() {

        Course math = new Course("MAT1", "Math");
        Course history = new Course("HIS1", "History");
        fakeCourseRepository.addCourse(math);
        fakeCourseRepository.addCourse(history);
        fakeStudentRepository.addStudent(new Student("Farah", "Ashqar", 1));
        registerStudentInCourseUseCase.registerStudentInCourse(1, math);
        registerStudentInCourseUseCase.registerStudentInCourse(1, history);


        List<Course> studentCourses = fakeStudentRepository.getStudentByID(1).getStudentCourses();
        List<Course> expectedCourses = new ArrayList<>();
        expectedCourses.add(new Course("MAT1", "Math"));
        expectedCourses.add(new Course("HIS1", "History"));
        assertThat(studentCourses, containsInAnyOrder(expectedCourses.toArray()));
    }
}
