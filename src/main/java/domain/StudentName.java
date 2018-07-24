package domain;

import java.util.Objects;

public class StudentName {

    private final String name;

    private StudentName(String name) {
        this.name = name;
    }

    public static StudentName create(String name) {

        if (name.isEmpty()) {
            throw new IllegalArgumentException("cannot have empty name");
        }

        if (name.matches(".*[^A-Za-z].*")) {
            throw new IllegalArgumentException("names can only contain letters");
        }
        return new StudentName(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentName that = (StudentName) o;
        return Objects.equals(name, that.name);
    }
}
