import java.util.List;

class AccountCreator {

    static String createUniqueEmail(Student student, List<Student> studentList) {

        long numDuplicates = Student.numberOfNameDuplicates(student, studentList);

        if (numDuplicates == 0) return simpleEmail(student);
        else return complexEmail(student, numDuplicates);
    }

    private static String simpleEmail(Student student) {
        return student.firstName + "." + student.lastName + "@mail.university.com";
    }

    private static String complexEmail(Student student, long numDuplicates) {
        return student.firstName + "." + student.lastName + (numDuplicates + 1) + "@mail.university.com";
    }
}
