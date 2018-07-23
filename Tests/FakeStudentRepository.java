import domain.Student;
import repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class FakeStudentRepository implements StudentRepository {

    private static List<Student> studentList = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentList;
    }

    @Override
    public Student getStudentByID(int ID) {
        return studentList.stream().filter(student -> student.getStudentID() == ID).findAny().orElse(null);
    }

    void clear() {
        studentList.clear();
    }
}
