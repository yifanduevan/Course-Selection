import Model.Course;
import Model.Day;
import Model.Section;
import Model.Time;

import java.util.ArrayList;

import static Model.Schedule.isOverlapping;

public class Test {
    public static void main(String[] args) {
        Time time1 = new Time("9:00", "10:00");
        Time time2 = new Time("10:00", "11:00");
        Day day1 = new Day(1);
        Day day2 = new Day(2);


        Time time3 = new Time("9:00", "10:00");
        Time time4 = new Time("9:00", "10:00");
        Day day3 = new Day(2);
        Day day4 = new Day(4);

        Time time5 = new Time("9:00", "10:00");
        Time time6 = new Time("9:00", "10:00");
        Day day5 = new Day(2);
        Day day6 = new Day(3);


        day1.addTime(time1);
        day2.addTime(time2);

        day3.addTime(time3);
        day4.addTime(time4);

        day5.addTime(time5);
        day6.addTime(time6);



        ArrayList<Section> sections = new ArrayList<Section>();
        Course course = new Course("Intro to Java", 123, 3, "Computer Science", sections);
        Section section = new Section("Intro to Java", 123, "Mr. Smith", "Room 123");
        Course course1 = new Course("a", 12, 3, "Computer organization", sections);
        Section section1 = new Section("1", 23, "Mr. Smith", "Room 123");
        Section section2 = new Section("2", 23, "Mr. Smith", "Room 123");
        section.addDay(day1);
        section.addDay(day2);

        section1.addDay(day3);
        section1.addDay(day4);

        section2.addDay(day5);
        section2.addDay(day6);

        course.addSection(section);
        course1.addSection(section1);

        ArrayList<Section> sections1 = new ArrayList<Section>();
        sections1.add(section);
        sections1.add(section1);
        sections1.add(section2);
        for (int i = 0; i<sections1.size(); i++){
            for(int j = i+1; j<sections1.size(); j++){
                System.out.println(isOverlapping(sections1.get(i), sections1.get(j)));
            }
        }
    }
}
