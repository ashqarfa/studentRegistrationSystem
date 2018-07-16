import java.util.Map;

public class Course {

    CourseEnums.courseCode courseCode;
    CourseEnums.courseName courseName;
    CourseEnums.status status;

    static int numberOfStudentsInCourse;

    public Course(CourseEnums.courseCode courseCode) {
        this.courseCode = courseCode;

        this.status = CourseEnums.status.inProgress;
    }

    static class CourseEnums {
        enum courseCode{MAT1, PHY1, HIS1, GOE1};
        enum courseName{Math, Physics, History, Geography};
        enum status{failed, passed, inProgress};
      //  Map<CourseEnums.courseCode, CourseEnums.courseName> = new
    }
}

