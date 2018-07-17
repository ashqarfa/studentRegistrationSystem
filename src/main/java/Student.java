import java.util.ArrayList;
import java.util.List;

class Student {

    private String firstName;
    private String lastName;
    private int studentID;
    private Account account;
    private List<Course> studentCourses = new ArrayList<>();

    Student(String firstName, String lastName, int studentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
    }

    static long numberOfNameDuplicates(Student student, List<Student> students) {
        return students.stream().filter(st -> (st.firstName.equals(student.firstName)) && (st.lastName.equals(student.lastName))).count();
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    int getStudentID() {
        return studentID;
    }

    List<Course> getStudentCourses() {
        return studentCourses;
    }

    void setAccount(Account account) {
        this.account = account;
    }
}