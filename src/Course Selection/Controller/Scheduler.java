package Controller;
import Model.*;
import java.util.*;
import static Model.Schedule.isConflict;

public class Scheduler {
    private static HashSet<Course> courses = new HashSet<>();
    private static LinkedList<Course> coursesList = new LinkedList<>();
    private static List<Schedule> result = new ArrayList<>();
    public Scheduler() {

    }
    public static HashSet<Course> getCourses() {
        return courses;
    }
    public static LinkedList<Course> getCoursesList() {
        return coursesList;
    }
    public void addCourse(Course course) {
        courses.add(course);
        coursesList.add(course);
    }

    /**
     * this method is to create schedules, and return the arraylist of schedules
     * The input is a list of courses
     * each course has a list of sections
     * the method will create a schedule that contains one section from each course
     * the schedule should not have overlapping sections
     *
     * @return schedules
     */
    public static void getAllSchedules(List<Course> courses, int index,
                                                 List<Section> current, List<List<Section>> result) {
        if (index == courses.size()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (Section section : courses.get(index).getSections()) {
            current.add(section);
            getAllSchedules(courses, index + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

//    public static List<Schedule> getValidSchedules(List<Course> courses) {
//        List<Schedule> schedules = getAllSchedules(courses);
//        List<Schedule> validSchedules = new ArrayList<>();
//        for (Schedule schedule : schedules) {
//            if (isConflict(schedule)) {
//                validSchedules.add(schedule);
//            }
//        }
//        return validSchedules;
//    }
}

