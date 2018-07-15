import java.util.List;

public class Student {

    String firstName;
    String lastName;
    int studentID;
    Account account;

    public Student(String firstName, String lastName, int studentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
    }

    public static boolean checkNameDuplicate(Student student, List<Student> students) {
        return students.stream().anyMatch(st -> (st.firstName.equals(student.firstName)) && (st.lastName.equals(student.lastName)));
    }
}