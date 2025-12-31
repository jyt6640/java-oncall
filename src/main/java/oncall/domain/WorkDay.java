package oncall.domain;

public class WorkDay {
    private final int month;
    private final int date;
    private final Day day;
    private final boolean isHoliday;
    private final boolean isLegalHoliday;

    public WorkDay(int month, int date, Day day) {
        this.month = month;
        this.date = date;
        this.day = day;
        this.isHoliday = calculateHoliday(day, month, date);
        this.isLegalHoliday = isLegalHoliday(month, date);
    }

    private boolean calculateHoliday(Day day, int month, int date) {
        if (day == Day.SATURDAY || day == Day.SUNDAY) {
            return true;
        }
        return false;
    }

    private boolean isLegalHoliday(int month, int date) {
        return (month == 1 && date == 1) ||
                (month == 3 && date == 1) ||
                (month == 5 && date == 5) ||
                (month == 6 && date == 6) ||
                (month == 8 && date == 15) ||
                (month == 10 && date == 3) ||
                (month == 10 && date == 9) ||
                (month == 12 && date == 25);
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public Day getDay() {
        return day;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    public boolean isLegalHoliday() {
        return isLegalHoliday;
    }
}