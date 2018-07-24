package usecases;

import domain.Course;
import domain.CourseCode;
import domain.Student;
import domain.StudentName;
import fakerepositories.FakeCourseRepository;
import fakerepositories.FakeStudentRepository;
import org.junit.Test;

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

        Course math = new Course(CourseCode.create("MAT1"), "Math");
        Course history = new Course(CourseCode.create("HIS1"), "History");
        fakeCourseRepository.addCourse(math);
        fakeCourseRepository.addCourse(history);
        fakeStudentRepository.addStudent(new Student(StudentName.create("Farah", "Ashqar"), 1, "farah.ashqar@mail.university.com", "gdf"));
        registerStudentInCourseUseCase.registerStudentInCourse(1, math);
        registerStudentInCourseUseCase.registerStudentInCourse(1, history);


        List<Course> studentCourses = fakeStudentRepository.getStudentByID(1).getStudentCourses();
        List<Course> expectedCourses = new ArrayList<>();
        expectedCourses.add(new Course(CourseCode.create("MAT1"), "Math"));
        expectedCourses.add(new Course(CourseCode.create("HIS1"), "History"));
        assertThat(studentCourses, containsInAnyOrder(expectedCourses.toArray()));
    }
}
