package usecases;

import domain.Student;
import domain.StudentName;
import domain.StudentRegistrationService;
import repositories.StudentRepository;

class RegisterStudentUseCase {

    private final StudentRepository studentRepository;

    RegisterStudentUseCase(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    void registerStudent(StudentName name, String password, StudentRegistrationService service) {
        Student newStudent = Student.create(name, password, service);
        studentRepository.addStudent(newStudent);
    }
}
