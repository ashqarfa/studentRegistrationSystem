package domain;

import java.util.List;
import java.util.Objects;

public class AccountCreator {

    private String email;
    private String password;
    private Student student;

    private AccountCreator(String email, String password, Student student) {
        this.email = email;
        this.password = password;
        this.student = student;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    static AccountCreator createAccount(Student student, String password, List<Student> students) {
        String studentEmail = createUniqueEmailAddress(student, students);
        return new AccountCreator(studentEmail, password, student);
    }

    static String createUniqueEmailAddress(Student student, List<Student> studentList) {
        long numDuplicates = student.numberOfNameDuplicates(studentList);
        if (numDuplicates == 0) return simpleEmail(student);
        else return complexEmail(student, numDuplicates);
    }

    private static String simpleEmail(Student student) {
        return student.getFirstName().toLowerCase() + "." + student.getLastName().toLowerCase() + "@mail.university.com";
    }

    private static String complexEmail(Student student, long numDuplicates) {
        return student.getFirstName().toLowerCase() + "." + student.getLastName().toLowerCase() + (numDuplicates + 1) + "@mail.university.com";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountCreator that = (AccountCreator) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(student, that.student);
    }

}
