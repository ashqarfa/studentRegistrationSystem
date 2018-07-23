import domain.Course;
import repositories.CourseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FakeCourseRepository implements CourseRepository {

    private static List<Course> coursesOffered = new ArrayList<>();


    @Override
    public void deleteCourse(String courseCode) {
        coursesOffered = coursesOffered.stream().filter(course -> !(course.getCourseCode().equals(courseCode))).collect(Collectors.toList());
    }

    @Override
    public boolean isOffered(String courseCode) {
        return coursesOffered.stream().anyMatch(course -> course.getCourseCode().equals(courseCode));
    }

    @Override
    public void addCourse(Course course) {
        coursesOffered.add(course);
    }

    public void clear() {
        coursesOffered.clear();
    }
}
