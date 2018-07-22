public interface CourseRepository {

    void addCourse(String courseCode, String courseName);

    void removeCourse(String courseCode);

    String getCourseNameIfFound(String courseCode);

}
