public interface CourseRepository {

    void addCourse(Course course);

    void removeCourse(String courseCode);

    Course findCourseByCourseCode(String courseCode);
}
