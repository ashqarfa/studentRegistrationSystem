package domain;

import java.util.Objects;

public class Course {

    private final CourseCode courseCode;
    private final String courseName;

    public Course(CourseCode courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public CourseCode getCourseCode() {
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

