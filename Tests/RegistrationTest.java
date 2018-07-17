import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

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

        assertEquals("Farah", registrationClass.getStudents().get(0).firstName);
        assertEquals("Ashqar", registrationClass.getStudents().get(0).lastName);
        assertEquals("James", registrationClass.getStudents().get(4).firstName);
        assertEquals("Smith", registrationClass.getStudents().get(4).lastName);

        assertEquals("farah.ashqar@mail.university.com", registrationClass.getStudentAccounts().get(0).email);
        assertEquals("ed.sheeran@mail.university.com", registrationClass.getStudentAccounts().get(6).email);
        assertEquals("abcd", registrationClass.getStudentAccounts().get(0).password);
        assertEquals("mno", registrationClass.getStudentAccounts().get(3).password);

        IntStream.range(0, 7).forEach(n -> assertEquals(n + 1, registrationClass.getStudents().get(n).studentID));
    }

    @Test
    public void testAddingCourses() {

        registrationClass.registerStudent("Farah", "Ashqar", "abcd");
        registrationClass.registerStudent("Jozef", "Bernat", "efgh");

        registrationClass.registerStudentInCourse(registrationClass.getStudents().get(0), "MAT1");
        

    }


    //    @Before
//    public void setUp() {
//
//
//        Course.addNewCourse("HIS1", "History");
//        Course.addNewCourse("MAT1", "Math");
//    }
//
//
//    @Test
//    public void chceckRegisterStudentToCourse() {
//        registrationClass.registerStudentInCourse(registrationClass.getStudents().get(1),"MAT1");
//        registrationClass.registerStudentInCourse(registrationClass.getStudents().get(1),"HIS1");
//        assertEquals("MAT1",registrationClass.getStudents().get(1).studentCourses.get(0).getCourseCode());
//        assertEquals("HIS1",registrationClass.getStudents().get(1).studentCourses.get(1).getCourseCode());
//    }
}