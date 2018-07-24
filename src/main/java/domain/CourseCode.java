package domain;

import java.util.Objects;

public class CourseCode {

    private final String code;

    private CourseCode(String code) {
        this.code = code;
    }

    public static CourseCode create(String code) {
        if (code.matches(".*[^A-Z0-9].*")) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        return new CourseCode(code);
    }

    String getCourseCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseCode that = (CourseCode) o;
        return Objects.equals(code, that.code);
    }
}
