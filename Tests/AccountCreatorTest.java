import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AccountCreatorTest {

    private MockTestingData mockTestingDataClass;
    private List<Student> allStudents = new ArrayList<>();

    @Before
    public void setUp() {
        mockTestingDataClass = new MockTestingData();
        allStudents = mockTestingDataClass.getStudents();
    }

    @Test
    public void createEmailAddressWithEmptyListOfStudents() {
        String expectedEmail = "farah.ashqar@mail.university.com";

        List<Student> studentList = new ArrayList<>();

        String actualEmail = AccountCreator.createUniqueEmailAddress(allStudents.get(0), studentList);

        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void createEmailAddressWithListOfStudentsNoDuplicates() {
        String expectedEmail = "farah.ashqar@mail.university.com";
        List<Student> studentList = new ArrayList<>();
        studentList.add(allStudents.get(3));
        studentList.add(allStudents.get(4));
        studentList.add(allStudents.get(5));

        String actualEmail = AccountCreator.createUniqueEmailAddress(allStudents.get(0), studentList);

        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void createEmailAddressWithOneDuplicate() {
        String expectedEmail = "farah.ashqar2@mail.university.com";
        List<Student> studentList = new ArrayList<>();

        studentList.add(allStudents.get(3));
        studentList.add(allStudents.get(4));
        studentList.add(allStudents.get(5));
        studentList.add(allStudents.get(1));

        String actualEmail = AccountCreator.createUniqueEmailAddress(allStudents.get(0), studentList);

        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void createEmailAddressWithMultipleDuplicates() {
        String expectedEmail = "farah.ashqar3@mail.university.com";
        List<Student> studentList = new ArrayList<>();

        studentList.add(allStudents.get(3));
        studentList.add(allStudents.get(4));
        studentList.add(allStudents.get(5));
        studentList.add(allStudents.get(1));
        studentList.add(allStudents.get(2));

        String actualEmail = AccountCreator.createUniqueEmailAddress(allStudents.get(0), studentList);

        assertEquals(expectedEmail, actualEmail);
    }
}