package oncall.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WorkDayTest {

    @Test
    @DisplayName("평일")
    void 평일() {
        //given&when
        WorkDay workDay = new WorkDay(5, 2, Day.TUESDAY);

        //then
        assertThat(workDay.isHoliday()).isFalse();
        assertThat(workDay.isLegalHoliday()).isFalse();
    }

    @Test
    @DisplayName("토요일 휴일")
    void 토요일_휴일() {
        //given&when
        WorkDay workDay = new WorkDay(5, 6, Day.SATURDAY);

        //then
        assertThat(workDay.isHoliday()).isTrue();
        assertThat(workDay.isLegalHoliday()).isFalse();
    }

    @Test
    @DisplayName("일요일 휴일")
    void 일요일_휴일() {
        //given&when
        WorkDay workDay = new WorkDay(5, 7, Day.SUNDAY);

        //then
        assertThat(workDay.isHoliday()).isTrue();
        assertThat(workDay.isLegalHoliday()).isFalse();
    }

    @Test
    @DisplayName("평일 법정공휴일은 휴일")
    void 평일_법정공휴일은_휴일() {
        //given&when
        WorkDay workDay = new WorkDay(5, 5, Day.FRIDAY);

        //then
        assertThat(workDay.isHoliday()).isTrue();
        assertThat(workDay.isLegalHoliday()).isTrue();
    }

    @Test
    @DisplayName("주말 법정공휴일은 휴일")
    void 주말_법정공휴일은_휴일() {
        //given&when
        WorkDay workDay = new WorkDay(1, 1, Day.SATURDAY);

        //then
        assertThat(workDay.isHoliday()).isTrue();
        assertThat(workDay.isLegalHoliday()).isTrue();
    }
}
