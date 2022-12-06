package Model;

import java.util.ArrayList;

public class Day {
    /**
     * Rerivieving days of the week by their names
     */
    private int day;
    private String dayName;

    private ArrayList<Time> times = new ArrayList<Time>();

    public Day(int day) {
        this.day = day;
        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            default:
                dayName = "Invalid day";
                break;
        }
    }
    public String getDayName() {
        return dayName;
    }
    public String getTimeInString(){
        String time = "";
        for (int i = 0; i < times.size(); i++) {
            time += times.get(i).getStartTime() + "-" + times.get(i).getEndTime() + " ";
        }
        return time;
    }
    public Time getTime(){
        return times.get(0);
    }
    public void addTime(Time time) {
        times.add(time);
    }
    public String toString() {
        return dayName;
    }
}