package domain;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private StudentName name;
    private int studentID;
    private String email;
    private String password;
    private List<Course> studentCourses = new ArrayList<>();

    public Student(StudentName name, int studentID, String email, String password) {
        this.name = name;
        this.studentID = studentID;
        this.email = email;
        this.password = password;
    }

    static public Student create(StudentName name, String password, StudentRegistrationService service) throws IllegalArgumentException {
        return new Student(name, service.newId(), name.createEmail(service), password);
    }

    public StudentName getName() {
        return name;
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