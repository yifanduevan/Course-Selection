package Model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Course {
    /**
     * The constructor accepts the course name, course number, the number of credits, course category, and the course description
     */
    private String name;
    private int courseNumber;
    private int credits;
    private String category;
    private LinkedList<Section> sections;
    public Course(String name, int courseNumber, int credits, String category, LinkedList<Section> sections) {
        this.name = name;
        this.courseNumber = courseNumber;
        this.credits = credits;
        this.category = category;
        this.sections = sections;
    }
    public Course(){
        this.name = "";
        this.courseNumber = 0;
        this.credits = 0;
        this.category = "";
        this.sections = new LinkedList<>();
    }
    public String getName() {
        return name;
    }
    public int getCourseNumber() {
        return courseNumber;
    }
    public int getCredits() {
        return credits;
    }
    public String getCategory() {
        return category;
    }
    public LinkedList<Section> getSections() {
        return sections;
    }
    public String toString() {
        return "Course Number:" + courseNumber + "\n" +
                "Course Name:"+ name + "\n" +
                "Credit:" + credits +"\n" +
                "Category:" + category  + "\n" +
                "Sections:" + sections + "\n";
    }
    public boolean addSection(Section section) {
        for (int i = 0; i < sections.size(); i++) {
            if (sections.get(i).getSectionNumber() == section.getSectionNumber()) {
                return false;
            }
        }
        sections.add(section);
        section.setCourse(this);
        return true;
    }
    public void removeSection(Section section) {
        sections.remove(section);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
