package domain;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private StudentName firstName;
    private StudentName lastName;
    private int studentID;
    private String email;
    private String password;
    private List<Course> studentCourses = new ArrayList<>();

    public Student(StudentName firstName, StudentName lastName, int studentID, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.email = email;
        this.password = password;
    }

    static public Student createStudentIfValid(StudentName firstName, StudentName lastName, String password, List<Student> studentList) throws IllegalArgumentException {
        String studentEmail = createUniqueEmailAddress(firstName, lastName, studentList);
        return new Student(firstName, lastName, studentList.size() + 1, studentEmail, password);
    }

    static long numberOfNameDuplicates(StudentName firstName, StudentName lastName, List<Student> students) {
        return students.stream().filter(st -> (st.firstName.equals(firstName)) && (st.lastName.equals(lastName))).count();
    }

    private static String createUniqueEmailAddress(StudentName firstName, StudentName lastName, List<Student> studentList) {
        long numDuplicates = numberOfNameDuplicates(firstName, lastName, studentList);
        if (numDuplicates == 0) return simpleEmail(firstName, lastName);
        else return complexEmail(firstName, lastName, numDuplicates);
    }

    private static String simpleEmail(StudentName firstName, StudentName lastName) {
        return firstName.getName().toLowerCase() + "." + lastName.getName().toLowerCase() + "@mail.university.com";
    }

    private static String complexEmail(StudentName firstName, StudentName lastName, long numDuplicates) {
        return firstName.getName().toLowerCase() + "." + lastName.getName().toLowerCase() + (numDuplicates + 1) + "@mail.university.com";
    }

    public StudentName getFirstName() {
        return firstName;
    }

    public StudentName getLastName() {
        return lastName;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getEmail() {
        return email;
    }

    public List<Course> getStudentCourses() {
        return studentCourses;
    }

    public String getPassword() {
        return password;
    }
}