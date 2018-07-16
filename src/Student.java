import java.util.ArrayList;
import java.util.List;

class Student {

    String firstName;
    String lastName;
    int studentID;
    private Account account;
    List<Course> courses = new ArrayList<>();

    Student(String firstName, String lastName, int studentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
    }

    static long numberOfNameDuplicates(Student student, List<Student> students) {
        return students.stream().filter(st -> (st.firstName.equals(student.firstName)) && (st.lastName.equals(student.lastName))).count();
    }

    void setAccount(Account account) {
        this.account = account;
    }

    void addCourse(Course course) {
        this.courses.add(course);
    }

}