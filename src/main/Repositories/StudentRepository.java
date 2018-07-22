import java.util.List;

public interface StudentRepository {

    void addStudent(Student student);

    List<Student> getAllStudents();
}
