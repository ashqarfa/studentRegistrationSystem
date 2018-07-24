package usecases;

import domain.Course;
import domain.CourseCode;
import repositories.CourseRepository;

class AddNewCourseUseCase {
    private final CourseRepository courseRepository;

    AddNewCourseUseCase(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    void addNewCourse(CourseCode courseCode, String courseName) throws IllegalArgumentException {
        Course course = new Course(courseCode, courseName);
        courseRepository.addCourse(course);
    }
}
