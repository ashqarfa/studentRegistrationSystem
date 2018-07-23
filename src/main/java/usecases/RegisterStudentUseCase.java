package usecases;

import domain.Student;
import repositories.StudentRepository;

public class RegisterStudentUseCase {

    private final StudentRepository studentRepository;

    public RegisterStudentUseCase(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void registerStudent(String firstName, String lastName, String password) {

        Student newStudent = Student.createStudentIfValid(firstName, lastName, password, studentRepository.getAllStudents());
        studentRepository.addStudent(newStudent);

    }
}
