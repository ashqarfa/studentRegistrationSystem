package usecases;

import repositories.CourseRepository;

public class RemoveCourseUseCase {
    private final CourseRepository courseRepository;

    public RemoveCourseUseCase(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void removeCourse(String courseCode) {
        courseRepository.deleteCourse(courseCode);
    }
}
