import org.junit.Test;

import javax.activity.InvalidActivityException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class RegistrationTest {

    private Registration registrationClass = new Registration();
    
    @Test
    public void studentRegistrationTest() {

        registrationClass.registerStudent("Farah", "Ashqar", "abcd");
        registrationClass.registerStudent("Jozef", "Bernat", "efgh");
        registrationClass.registerStudent("Bob", "Smith", "ijkl");
        registrationClass.registerStudent("Issa", "Ashqar", "mno");
        registrationClass.registerStudent("James", "Smith", "pqrs");
        registrationClass.registerStudent("Farah", "Hello", "tu");
        registrationClass.registerStudent("Ed", "Sheeran", "vwx");
        registrationClass.registerStudent("William", "Ashqar", "yz");

        assertEquals(8, registrationClass.getNumberOfStudents());
        assertEquals(8, registrationClass.getStudentAccounts().size());
        assertEquals(8, registrationClass.getStudents().size());

        assertEquals("Farah", registrationClass.getStudents().get(0).getFirstName());
        assertEquals("Ashqar", registrationClass.getStudents().get(0).getLastName());
        assertEquals("James", registrationClass.getStudents().get(4).getFirstName());
        assertEquals("Smith", registrationClass.getStudents().get(4).getLastName());

        assertEquals("farah.ashqar@mail.university.com", registrationClass.getStudentAccounts().get(0).getEmail());
        assertEquals("ed.sheeran@mail.university.com", registrationClass.getStudentAccounts().get(6).getEmail());
        assertEquals("abcd", registrationClass.getStudentAccounts().get(0).getPassword());
        assertEquals("mno", registrationClass.getStudentAccounts().get(3).getPassword());

        IntStream.range(0, 7).forEach(n -> assertEquals(n + 1, registrationClass.getStudents().get(n).getStudentID()));
    }

    @Test
    public void testAddingCourses() throws InvalidActivityException {

        registrationClass.registerStudent("Jozef", "Bernat", "efgh");
        Course.addNewCourse("MAT1", "Math");
        registrationClass.registerStudentInCourse(registrationClass.getStudents().get(0), "MAT1");
    }

    @Test(expected = InvalidActivityException.class)
    public void testRemovingCourses() throws InvalidActivityException {

        registrationClass.registerStudent("Farah", "Ashqar", "abcd");
        Course.addNewCourse("HIS1", "History");
        Course.removeCourse("HIS1");
        registrationClass.registerStudentInCourse(registrationClass.getStudents().get(0), "HIS1");
    }


    @Test
    public void checkRegisterStudentToCourse() throws InvalidActivityException {

        registrationClass.registerStudent("Farah", "Ashqar", "abcd");

        Course.addNewCourse("HIS1", "History");
        Course.addNewCourse("MAT1", "Math");

        registrationClass.registerStudentInCourse(registrationClass.getStudents().get(0), "MAT1");
        registrationClass.registerStudentInCourse(registrationClass.getStudents().get(0), "HIS1");

        List<Course> studentCourses = registrationClass.getStudents().get(0).getStudentCourses();
        List<Course> expectedCourses = new ArrayList<>();
        expectedCourses.add(new Course("MAT1"));
        expectedCourses.add(new Course("HIS1"));

        assertThat(studentCourses, containsInAnyOrder(expectedCourses.toArray()));

    }
}