package Model;

public class Time {
    /**
     * The constructor accepts the start time and end time of a section
     */
    private String startTime;
    private String endTime;
    private int startTimeInInt;
    private int endTimeInInt;

    public Time(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.startTimeInInt = convertTimeToInt(startTime);
        this.endTimeInInt = convertTimeToInt(endTime);
    }
    public String getStartTime() {
        return startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public int getStartTimeInInt() {
        return startTimeInInt;
    }
    public int getEndTimeInInt() {
        return endTimeInInt;
    }
    public static int convertTimeToInt(String time) {
        String[] timeArray = time.split(":");
        int hour = Integer.parseInt(timeArray[0]);
        int minute = Integer.parseInt(timeArray[1]);
        int timeInInt = hour * 60 + minute;
        return timeInInt;
    }

}
