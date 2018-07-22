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
}
