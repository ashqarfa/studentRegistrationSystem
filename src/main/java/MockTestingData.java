import java.util.ArrayList;
import java.util.List;

public class MockTestingData implements RegistrationInterface {

    @Override
    public List<Student> getStudents() {

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Farah", "Ashqar", 1));
        studentList.add(new Student("Farah", "Ashqar", 2));
        studentList.add(new Student("Farah", "Ashqar", 3));
        studentList.add(new Student("Jozef", "Bernat", 4));
        studentList.add(new Student("Jozef", "Bernat", 5));
        studentList.add(new Student("Will", "Smith", 6));

        return studentList;
    }
}
