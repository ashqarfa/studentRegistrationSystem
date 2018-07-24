package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentTest {

    @Test
    public void checkNumberOfNameDuplicates() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Farah", "Ashqar", 1));
        studentList.add(new Student("Jozef", "Bernat", 2));
        studentList.add(new Student("Jozef", "Bernat", 3));

        Student jozef = new Student("Jozef", "Bernat", 4);
        Student farah = new Student("Farah", "Ashqar", 5);
        Student test = new Student("Test", "Student", 6);

        assertEquals(0, test.numberOfNameDuplicates(studentList));
        assertEquals(1, farah.numberOfNameDuplicates(studentList));
        assertEquals(2, jozef.numberOfNameDuplicates(studentList));
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyArgumentTest() {
        List<Student> studentList = new ArrayList<>();
        Student.createStudentIfValid("", "Ashqar", "asc", studentList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void numbersArgumentTest() {
        List<Student> studentList = new ArrayList<>();
        Student.createStudentIfValid("Farah", "As4qar", "asc", studentList);
    }
}