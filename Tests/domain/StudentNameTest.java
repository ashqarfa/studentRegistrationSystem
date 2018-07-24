package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentNameTest {
    @Test
    public void validStudentNameTest() {
        StudentName studentName = StudentName.create("Jozef", "Bernat");
        assertEquals("Jozef", studentName.getFirstName());
        assertEquals("Bernat", studentName.getLastName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidStudentNameWithNumberTest() {
        StudentName.create("Jo3ef", "Bernat");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidStudentNameWithEmptyNameTest() {
        StudentName.create("", "Hi");
    }

}