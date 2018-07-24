package usecases;

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


    @Before
    public void setUp() {
        fakeStudentRepository.clear();
    }

    @Test
    public void testAddingOneStudent() {

        registerStudentUseCase.registerStudent(StudentName.create("Farah"), StudentName.create("Ashqar"), "abcd");
        assertEquals(1, fakeStudentRepository.getAllStudents().size());
        assertTrue(fakeStudentRepository.getAllStudents().stream().anyMatch(student -> (
                student.getFirstName().getName().equals("Farah") &&
                        student.getLastName().getName().equals("Ashqar") &&
                        student.getStudentID() == 1 &&
                        student.getPassword().equals("abcd") &&
                        student.getEmail().equals("farah.ashqar@mail.university.com")
        )));
    }

    @Test
    public void testMultiRegistration() {
        registerStudentUseCase.registerStudent(StudentName.create("Farah"), StudentName.create("Ashqar"), "abcd");
        registerStudentUseCase.registerStudent(StudentName.create("Jozef"), StudentName.create("Bernat"), "efgh");
        registerStudentUseCase.registerStudent(StudentName.create("Bob"), StudentName.create("Smith"), "ijkl");
        registerStudentUseCase.registerStudent(StudentName.create("Issa"), StudentName.create("Ashqar"), "mno");
        registerStudentUseCase.registerStudent(StudentName.create("James"), StudentName.create("Smith"), "pqrs");
        registerStudentUseCase.registerStudent(StudentName.create("Farah"), StudentName.create("Hello"), "tu");
        registerStudentUseCase.registerStudent(StudentName.create("Ed"), StudentName.create("Sheeran"), "vwx");
        registerStudentUseCase.registerStudent(StudentName.create("William"), StudentName.create("Ashqar"), "yz");
        assertEquals(8, fakeStudentRepository.getAllStudents().size());
        IntStream.range(0, 7).forEach(n -> assertEquals(n + 1, fakeStudentRepository.getAllStudents().get(n).getStudentID()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArgumentsWithNumbers() {
        registerStudentUseCase.registerStudent(StudentName.create("Far4h"), StudentName.create("Ashqar"), "321");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArgumentsWithEmptyInput() {
        registerStudentUseCase.registerStudent(StudentName.create("Farah"), StudentName.create(""), "321");
    }
}
