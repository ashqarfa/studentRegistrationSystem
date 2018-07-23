import java.util.List;

public interface StudentRepository {


    List<Student> getStudentsByFirstName(String firstName);

    List<Student> getStudentsByLastName(String lastName);

    Student getStudentById(int Id);

    void addStudent(Student student);
}
