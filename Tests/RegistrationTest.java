import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class RegistrationTest {

    private Registration classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new Registration();
    }

    @Test
    public void addStudentsAndCheckRightNumberOfStudents() {
        classUnderTest.registerStudent("Farah", "Ashqar", "abcd");
        assertEquals(classUnderTest.getNumberOfStudents(), 1);

        IntStream.range(0, 7).forEach(id -> classUnderTest.registerStudent("testName", "anotherTestName", "abc"));

        assertEquals(8, classUnderTest.getNumberOfStudents());

    }
}