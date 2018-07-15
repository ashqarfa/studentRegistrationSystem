import java.util.ArrayList;
import java.util.List;

public class University {

    List<Student> students = new ArrayList<>();
    List<Account> studentAccounts = new ArrayList<>();
    private int numberOfStudents = 0;

    private void registerStudent(String firstName, String lastName) {

        students.add(new Student(firstName, lastName, numberOfStudents + 1));
        numberOfStudents++;
    }
}
