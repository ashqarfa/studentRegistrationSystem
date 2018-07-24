package usecases;

import domain.CourseCode;
import fakerepositories.FakeCourseRepository;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class AddNewCourseUseCaseTest {

    private static FakeCourseRepository fakeCourseRepository = new FakeCourseRepository();
    private static AddNewCourseUseCase newCourseUseCase = new AddNewCourseUseCase(fakeCourseRepository);

    @Test
    public void testAddingCourses() {
        newCourseUseCase.addNewCourse(CourseCode.create("MAT1"), "Math");
        assertTrue(fakeCourseRepository.isOffered(CourseCode.create("MAT1")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCourseCode() {
        newCourseUseCase.addNewCourse(CourseCode.create("maT1"), "Math");
    }
}
