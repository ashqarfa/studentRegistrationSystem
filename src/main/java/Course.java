import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Course {

    private static Map<String, String> coursesOffered = new HashMap<>();
    private String courseCode;
    private String courseName;

    Course(String courseCode) {
        this.courseCode = courseCode;
        this.courseName = coursesOffered.get(courseCode);
    }

    static Map<String, String> getCoursesOffered() {
        return coursesOffered;
    }

    static void addNewCourse(String courseCode, String courseName) {
        coursesOffered.put(courseCode, courseName);
    }

    static void removeCourse(String courseCode) {
        coursesOffered.remove(courseCode);
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

