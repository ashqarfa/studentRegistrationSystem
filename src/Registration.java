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
        Account newAccount = createAccount(newStudent, password);
        newStudent.setAccount(newAccount);

        studentAccounts.add(newAccount);
        students.add(newStudent);
        numberOfStudents++;
    }

    private Account createAccount(Student student, String password) {
        String studentEmail = AccountCreator.createUniqueEmailAddress(student, students);
        return new Account(studentEmail, password, student);
    }

    void registerStudentInCourse(Student student, String courseCode) {
        student.studentCourses.add(new Course(courseCode));
    }
}
