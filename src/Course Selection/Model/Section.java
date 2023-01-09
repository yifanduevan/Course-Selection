package Model;

import java.util.ArrayList;

public class Section {
    /**
     * The constructor initialize the section with the given name and section number
     */
    private String name;
    private int sectionNumber;
    private String instructor;
    private String location;
    private ArrayList<Day> days = new ArrayList<Day>();
    private Course course = new Course();


    public Section(int sectionNumber, String instructor, String location) {
        this.sectionNumber = sectionNumber;
        this.instructor = instructor;
        this.location = location;
    }
    public Section(){
        this.name = "";
        this.sectionNumber = 0;
        this.instructor = "";
        this.location = "";
        this.days = new ArrayList<Day>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Day> getDays() {
        return days;
    }

    public boolean addDay(Day day) {
        for (int i = 0; i < days.size(); i++) {
            if (days.get(i).getDayName().equals(day.getDayName())) {
                return false;
            }
        }
        days.add(day);
        return true;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setCourse(Course course){
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public String toString() {
        String time = "";
        for (int i = 0; i < days.size(); i++) {
            time += days.get(i).getDayName();
            time += ":";
            time += days.get(i).getTimeInString();
        }

        return "\nName:" + course.getName() + "\n" +
                "Section:" + sectionNumber + "\n" +
                "Instructor:" + instructor + "\n" +
                "Location:" + location + "\n" +
                "Days:" + days + "\n" +
                "Time:" + time + "\n";
    }

}
