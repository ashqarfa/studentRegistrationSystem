import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();
    private List<Account> studentAccounts = new ArrayList<>();
    private List<Course> offeredCourses = new ArrayList<>();

    private int numberOfStudents = 0;

    private void registerStudent(String firstName, String lastName, String password) {

        Student newStudent = new Student(firstName, lastName, numberOfStudents + 1);
        Account newAccount = createStudentAccount(newStudent, password);
        newStudent.setAccount(newAccount);


        studentAccounts.add(newAccount);
        students.add(newStudent);
        numberOfStudents++;
    }

    private Account createStudentAccount(Student student, String password) {
        String studentEmail = AccountCreator.createUniqueEmail(student, students);
        return new Account(studentEmail, password, student);
    }
}
