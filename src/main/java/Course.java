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

    static void addNewCourse(String courseCode, String courseName) throws IllegalArgumentException{
        if (courseCode.matches(".*[^A-Z0-9].*")) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        coursesOffered.put(courseCode, courseName);
    }

    static void removeCourse(String courseCode) {
        coursesOffered.remove(courseCode);
    }

    static boolean isOffered(String courseCode) {
        return coursesOffered.containsKey(courseCode);
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

