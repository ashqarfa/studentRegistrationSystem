public interface CourseRepository {

    void addCourse(String courseCode, String courseName);

    void deleteCourse(String courseCode);

    String getCourseNameIfFound(String courseCode);

}
