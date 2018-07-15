import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();
    private List<Course> offeredCourses = new ArrayList<>();


    private int numberOfStudents = 0;

    private void registerStudent(String firstName, String lastName) {

        students.add(new Student(firstName, lastName, numberOfStudents + 1));
        numberOfStudents++;
    }

    private void createStudentAccount(String firstName, String lastName) {


    }
}
