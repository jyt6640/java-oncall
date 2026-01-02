package oncall.domain;

import java.util.Arrays;

public enum Day {
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일");

    private final String day;

    Day(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public Day getNextDay() {
        Day[] days = Day.values();
        int nextIndex = (this.ordinal() + 1) % days.length;
        return days[nextIndex];
    }

    public static Day fromString(String currentDay) {
        return Arrays.stream(values())
                .filter(day -> day.day.equals(currentDay))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("요일을 잘못 입력하였습니다."));
    }
}
