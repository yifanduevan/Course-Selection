package Model;

import java.util.ArrayList;
import java.util.List;

public class ScheduleSet {
    private static ArrayList<Schedule> schedules = new ArrayList<>();
    private static ArrayList<Schedule> validSchedules = new ArrayList<>();
    public ScheduleSet(){
    }
    public static void loadSchedules(List<List<Section>> result){
        for (List<Section> sections : result) {
            Schedule schedule = new Schedule();
            for (Section section : sections) {
                schedule.addSection(section);
            }
            schedules.add(schedule);
        }
    }
    public static void storeValidSchedules(){
        for (Schedule schedule : schedules) {
            if (!Schedule.isConflict(schedule)) {
                validSchedules.add(schedule);
            }
        }
    }
    public static ArrayList<Schedule> getValidSchedules() {
        return validSchedules;
    }


}
