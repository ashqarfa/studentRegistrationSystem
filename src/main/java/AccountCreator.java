import java.util.List;

class AccountCreator {

    static Account createAccount(Student student, String password, List<Student> students) {
        String studentEmail = AccountCreator.createUniqueEmailAddress(student, students);
        return new Account(studentEmail, password, student);
    }

    static String createUniqueEmailAddress(Student student, List<Student> studentList) {

        long numDuplicates = Student.numberOfNameDuplicates(student, studentList);

        if (numDuplicates == 0) return simpleEmail(student);
        else return complexEmail(student, numDuplicates);
    }

    private static String simpleEmail(Student student) {
        return student.getFirstName().toLowerCase() + "." + student.getLastName().toLowerCase() + "@mail.university.com";
    }

    private static String complexEmail(Student student, long numDuplicates) {
        return student.getFirstName().toLowerCase() + "." + student.getLastName().toLowerCase() + (numDuplicates + 1) + "@mail.university.com";
    }
}
