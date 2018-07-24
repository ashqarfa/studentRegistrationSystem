package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentNameTest {
    @Test
    public void validStudentNameTest() {
        StudentName studentName = StudentName.create("Jozef");
        assertEquals("Jozef", studentName.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidStudentNameWithNumberTest() {
        StudentName.create("Jo3ef");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidStudentNameWithEmptyNameTest() {
        StudentName.create("");
    }

}