package Controller;
import Model.*;
import java.util.*;
import static Model.Schedule.isConflict;

public class Scheduler {
    private static HashSet<Course> courses = new HashSet<>();
    private static LinkedList<Course> coursesList = new LinkedList<>();
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
    public List<Schedule> getAllSchedules(List<Course> courses) {
        // 创建一个保存所有Schedule对象的ArrayList
        List<Schedule> schedules = new ArrayList<>();

        // 遍历所有Course
        for (Course course : courses) {
            // 获取Course中所有的Section
            List<Section> sections = course.getSections();

            // 如果schedules为空，将所有Section都添加到schedules中
            if (schedules.isEmpty()) {
                for (Section section : sections) {
                    Schedule schedule = new Schedule();
                    schedule.addSection(section);
                    schedules.add(schedule);
                }
            } else {
                // 如果schedules不为空，将所有Section与schedules中的每一个Schedule进行排列组合
                List<Schedule> newSchedules = new ArrayList<>();
                for (Schedule schedule : schedules) {
                    for (Section section : sections) {
                        Schedule newSchedule = new Schedule(schedule);
                        newSchedule.addSection(section);
                        newSchedules.add(newSchedule);
                    }
                }
                schedules = newSchedules;
            }
        }
 
        // 返回所有可能的Schedule
        return schedules;
    }
    public List<Schedule> getValidSchedules(List<Course> courses) {
        List<Schedule> schedules = getAllSchedules(courses);
        List<Schedule> validSchedules = new ArrayList<>();
        for (Schedule schedule : schedules) {
            if (isConflict(schedule)) {
                validSchedules.add(schedule);
            }
        }
        return validSchedules;
    }
}

