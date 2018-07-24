package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentTest {

    private List<Student> studentList = new ArrayList<>();

    @Before
    public void setUp() {
        studentList.add(new Student(StudentName.create("Farah"), StudentName.create("Ashqar"), 1, "farah.ashqar@mail.university.com", "abcd"));
        studentList.add(new Student(StudentName.create("Jozef"), StudentName.create("Bernat"), 2, "jozef.bernat@mail.university.com", "abcd"));
        studentList.add(new Student(StudentName.create("Jozef"), StudentName.create("Bernat"), 3, "jozef.bernat2@mail.university.com", "abcd"));
        studentList.add(new Student(StudentName.create("Test"), StudentName.create("hello"), 4, "test.hello@mail.university.com", "abcd"));
    }

    @Test
    public void checkNumberOfNameDuplicates() {
        assertEquals(0, Student.numberOfNameDuplicates(StudentName.create("Test"), StudentName.create("hi"), studentList));
        assertEquals(1, Student.numberOfNameDuplicates(StudentName.create("Farah"), StudentName.create("Ashqar"), studentList));
        assertEquals(2, Student.numberOfNameDuplicates(StudentName.create("Jozef"), StudentName.create("Bernat"), studentList));
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyArgumentTest() {
        List<Student> studentList = new ArrayList<>();
        Student.createStudentIfValid(StudentName.create(""), StudentName.create("Ashqar"), "sd", studentList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void numbersArgumentTest() {
        List<Student> studentList = new ArrayList<>();
        Student.createStudentIfValid(StudentName.create("Farah"), StudentName.create("Ash2ar"), "asc", studentList);
    }

    @Test
    public void createEmailAddressWithListOfStudentsNoDuplicates() {
        String expectedEmail = "fero.cerveny@mail.university.com";
        Student student = Student.createStudentIfValid(StudentName.create("Fero"), StudentName.create("Cerveny"), "fdf", studentList);
        String actualEmail = student.getEmail();
        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void createEmailAddressWithListOfStudentsOneDuplicate() {
        String expectedEmail = "farah.ashqar2@mail.university.com";
        Student student = Student.createStudentIfValid(StudentName.create("Farah"), StudentName.create("Ashqar"), "fdf", studentList);
        String actualEmail = student.getEmail();
        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void createEmailAddressWithListOfStudentsTwoDuplicates() {
        String expectedEmail = "jozef.bernat3@mail.university.com";
        Student student = Student.createStudentIfValid(StudentName.create("Jozef"), StudentName.create("Bernat"), "fdf", studentList);
        String actualEmail = student.getEmail();
        assertEquals(expectedEmail, actualEmail);
    }
}