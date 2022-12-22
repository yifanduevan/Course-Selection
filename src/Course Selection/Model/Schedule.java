package Model;

import Controller.Scheduler;

import java.util.*;

public class Schedule{
    private HashSet<Course> courses = Scheduler.getCourses();
    private LinkedList<Course> coursesList = Scheduler.getCoursesList();
    private HashMap<Course, Section> sections = new HashMap<>();
    /**
     * constructor
     */
    public Schedule() {
    }
    public Schedule(Schedule schedule) {
        this.sections = schedule.getSections();
    }
    /**
     * A method that calculates if the time overlaps
     */
    public static boolean isOverlapping(Section section, Section otherSection) {
        for (int i = 0; i < section.getDays().size(); i++) {
            for (int j = 0; j < otherSection.getDays().size(); j++) {
                if (section.getDays().get(i).getDayName().equals(otherSection.getDays().get(j).getDayName())) {
                    int sectionStartTime = section.getDays().get(i).getTime().getStartTimeInInt();
                    int otherSectionStartTime = otherSection.getDays().get(j).getTime().getStartTimeInInt();
                    int sectionEndTime = section.getDays().get(i).getTime().getEndTimeInInt();
                    int otherSectionEndTime = otherSection.getDays().get(j).getTime().getEndTimeInInt();
                    if ((otherSectionStartTime <= sectionEndTime && otherSectionStartTime >= sectionStartTime) ||
                            (sectionEndTime <= otherSectionEndTime && sectionEndTime >= otherSectionStartTime)) {
                        return true;
                    }
                }
            }
        }
    return false;
    }

    /**
     * A method that determines if there is a conflict for all sections in the schedule
     * @param schedule
     * @return true if there is a conflict, false if there is no conflict
     */
    public static boolean isConflict(Schedule schedule) {
        HashMap<Course, Section> sections = schedule.getSections();
        for (Course course : sections.keySet()) {
            for (Course otherCourse : sections.keySet()) {
                if (!course.equals(otherCourse)) {
                    Section section = sections.get(course);
                    Section otherSection = sections.get(otherCourse);
                    if (isOverlapping(section, otherSection)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public void addSection (Section section) {
        if (sections.size() == 0) {
            sections.put(section.getCourse(), section);
        }
        if (!sections.containsKey(section.getCourse())) {
            sections.put(section.getCourse(), section);
        }
    }
    public void removeSection (Section section) {
        sections.remove(section);
    }
    public HashMap<Course, Section> getSections() {
        return sections;
    }
}
