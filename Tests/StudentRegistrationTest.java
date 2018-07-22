//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.stream.IntStream;
//
//import static org.junit.Assert.assertEquals;
//
//
//public class StudentRegistrationTest {
//
//    private Registration registrationClass;
//
//    @Before
//    public void setUp() {
//        registrationClass = new Registration();
//    }
//
//    @Test
//    public void testGetNumberOfStudents() {
//        //Arrange
//        registrationClass.registerStudent("Farah", "Ashqar", "abcd");
//
//        //Assert
//        assertEquals(1, registrationClass.getNumberOfStudents());
//        assertEquals(1, registrationClass.getStudentAccounts().size());
//        assertEquals(1, registrationClass.getStudents().size());
//        assertEquals("Farah", registrationClass.getStudents().get(0).getFirstName());
//        assertEquals("Ashqar", registrationClass.getStudents().get(0).getLastName());
//        assertEquals("farah.ashqar@mail.university.com", registrationClass.getStudentAccounts().get(0).getEmail());
//        assertEquals("abcd", registrationClass.getStudentAccounts().get(0).getPassword());
//    }
//
//    @Test
//    public void testMultiRegistration() {
//        registrationClass.registerStudent("Farah", "Ashqar", "abcd");
//        registrationClass.registerStudent("Jozef", "Bernat", "efgh");
//        registrationClass.registerStudent("Bob", "Smith", "ijkl");
//        registrationClass.registerStudent("Issa", "Ashqar", "mno");
//        registrationClass.registerStudent("James", "Smith", "pqrs");
//        registrationClass.registerStudent("Farah", "Hello", "tu");
//        registrationClass.registerStudent("Ed", "Sheeran", "vwx");
//        registrationClass.registerStudent("William", "Ashqar", "yz");
//
//        assertEquals(8, registrationClass.getNumberOfStudents());
//        assertEquals(8, registrationClass.getStudentAccounts().size());
//        assertEquals(8, registrationClass.getStudents().size());
//
//        IntStream.range(0, 7).forEach(n -> assertEquals(n + 1, registrationClass.getStudents().get(n).getStudentID()));
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testArgumentsWithNumbers() {
//        registrationClass.registerStudent("Fara!h", "Ashqar", "321");
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testArgumentsWithEmptyInput() {
//        registrationClass.registerStudent("Farah", "", "321");
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void testArgumentsWithNullInput() {
//        registrationClass.registerStudent("Farah", null, "654");
//    }
//}