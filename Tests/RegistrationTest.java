import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    private Registration classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new Registration();
        classUnderTest.registerStudent("Farah", "Ashqar", "abcd");
        classUnderTest.registerStudent("Jozef", "Bernat", "efgh");
        classUnderTest.registerStudent("Bob", "Smith", "ijkl");
        classUnderTest.registerStudent("Issa", "Ashqar", "mno");
        classUnderTest.registerStudent("James", "Smith", "pqrs");
        classUnderTest.registerStudent("Farah", "Hello", "tu");
        classUnderTest.registerStudent("Ed", "Sheeran", "vwx");
        classUnderTest.registerStudent("William", "Ashqar", "yz");
        Course.addNewCourse("HIS1", "History");
        Course.addNewCourse("MAT1", "Math");
    }

    @Test
    public void checkRightNumberOfStudentsAndAccounts() {

        assertEquals(8, classUnderTest.getNumberOfStudents());
        assertEquals(8, classUnderTest.getStudentAccounts().size());
        assertEquals(8, classUnderTest.getStudents().size());

    }

    @Test
    public void checkRightNamesAndAccountsInLists() {


        assertEquals("Farah", classUnderTest.getStudents().get(0).firstName);
        assertEquals("Ashqar", classUnderTest.getStudents().get(0).lastName);
        assertEquals("James", classUnderTest.getStudents().get(4).firstName);
        assertEquals("Smith", classUnderTest.getStudents().get(4).lastName);

        assertEquals("farah.ashqar@mail.university.com", classUnderTest.getStudentAccounts().get(0).email);
        assertEquals("ed.sheeran@mail.university.com", classUnderTest.getStudentAccounts().get(6).email);
        assertEquals("abcd", classUnderTest.getStudentAccounts().get(0).password);
        assertEquals("mno", classUnderTest.getStudentAccounts().get(3).password);
    }

    @Test
    public void checkRightStudentIDs() {
        IntStream.range(0, 7).forEach(n -> assertEquals(n + 1, classUnderTest.getStudents().get(n).studentID));
    }

    @Test
    public void chceckRegisterStudentToCourse() throws Exception {
        classUnderTest.registerStudentInCourse(classUnderTest.getStudents().get(1),"MAT1");
        classUnderTest.registerStudentInCourse(classUnderTest.getStudents().get(1),"HIS1");
        assertEquals("MAT1",classUnderTest.getStudents().get(1).studentCourses.get(0).getCourseCode());
        assertEquals("HIS1",classUnderTest.getStudents().get(1).studentCourses.get(1).getCourseCode());
    }

    @Test
    public void addNewCourseTest() {
        boolean check = true;
        assertEquals("History", Course.getCoursesOffered().get("HIS1"));
        assertEquals("Math", Course.getCoursesOffered().get("MAT1"));
        try {
            classUnderTest.registerStudentInCourse(classUnderTest.getStudents().get(1), "HIS1");
        }
        catch (Exception e) {
            check = false;
        }
        assertTrue(check);
    }

    @Test
    public void removeCourseTest() {
        Course.removeCourse("HIS1");
        assertNull(Course.getCoursesOffered().get("HIS1"));
    }
}