package oncall.domain;

import java.util.ArrayList;
import java.util.List;

public class WorkDays {

    private List<WorkDay> workDays;

    public WorkDays(int month, String startDay) {
        this.workDays = new ArrayList<>();
        Day currentDay = Day.fromString(startDay);
        int daysInMonth = getDaysInMonth(month);

        for (int date = 1; date <= daysInMonth; date++) {
            workDays.add(new WorkDay(month, date, currentDay));
            currentDay = currentDay.getNextDay();
        }
    }

    private int getDaysInMonth(int month) {
        if (month == 2) {
            return 28;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 달입니다.");
    }

    public List<WorkDay> getWorkDays() {
        return workDays;
    }
}
