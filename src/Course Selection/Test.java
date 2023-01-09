import Model.*;
import java.util.ArrayList;
import java.util.List;

import static Controller.Scheduler.getAllSchedules;

public class Test {
    public static void main(String[] args) {
        List<List<Section>> result = new ArrayList<>();
        //English
        Time time1 = new Time("12:15", "14:15");
        Time time2 = new Time("08:15", "10:15");
        Day day1 = new Day(1);
        Day day2 = new Day(4);
        day1.addTime(time1);
        day2.addTime(time2);
        Section E7 = new Section( 7, "Hans", "TBA");
        E7.addDay(day1);
        E7.addDay(day2);
        Time time3 = new Time("10:15", "12:15");
        Day day3 = new Day(2);
        Day day4 = new Day(5);
        day3.addTime(time3);
        day4.addTime(time3);
        Section E8 = new Section( 8, "Hans", "TBA");
        E8.addDay(day3);
        E8.addDay(day4);
        Course course1 = new Course("English", "ENG", 3, "English");
        course1.addSection(E7);
        course1.addSection(E8);

        //French
        Time time4 = new Time("14:15", "15:45");
        Time time5 = new Time("11:15", "12:45");
        Day day5 = new Day(1);
        Day day6 = new Day(4);
        day5.addTime(time4);
        day6.addTime(time5);
        Section F1 = new Section( 1, "Hans", "TBA");
        F1.addDay(day5);
        F1.addDay(day6);
        Time time6 = new Time("09:45", "11:15");
        Day day7 = new Day(2);
        Day day8 = new Day(5);
        day7.addTime(time6);
        day8.addTime(time6);
        Section F2 = new Section( 2, "Hans", "TBA");
        F2.addDay(day7);
        F2.addDay(day8);
        Course course2 = new Course("French", "FRE", 3, "French");
        course2.addSection(F1);
        course2.addSection(F2);

        //PE
        Time time7 = new Time("14:15", "16:15");
        Time time8 = new Time("16:15", "18:15");
        Time time9 = new Time("16:15", "18:15");
        Time time10 = new Time("14:45", "16:15");
        Day day9 = new Day(2);
        Day day10 = new Day(3);
        Day day11 = new Day(1);
        Day day12 = new Day(1);
        day9.addTime(time7);
        day10.addTime(time8);
        day11.addTime(time9);
        day12.addTime(time10);
        Section P3 = new Section( 3, "Hans", "TBA");
        P3.addDay(day9);
        Section P4 = new Section( 4, "Hans", "TBA");
        P4.addDay(day10);
        Section P5 = new Section( 5, "Hans", "TBA");
        P5.addDay(day11);
        Section P6 = new Section( 6, "Hans", "TBA");
        P6.addDay(day12);

        Course course3 = new Course("PE", "PE", 3, "PE");
        course3.addSection(P3);
        course3.addSection(P4);
        course3.addSection(P5);
        course3.addSection(P6);


        //Humanity
        Time time11 = new Time("16:15", "18:15");
        Day day13 = new Day(1);
        Day day14 = new Day(3);
        day13.addTime(time11);
        day14.addTime(time11);
        Section H1 = new Section( 1, "Hans", "TBA");
        H1.addDay(day13);
        H1.addDay(day14);

        Time time13 = new Time("08:15", "10:15");
        Day day15 = new Day(1);
        Day day16 = new Day(3);
        day15.addTime(time13);
        day16.addTime(time13);
        Section H2 = new Section( 2, "Hans", "TBA");
        H2.addDay(day15);
        H2.addDay(day16);

        Time time14 = new Time("12:15", "14:15");
        Time time15 = new Time("08:15", "10:15");
        Day day17 = new Day(1);
        Day day18 = new Day(4);
        day17.addTime(time14);
        day18.addTime(time15);
        Section H8 = new Section( 8, "Hans", "TBA");
        H8.addDay(day17);
        H8.addDay(day18);

        Time time16 = new Time("14:15", "16:15");
        Time time17 = new Time("10:15", "12:15");
        Day day19 = new Day(1);
        Day day20 = new Day(4);
        day19.addTime(time16);
        day20.addTime(time17);
        Section H9 = new Section( 9, "Hans", "TBA");
        H9.addDay(day19);
        H9.addDay(day20);

        Course course4 = new Course("Humanity", "HUM", 3, "Humanity");
        course4.addSection(H1);
        course4.addSection(H2);
        course4.addSection(H8);
        course4.addSection(H9);

        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);

        getAllSchedules(courses, 0, new ArrayList<>(), result);
        ScheduleSet.loadSchedules(result);
        ScheduleSet.storeValidSchedules();

        ArrayList<Schedule> validSchedules = ScheduleSet.getValidSchedules();
        for (Schedule schedule : validSchedules) {
            schedule.toStringSchedule();
        }
    }
}
