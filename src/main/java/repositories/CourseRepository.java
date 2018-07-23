package repositories;

import domain.Course;

public interface CourseRepository {

    void deleteCourse(String courseCode);

    boolean isOffered(String courseCode);

    void addCourse(Course course);
}
