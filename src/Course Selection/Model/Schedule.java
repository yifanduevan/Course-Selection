package Model;

public class Schedule {

    /**
     * constructor
     */
    public Schedule() {
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
}
