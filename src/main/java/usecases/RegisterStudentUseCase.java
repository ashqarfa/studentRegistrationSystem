package usecases;

import domain.Student;
import domain.StudentName;
import repositories.StudentRepository;

class RegisterStudentUseCase {

    private final StudentRepository studentRepository;

    RegisterStudentUseCase(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    void registerStudent(StudentName firstName, StudentName lastName, String password) {

        Student newStudent = Student.createStudentIfValid(firstName, lastName, password, studentRepository.getAllStudents());
        studentRepository.addStudent(newStudent);

    }
}
