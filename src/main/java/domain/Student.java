package domain;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private int studentID;
    private AccountCreator account = null;
    private List<Course> studentCourses = new ArrayList<>();

    public Student(String firstName, String lastName, int studentID) {
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


    static private boolean validateStudent(String firstName, String lastName, String password) throws IllegalArgumentException {

        if (firstName.isEmpty() || lastName.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("cannot have empty argument");
        }

        if (firstName.matches(".*[^A-Za-z].*") || lastName.matches(".*[^A-Za-z].*")) {
            throw new IllegalArgumentException("names can only contain letters");
        }

        return true;
    }

    static public Student createStudentIfValid(String firstName, String lastName, String password, List<Student> studentList) throws IllegalArgumentException {

        validateStudent(firstName, lastName, password);
        Student newStudent = new Student(firstName, lastName, studentList.size() + 1);
        AccountCreator newAccount = AccountCreator.createAccount(newStudent, password, studentList);
        newStudent.setAccount(newAccount);
        return newStudent;
    }

    private void setAccount(AccountCreator account) {
        this.account = account;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStudentID() {
        return studentID;
    }

    public List<Course> getStudentCourses() {
        return studentCourses;
    }

}