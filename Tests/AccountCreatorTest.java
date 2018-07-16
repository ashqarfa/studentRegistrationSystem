import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AccountCreatorTest {

    private Student farahAshqar;
    private Student farahAshqar2;
    private Student farahAshqar3;
    private Student jozefBernat;
    private Student jozefBernat2;
    private Student willSmith;


    @Before
    public void setUp() {
        farahAshqar = new Student("Farah", "Ashqar", 1);
        farahAshqar2 = new Student("Farah", "Ashqar", 2);
        farahAshqar3 = new Student("Farah", "Ashqar", 3);
        jozefBernat = new Student("Jozef", "Bernat", 4);
        jozefBernat2 = new Student("Jozef", "Bernat", 5);
        willSmith = new Student("Will", "Smith", 6);
    }

    @Test
    public void createEmailAddressWithEmptyListOfStudents() {

        String expectedEmail = "farah.ashqar@mail.university.com";

        List<Student> studentList = new ArrayList<>();

        String actualEmail = AccountCreator.createUniqueEmailAddress(farahAshqar, studentList);

        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void createEmailAddressWithListOfStudentsNoDuplicates() {

        String expectedEmail = "farah.ashqar@mail.university.com";
        List<Student> studentList = new ArrayList<>();

        studentList.add(jozefBernat);
        studentList.add(jozefBernat2);
        studentList.add(willSmith);

        String actualEmail = AccountCreator.createUniqueEmailAddress(farahAshqar, studentList);

        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void createEmailAddressWithOneDuplicate() {


        String expectedEmail = "farah.ashqar2@mail.university.com";
        List<Student> studentList = new ArrayList<>();

        studentList.add(jozefBernat);
        studentList.add(jozefBernat2);
        studentList.add(willSmith);
        studentList.add(farahAshqar2);

        String actualEmail = AccountCreator.createUniqueEmailAddress(farahAshqar, studentList);

        assertEquals(expectedEmail, actualEmail);

    }

    @Test
    public void createEmailAddressWithMultipleDuplicates() {


        String expectedEmail = "farah.ashqar3@mail.university.com";
        List<Student> studentList = new ArrayList<>();

        studentList.add(jozefBernat);
        studentList.add(jozefBernat2);
        studentList.add(willSmith);
        studentList.add(farahAshqar2);
        studentList.add(farahAshqar3);

        String actualEmail = AccountCreator.createUniqueEmailAddress(farahAshqar, studentList);

        assertEquals(expectedEmail, actualEmail);

    }
}