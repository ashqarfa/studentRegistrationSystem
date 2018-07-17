import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Registration {

    private List<Student> students = new ArrayList<>();
    private List<Account> studentAccounts = new ArrayList<>();
    private int numberOfStudents = 0;

    List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    List<Account> getStudentAccounts() {
        return Collections.unmodifiableList(studentAccounts);
    }

    int getNumberOfStudents() {
        return numberOfStudents;
    }

    void registerStudent(String firstName, String lastName, String password) throws IllegalArgumentException {

        if (firstName.isEmpty() || lastName.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("cannot have empty argument");
        }

        if (firstName.matches(".*[^A-Za-z].*") || lastName.matches(".*[^A-Za-z].*")) {
            throw new IllegalArgumentException("names can only contain letters");
        }
        Student newStudent = new Student(firstName, lastName, numberOfStudents + 1);
        Account newAccount = Account.createAccount(newStudent, password, students);
        newStudent.setAccount(newAccount);

        studentAccounts.add(newAccount);
        students.add(newStudent);
        numberOfStudents++;
    }
}
