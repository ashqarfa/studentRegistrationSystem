package domain;

import java.util.Objects;

public class Course {

    private final String courseCode;
    private final String courseName;

    private Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public static Course create(String courseCode, String courseName) {
        if (courseCode.matches(".*[^A-Z0-9].*")) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        return new Course(courseCode, courseName);
    }

    public String getCourseCode() {
        return courseCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseCode, course.courseCode) &&
                Objects.equals(courseName, course.courseName);
    }
}

