package oncall.domain;

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

    public static Day fromString(String day) {
        for (Day d : Day.values()) {
            if (d.day.equals(day)) {
                return d;
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 요일입니다.");
    }
}