package usecases;

import domain.Course;
import repositories.CourseRepository;

public class AddNewCourseUseCase {
    private final CourseRepository courseRepository;

    public AddNewCourseUseCase(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    void addNewCourse(String courseCode, String courseName) throws IllegalArgumentException {
        Course course = Course.create(courseCode, courseName);
        courseRepository.addCourse(course);
    }
}
