import java.util.HashMap;
import java.util.Map;

public class FakeCourseRepository implements CourseRepository {

    private static Map<String, String> coursesOffered = new HashMap<>();

    @Override
    public void addCourse(String courseCode, String courseName) {
        coursesOffered.put(courseCode, courseName);
    }

    @Override
    public void removeCourse(String courseCode) {
        coursesOffered.remove(courseCode);
    }

    @Override
    public String getCourseNameIfFound(String courseCode) {
        return coursesOffered.get(courseCode);
    }

    public void clear() {
        coursesOffered.clear();
    }
}
