import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;


public class StudentRegistrationTest {

    FakeStudentRepository fakeStudentRepository = new FakeStudentRepository();
    private Registration registrationClass;

    @Before
    public void setUp() {
        registrationClass = new Registration();
        registrationClass.setStudentRepository(fakeStudentRepository);
        fakeStudentRepository.clear();
    }

    @Test
    public void testAddingOneStudent() {

        registrationClass.registerStudent("Farah", "Ashqar", "abcd");
        assertEquals(1, registrationClass.getNumberOfStudents());
        assertEquals(1, fakeStudentRepository.getAllStudents().size());
        assertEquals("Farah", fakeStudentRepository.getAllStudents().get(0).getFirstName());
        assertEquals("Ashqar", fakeStudentRepository.getAllStudents().get(0).getLastName());
        assertEquals("farah.ashqar@mail.university.com", fakeStudentRepository.getAllStudents().get(0).getAccount().getEmail());
        assertEquals("abcd", fakeStudentRepository.getAllStudents().get(0).getAccount().getPassword());
    }

    @Test
    public void testMultiRegistration() {
        registrationClass.registerStudent("Farah", "Ashqar", "abcd");
        registrationClass.registerStudent("Jozef", "Bernat", "efgh");
        registrationClass.registerStudent("Bob", "Smith", "ijkl");
        registrationClass.registerStudent("Issa", "Ashqar", "mno");
        registrationClass.registerStudent("James", "Smith", "pqrs");
        registrationClass.registerStudent("Farah", "Hello", "tu");
        registrationClass.registerStudent("Ed", "Sheeran", "vwx");
        registrationClass.registerStudent("William", "Ashqar", "yz");
        assertEquals(8, registrationClass.getNumberOfStudents());
        assertEquals(8, fakeStudentRepository.getAllStudents().size());
        IntStream.range(0, 7).forEach(n -> assertEquals(n + 1, fakeStudentRepository.getAllStudents().get(n).getStudentID()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArgumentsWithNumbers() {
        registrationClass.registerStudent("Fara!h", "Ashqar", "321");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArgumentsWithEmptyInput() {
        registrationClass.registerStudent("Farah", "", "321");
    }

    @Test(expected = NullPointerException.class)
    public void testArgumentsWithNullInput() {
        registrationClass.registerStudent("Farah", null, "654");
    }
}