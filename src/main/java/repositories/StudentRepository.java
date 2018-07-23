package repositories;

import domain.Student;

import java.util.List;

public interface StudentRepository {

    void addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentByID(int ID);

}
