package usecases;

import fakerepositories.FakeCourseRepository;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class RemoveCourseUseCaseTest {

    private static FakeCourseRepository fakeCourseRepository = new FakeCourseRepository();
    private static RemoveCourseUseCase removeCourseUseCase = new RemoveCourseUseCase(fakeCourseRepository);

    @Test
    public void testRemovingCourses() {
        removeCourseUseCase.removeCourse("MAT1");
        assertFalse(fakeCourseRepository.isOffered("MAT1"));
    }
}
