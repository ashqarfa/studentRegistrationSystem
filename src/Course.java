import java.util.HashMap;
import java.util.Map;

class Course {


    private static Map<String, String> coursesOffered = new HashMap<>();
    private String courseCode;
    private String courseName;
    private CourseStatus courseStatus;


    Course(String courseCode) {

        this.courseCode = courseCode;
        this.courseName = coursesOffered.get(courseCode);
        this.courseStatus = CourseStatus.inProgress;
    }

    static void addNewCourse(String courseCode, String courseName) {
        coursesOffered.put(courseCode, courseName);
    }

    static void removeCourse(String courseCode) {
        coursesOffered.remove(courseCode);
    }

    static Map<String, String> getCoursesOffered(){
        return coursesOffered;
    }

    public String getCourseCode() {
        return courseCode;
    }

    enum CourseStatus {failed, passed, inProgress}
}

