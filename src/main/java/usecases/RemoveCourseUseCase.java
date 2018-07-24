package usecases;

import domain.CourseCode;
import repositories.CourseRepository;

class RemoveCourseUseCase {
    private final CourseRepository courseRepository;

    RemoveCourseUseCase(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    void removeCourse(CourseCode courseCode) {
        courseRepository.deleteCourse(courseCode);
    }
}
