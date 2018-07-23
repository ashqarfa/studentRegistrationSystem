import org.junit.Test;
import usecases.AddNewCourseUseCase;

import static org.junit.Assert.assertTrue;


public class AddNewCourseUseCaseTest {

    private static FakeCourseRepository fakeCourseRepository = new FakeCourseRepository();
    private static AddNewCourseUseCase newCourseUseCase = new AddNewCourseUseCase(fakeCourseRepository);

    @Test
    public void testAddingCourses() {
        newCourseUseCase.addNewCourse("MAT1", "Math");
        assertTrue(fakeCourseRepository.isOffered("MAT1"));
    }
}
