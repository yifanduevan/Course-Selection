package Model;

import java.util.ArrayList;
public class Course {
    /**
     * The constructor accepts the course name, course number, the number of credits, course category, and the course description
     */
    private String name;
    private int courseNumber;
    private int credits;
    private String category;
    private ArrayList<Section> sections;
    public Course(String name, int courseNumber, int credits, String category, ArrayList<Section> sections) {
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
        this.sections = new ArrayList<Section>();
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
    public ArrayList<Section> getSections() {
        return sections;
    }
    public String toString() {
        return "Course Number:" + courseNumber + "\n" +
                "Course Name:"+ name + "\n" +
                "Credit:" + credits +"\n" +
                "Category:" + category  + "\n" +
                "Sections:" + sections + "\n";
    }
    public void addSection(Section section) {
        sections.add(section);
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
