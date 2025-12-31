package oncall.view;

import oncall.domain.Day;
import oncall.domain.WorkDay;

public class OutputView {

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printSchedule(WorkDay workDay, String worker) {
        int month = workDay.getMonth();
        int date = workDay.getDate();
        String dayName = workDay.getDay().getDay();
        boolean isWeekday = workDay.getDay() != Day.SATURDAY && workDay.getDay() != Day.SUNDAY;

        String holidayTag = "";
        if (workDay.isLegalHoliday() && isWeekday) {
            holidayTag = "(휴일)";
        }

        System.out.printf("%d월 %d일 %s%s %s%n", month, date, dayName, holidayTag, worker);
    }
}
