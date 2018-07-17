import javax.activity.InvalidActivityException;
import java.util.ArrayList;
import java.util.List;

class Registration {

    private List<Student> students = new ArrayList<>();
    private List<Account> studentAccounts = new ArrayList<>();
    private int numberOfStudents = 0;

    List<Student> getStudents() {
        return students;
    }

    List<Account> getStudentAccounts() {
        return studentAccounts;
    }

    int getNumberOfStudents() {
        return numberOfStudents;
    }

    void registerStudent(String firstName, String lastName, String password) {

        Student newStudent = new Student(firstName, lastName, numberOfStudents + 1);
        Account newAccount = AccountCreator.createAccount(newStudent, password, students);
        newStudent.setAccount(newAccount);

        studentAccounts.add(newAccount);
        students.add(newStudent);
        numberOfStudents++;
    }


    void registerStudentInCourse(Student student, String courseCode) throws InvalidActivityException {
        if (Course.getCoursesOffered().containsKey(courseCode))
            student.getStudentCourses().add(new Course(courseCode));
        else
            throw new InvalidActivityException("Course does not exist");
    }
}