import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.activity.InvalidActivityException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class RegistrationTest {

    Registration registrationClass;

    @Before
    public void setUp() {
        registrationClass = new Registration();
       // initMocks(this);
        //registrationClass = mock(Registration.class);
       // when(registrationClass.registerStudent("Farah", "Ashqar", "abcd")).thenReturn(true);
       // when(registrationClass.getNumberOfStudents()).thenReturn(1);
    }

    @Test
    public void testGetNumberOfStudents() {
        //Arrange
        registrationClass.registerStudent("Farah", "Ashqar", "abcd");

        //when(registrationClass.registerStudent("Farah", "Ashqar", "abcd")).thenReturn(1);

        //Assert
        assertEquals(1, registrationClass.getNumberOfStudents());
        assertEquals(1, registrationClass.getStudentAccounts().size());
        assertEquals(1, registrationClass.getStudents().size());
        assertEquals("Farah", registrationClass.getStudents().get(0).getFirstName());
        assertEquals("Ashqar", registrationClass.getStudents().get(0).getLastName());
        assertEquals("farah.ashqar@mail.university.com", registrationClass.getStudentAccounts().get(0).getEmail());
        assertEquals("abcd", registrationClass.getStudentAccounts().get(0).getPassword());
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
        assertEquals(8, registrationClass.getStudentAccounts().size());
        assertEquals(8, registrationClass.getStudents().size());

        IntStream.range(0, 7).forEach(n -> assertEquals(n + 1, registrationClass.getStudents().get(n).getStudentID()));
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

    @Test
    public void testAddingCourses() throws InvalidActivityException {

        registrationClass.registerStudent("Jozef", "Bernat", "efgh");
        Course.addNewCourse("MAT1", "Math");
        Student student = registrationClass.getStudents().get(0);
        student.registerStudentInCourse("MAT1");
    }

    @Test(expected = InvalidActivityException.class)
    public void testRemovingCourses() throws InvalidActivityException {

        registrationClass.registerStudent("Farah", "Ashqar", "abcd");
        Course.addNewCourse("HIS1", "History");
        Course.removeCourse("HIS1");
        Student student = registrationClass.getStudents().get(0);
        student.registerStudentInCourse("HIS1");
    }

    @Test
    public void checkRegisterStudentToCourse() throws InvalidActivityException {

        registrationClass.registerStudent("Farah", "Ashqar", "abcd");

        Course.addNewCourse("HIS1", "History");
        Course.addNewCourse("MAT1", "Math");

        Student student = registrationClass.getStudents().get(0);
        student.registerStudentInCourse("MAT1");
        student.registerStudentInCourse("HIS1");
        List<Course> studentCourses = student.getStudentCourses();
        List<Course> expectedCourses = new ArrayList<>();
        expectedCourses.add(new Course("MAT1"));
        expectedCourses.add(new Course("HIS1"));
        assertThat(studentCourses, containsInAnyOrder(expectedCourses.toArray()));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testArgumentsInCourse() {
        Course.addNewCourse("HIs1", "History");
    }


}