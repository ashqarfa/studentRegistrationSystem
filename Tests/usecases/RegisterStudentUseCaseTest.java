package usecases;

import domain.FakeStudentRegistrationService;
import domain.StudentName;
import fakerepositories.FakeStudentRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterStudentUseCaseTest {

    private FakeStudentRepository fakeStudentRepository = new FakeStudentRepository();
    private RegisterStudentUseCase registerStudentUseCase = new RegisterStudentUseCase(fakeStudentRepository);
    private FakeStudentRegistrationService fakeStudentRegistrationService = new FakeStudentRegistrationService(fakeStudentRepository);


    @Before
    public void setUp() {
        fakeStudentRepository.clear();
    }

    @Test
    public void testAddingOneStudent() {

        registerStudentUseCase.registerStudent(StudentName.create("Farah", "Ashqar"), "abcd", fakeStudentRegistrationService);
        assertEquals(1, fakeStudentRepository.getAllStudents().size());
        assertTrue(fakeStudentRepository.getAllStudents().stream().anyMatch(student -> (
                student.getName().getFirstName().equals("Farah") &&
                        student.getName().getLastName().equals("Ashqar") &&
                        student.getStudentID() == 1 &&
                        student.getPassword().equals("abcd") &&
                        student.getEmail().equals("farah.ashqar@mail.university.com")
        )));
    }

    @Test
    public void testMultiRegistration() {
        registerStudentUseCase.registerStudent(StudentName.create("Farah", "Ashqar"), "abcd", fakeStudentRegistrationService);
        registerStudentUseCase.registerStudent(StudentName.create("Jozef", "Bernat"), "efgh", fakeStudentRegistrationService);
        registerStudentUseCase.registerStudent(StudentName.create("Bob", "Smith"), "ijkl", fakeStudentRegistrationService);
        registerStudentUseCase.registerStudent(StudentName.create("Issa", "Ashqar"), "mno", fakeStudentRegistrationService);
        registerStudentUseCase.registerStudent(StudentName.create("James", "Smith"), "pqrs", fakeStudentRegistrationService);
        registerStudentUseCase.registerStudent(StudentName.create("Farah", "Hello"), "tu", fakeStudentRegistrationService);
        registerStudentUseCase.registerStudent(StudentName.create("Ed", "Sheeran"), "vwx", fakeStudentRegistrationService);
        registerStudentUseCase.registerStudent(StudentName.create("William", "Ashqar"), "yz", fakeStudentRegistrationService);
        assertEquals(8, fakeStudentRepository.getAllStudents().size());
        IntStream.range(0, 7).forEach(n -> assertEquals(n + 1, fakeStudentRepository.getAllStudents().get(n).getStudentID()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArgumentsWithNumbers() {
        registerStudentUseCase.registerStudent(StudentName.create("Far4h", "Ashqar"), "321", fakeStudentRegistrationService);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArgumentsWithEmptyInput() {
        registerStudentUseCase.registerStudent(StudentName.create("Farah", ""), "321", fakeStudentRegistrationService);
    }
}
