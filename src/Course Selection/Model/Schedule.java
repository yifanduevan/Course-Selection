package Model;

import Controller.Scheduler;

import java.util.*;

public class Schedule{
    private HashSet<Course> courses = Scheduler.getCourses();
    private LinkedList<Course> coursesList = Scheduler.getCoursesList();
    private ArrayList<Section> sections = new ArrayList<>();
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
        ArrayList<Section> sections = schedule.getSections();
        for (Section section : sections) {
            for (Section otherSection : sections) {
                if (!section.getCourse().equals(otherSection.getCourse())) {
                    if (isOverlapping(section, otherSection)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public void addSection (Section section) {
        sections.add(section);
    }
    public void removeSection (Section section) {
        sections.remove(section);
    }
    public ArrayList<Section> getSections() {
        return sections;
    }
    public void toStringSchedule() {
        for (Section section : sections) {
            System.out.println(section.getCourse().getName() + " " + section.getSectionNumber());
        }
    }
}
