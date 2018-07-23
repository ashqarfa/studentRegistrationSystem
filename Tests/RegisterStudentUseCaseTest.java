import org.junit.Before;
import org.junit.Test;
import usecases.RegisterStudentUseCase;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterStudentUseCaseTest {

    private FakeStudentRepository fakeStudentRepository = new FakeStudentRepository();
    private RegisterStudentUseCase registerStudentUseCase = new RegisterStudentUseCase(fakeStudentRepository);


    @Before
    public void setUp() {
        fakeStudentRepository.clear();
    }

    @Test
    public void testAddingOneStudent() {

        registerStudentUseCase.registerStudent("Farah", "Ashqar", "abcd");
        assertEquals(1, fakeStudentRepository.getAllStudents().size());
        assertTrue(fakeStudentRepository.getAllStudents().stream().anyMatch(student -> (
                student.getFirstName().equals("Farah") &&
                        student.getLastName().equals("Ashqar") &&
                        student.getStudentID() == 1 &&
                        student.getAccount().getPassword().equals("abcd") &&
                        student.getAccount().getEmail().equals("farah.ashqar@mail.university.com")
        )));
    }

    @Test
    public void testMultiRegistration() {
        registerStudentUseCase.registerStudent("Farah", "Ashqar", "abcd");
        registerStudentUseCase.registerStudent("Jozef", "Bernat", "efgh");
        registerStudentUseCase.registerStudent("Bob", "Smith", "ijkl");
        registerStudentUseCase.registerStudent("Issa", "Ashqar", "mno");
        registerStudentUseCase.registerStudent("James", "Smith", "pqrs");
        registerStudentUseCase.registerStudent("Farah", "Hello", "tu");
        registerStudentUseCase.registerStudent("Ed", "Sheeran", "vwx");
        registerStudentUseCase.registerStudent("William", "Ashqar", "yz");
        assertEquals(8, fakeStudentRepository.getAllStudents().size());
        IntStream.range(0, 7).forEach(n -> assertEquals(n + 1, fakeStudentRepository.getAllStudents().get(n).getStudentID()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArgumentsWithNumbers() {
        registerStudentUseCase.registerStudent("Fara!h", "Ashqar", "321");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArgumentsWithEmptyInput() {
        registerStudentUseCase.registerStudent("Farah", "", "321");
    }

    @Test(expected = NullPointerException.class)
    public void testArgumentsWithNullInput() {
        registerStudentUseCase.registerStudent("Farah", null, "654");
    }
}
