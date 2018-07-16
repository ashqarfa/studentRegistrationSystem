import java.util.List;

class AccountCreator {

    static String createUniqueEmailAddress(Student student, List<Student> studentList) {

        long numDuplicates = Student.numberOfNameDuplicates(student, studentList);

        if (numDuplicates == 0) return simpleEmail(student);
        else return complexEmail(student, numDuplicates);
    }

    private static String simpleEmail(Student student) {
        return student.firstName.toLowerCase() + "." + student.lastName.toLowerCase() + "@mail.university.com";
    }

    private static String complexEmail(Student student, long numDuplicates) {
        return student.firstName.toLowerCase() + "." + student.lastName.toLowerCase() + (numDuplicates + 1) + "@mail.university.com";
    }
}
