package oncall.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WorkDaysTest {

    @Test
    @DisplayName("5월 리스트 생성")
    void generateMay() {
        //given
        WorkDays workDays = new WorkDays(5, "월");

        //when
        List<WorkDay> days = workDays.getWorkDays();

        //then
        assertThat(days).hasSize(31);
        assertThat(days.get(0).getMonth()).isEqualTo(5);
        assertThat(days.get(0).getDate()).isEqualTo(1);
        assertThat(days.get(0).getDay()).isEqualTo(Day.MONDAY);

        assertThat(days.get(30).getDate()).isEqualTo(31);
        assertThat(days.get(30).getDay()).isEqualTo(Day.WEDNESDAY);
    }

    @Test
    @DisplayName("4월 리스트 생성")
    void generateApril() {
        //given
        WorkDays workDays = new WorkDays(4, "토");

        //when
        List<WorkDay> days = workDays.getWorkDays();

        //then
        assertThat(days).hasSize(30);
        assertThat(days.get(0).getMonth()).isEqualTo(4);
        assertThat(days.get(0).getDate()).isEqualTo(1);
        assertThat(days.get(0).getDay()).isEqualTo(Day.SATURDAY);

        assertThat(days.get(29).getDate()).isEqualTo(30);
        assertThat(days.get(29).getDay()).isEqualTo(Day.SUNDAY);
    }

    @Test
    @DisplayName("2월 리스트 생성")
    void generateFebruary() {
        //given
        WorkDays workDays = new WorkDays(2, "수");

        //when
        List<WorkDay> days = workDays.getWorkDays();

        //then
        assertThat(days).hasSize(28);
        assertThat(days.get(0).getMonth()).isEqualTo(2);
        assertThat(days.get(0).getDate()).isEqualTo(1);
        assertThat(days.get(0).getDay()).isEqualTo(Day.WEDNESDAY);

        assertThat(days.get(27).getDate()).isEqualTo(28);
        assertThat(days.get(27).getDay()).isEqualTo(Day.TUESDAY);
    }
}
