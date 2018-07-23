import domain.AccountCreator;
import domain.Student;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AccountCreatorTest {

    private static List<Student> allStudents = new ArrayList<>();

    @BeforeClass
    public static void setUp() {

        FakeStudentRepository fakeStudentRepository = new FakeStudentRepository();
        fakeStudentRepository.addStudent(new Student("Jozef", "Bernat", 1));
        fakeStudentRepository.addStudent(new Student("Jozef", "Bernat", 2));
        fakeStudentRepository.addStudent(new Student("Farah", "Ashqar", 3));
        fakeStudentRepository.addStudent(new Student("Fero", "Bernat", 4));
        allStudents = fakeStudentRepository.getAllStudents();
    }


    @Test
    public void createEmailAddressWithListOfStudentsNoDuplicates() {
        String expectedEmail = "fero.cerveny@mail.university.com";
        Student student = new Student("Fero", "Cerveny", 5);
        String actualEmail = AccountCreator.createUniqueEmailAddress(student, allStudents);
        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void createEmailAddressWithOneDuplicate() {
        String expectedEmail = "farah.ashqar2@mail.university.com";
        Student student = new Student("Farah", "Ashqar", 5);
        String actualEmail = AccountCreator.createUniqueEmailAddress(student, allStudents);
        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void createEmailAddressWithMultipleDuplicates() {
        String expectedEmail = "jozef.bernat3@mail.university.com";
        Student student = new Student("Jozef", "Bernat", 5);
        String actualEmail = AccountCreator.createUniqueEmailAddress(student, allStudents);
        assertEquals(expectedEmail, actualEmail);
    }
}