package oncall.domain;

import java.util.ArrayList;
import java.util.List;

public class WorkDays {

    private final List<WorkDay> workDays;

    public WorkDays(int month, String startDayName) {
        this.workDays = new ArrayList<>();
        Day currentDay = Day.fromString(startDayName);
        int daysInMonth = getDaysInMonth(month);

        for (int date = 1; date <= daysInMonth ; date++) {
            workDays.add(new WorkDay(month, date, currentDay));
            currentDay = currentDay.getNextDay();
        }
    }

    private int getDaysInMonth(int month) {
        return switch (month) {
            case 1,3,4,5,6,7,8,9,10,11,12 -> 31;
            case 2 -> 28;
            default -> throw new IllegalArgumentException("[ERROR] 유효하지 않은 달입니다.");
        };
    }
}
