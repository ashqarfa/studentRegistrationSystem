import javax.activity.InvalidActivityException;
import java.util.ArrayList;
import java.util.List;

class Student {

    private String firstName;
    private String lastName;
    private int studentID;
    private AccountCreator account = null;
    private List<Course> studentCourses = new ArrayList<>();

    Student(String firstName, String lastName, int studentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
    }

    public AccountCreator getAccount() {
        return account;
    }

    static long numberOfNameDuplicates(Student student, List<Student> students) {
        return students.stream().filter(st -> (st.firstName.equals(student.firstName)) && (st.lastName.equals(student.lastName))).count();
    }

    void registerStudentInCourse(String courseCode, String courseName) throws InvalidActivityException {
        if (!Course.isOffered(courseCode))
            throw new InvalidActivityException("Course does not exist");
        this.studentCourses.add(new Course(courseCode, courseName));
    }

    void setAccount(AccountCreator account) {
        this.account = account;
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


}