package domain;

import java.util.Objects;

public class StudentName {

    private final String firstName;
    private final String lastName;

    private StudentName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static StudentName create(String firstName, String lastName) {
        validate(firstName);
        validate(lastName);
        return new StudentName(firstName, lastName);
    }

    private static void validate(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("cannot have empty name");
        }

        if (name.matches(".*[^A-Za-z].*")) {
            throw new IllegalArgumentException("names can only contain letters");
        }
    }


    public String createEmail(StudentRegistrationService service) {
        long numDuplicates = service.count(this);
        return numDuplicates == 0 ? simpleEmail() : complexEmail(numDuplicates);
    }

    private String simpleEmail() {
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@mail.university.com";
    }

    private String complexEmail(long numDuplicates) {
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + (numDuplicates + 1) + "@mail.university.com";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentName that = (StudentName) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }
}
