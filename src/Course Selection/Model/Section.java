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
    private Time time;
    private String day;
    private ArrayList<Day> days = new ArrayList<Day>();

    public Section(String name, int sectionNumber, String instructor, String location) {
        this.name = name;
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

    public void addDay(Day day) {
        days.add(day);
    }

    public String toString() {
        String time = "";
        for (int i = 0; i < days.size(); i++) {
            time += days.get(i).getDayName();
            time += ":";
            time += days.get(i).getTimeInString();
        }

        return "Section:" + sectionNumber + "\n" +
                "Name:" + name + "\n" +
                "Instructor:" + instructor + "\n" +
                "Location:" + location + "\n" +
                "Days:" + days + "\n" +
                "Time:" + time + "\n";
    }

    /**
     * This method converts time in hour minute format to only minutes
     */
    public static int convertTimeToMinutes(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));
        return hour * 60 + minute;
    }

}
