import java.util.Objects;

class Course {

    private String courseCode;
    private String courseName;
    private static CourseRepository courseRepository = null;

    Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    static void addNewCourse(String courseCode, String courseName) throws IllegalArgumentException{
        if (courseCode.matches(".*[^A-Z0-9].*")) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        courseRepository.addCourse(courseCode, courseName);
    }

    static void removeCourse(String courseCode) {
        courseRepository.removeCourse(courseCode);
    }

    static boolean isOffered(String courseCode) {

        return (courseRepository.getCourseNameIfFound(courseCode) != null);
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

