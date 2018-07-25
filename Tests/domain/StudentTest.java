package domain;

import fakerepositories.FakeStudentRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {

    private FakeStudentRepository fakeStudentRepository = new FakeStudentRepository();
    private FakeStudentRegistrationService fakeStudentRegistrationService = new FakeStudentRegistrationService(fakeStudentRepository);

    @Before
    public void setUp() {
        fakeStudentRepository.clear();
        fakeStudentRepository.addStudent(new Student(StudentName.create("Farah", "Ashqar"), 1, "farah.ashqar@mail.university.com", "abcd"));
        fakeStudentRepository.addStudent(new Student(StudentName.create("Jozef", "Bernat"), 2, "jozef.bernat@mail.university.com", "abcd"));
        fakeStudentRepository.addStudent(new Student(StudentName.create("Jozef", "Bernat"), 3, "jozef.bernat2@mail.university.com", "abcd"));
        fakeStudentRepository.addStudent(new Student(StudentName.create("Test", "Hello"), 4, "test.hello@mail.university.com", "abcd"));
    }

    @Test
    public void checkNumberOfNameDuplicates() {
        assertEquals(0, fakeStudentRegistrationService.count(StudentName.create("Test", "Hi")));
        assertEquals(1, fakeStudentRegistrationService.count(StudentName.create("Farah", "Ashqar")));
        assertEquals(2, fakeStudentRegistrationService.count(StudentName.create("Jozef", "Bernat")));
    }

    @Test
    public void createEmailAddressWithListOfStudentsNoDuplicates() {
        StudentName studentName = StudentName.create("Fero", "Cerveny");
        String expectedEmail = "fero.cerveny@mail.university.com";
        String actualEmail = studentName.createEmail(fakeStudentRegistrationService);
        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void createEmailAddressWithListOfStudentsOneDuplicate() {
        StudentName studentName = StudentName.create("Farah", "Ashqar");
        String expectedEmail = "farah.ashqar2@mail.university.com";
        String actualEmail = studentName.createEmail(fakeStudentRegistrationService);
        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void createEmailAddressWithListOfStudentsTwoDuplicates() {
        StudentName studentName = StudentName.create("Jozef", "Bernat");
        String expectedEmail = "jozef.bernat3@mail.university.com";
        String actualEmail = studentName.createEmail(fakeStudentRegistrationService);
        assertEquals(expectedEmail, actualEmail);
    }
}