package usecases;

import domain.CourseCode;
import fakerepositories.FakeCourseRepository;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class RemoveCourseUseCaseTest {

    private static FakeCourseRepository fakeCourseRepository = new FakeCourseRepository();
    private static RemoveCourseUseCase removeCourseUseCase = new RemoveCourseUseCase(fakeCourseRepository);

    @Test
    public void testRemovingCourses() {
        removeCourseUseCase.removeCourse(CourseCode.create("MAT1"));
        assertFalse(fakeCourseRepository.isOffered(CourseCode.create("MAT1")));
    }
}
