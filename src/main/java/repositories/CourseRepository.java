package repositories;

import domain.Course;
import domain.CourseCode;

public interface CourseRepository {

    void deleteCourse(CourseCode courseCode);

    boolean isOffered(CourseCode courseCode);

    void addCourse(Course course);
}
