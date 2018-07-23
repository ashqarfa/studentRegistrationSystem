package usecases;

import domain.Course;
import domain.Student;
import repositories.CourseRepository;
import repositories.StudentRepository;

public class RegisterStudentInCourseUseCase {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public RegisterStudentInCourseUseCase(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    void registerStudentInCourse(int studentID, Course course) {

        if (courseRepository.isOffered(course.getCourseCode())) {
            Student student = studentRepository.getStudentByID(studentID);
            student.getStudentCourses().add(course);
        }
    }
}
