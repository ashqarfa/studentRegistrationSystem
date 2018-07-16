
import java.util.HashMap;
import java.util.Map;

public class Course {
    String name;
    String code;
    HashMap<String, String> map = new HashMap<>();
    status status;

    public Course(String courseCode) {
        this.code = courseCode;
        this.name = map.get(courseCode);
        this.status = status.inProgress;
    }

    enum status {failed, passed, inProgress};

    void addCourse(String code, String name) {
        map.put(code, name);
    }
}


