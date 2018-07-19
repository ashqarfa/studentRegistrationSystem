import java.util.ArrayList;
import java.util.List;

public class MockRegistration implements RegistrationInterface {


    @Override
    public List<Student> getStudents() {

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Farah", "Ashqar", 1));
        studentList.add(new Student("Jozef", "Bernat", 2));
        studentList.add(new Student("William", "Turner", 3));


        return studentList;
    }
}
