package oncall.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import oncall.domain.WorkDay;
import oncall.domain.WorkDays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OnCallServiceTest {

    private OnCallService onCallService;

    @BeforeEach
    void setUp() {
        onCallService = new OnCallService();
    }

    @Test
    @DisplayName("기본적인 근무표 생성")
    void 기본적인_근무표_생성() {
        // given
        WorkDays workDays = new WorkDays(5, "월");
        List<String> weekdayWorkers = Arrays.asList("A", "B", "C", "D", "E");
        List<String> holidayWorkers = Arrays.asList("H1", "H2");

        // when
        Map<WorkDay, String> schedule = onCallService.generateSchedule(workDays, weekdayWorkers, holidayWorkers);

        // then
        assertThat(schedule.get(workDays.getWorkDays().get(0))).isEqualTo("A");
        assertThat(schedule.get(workDays.getWorkDays().get(1))).isEqualTo("B");
        assertThat(schedule.get(workDays.getWorkDays().get(4))).isEqualTo("H1");
        assertThat(schedule.get(workDays.getWorkDays().get(5))).isEqualTo("H2");
    }

    @Test
    @DisplayName("평일 -> 휴일 연속 근무자 중복 시 스왑")
    void 평일_휴일_연속_근무자_중복_시_스왑() {
        // given
        WorkDays workDays = new WorkDays(5, "월");
        List<String> weekdayWorkers = Arrays.asList("A", "B", "C", "H1", "E");
        List<String> holidayWorkers = Arrays.asList("H1", "H2");

        // when
        Map<WorkDay, String> schedule = onCallService.generateSchedule(workDays, weekdayWorkers, holidayWorkers);

        // then
        assertThat(schedule.get(workDays.getWorkDays().get(3))).isEqualTo("H1");
        assertThat(schedule.get(workDays.getWorkDays().get(4))).isEqualTo("H2");
        assertThat(schedule.get(workDays.getWorkDays().get(5))).isEqualTo("H1");
    }

    @Test
    @DisplayName("휴일 -> 평일 연속 근무자 중복 시 스왑")
    void 휴일_평일_연속_근무자_중복_시_스왑() {
        // given
        WorkDays workDays = new WorkDays(5, "월");
        List<String> weekdayWorkers = Arrays.asList("A", "B");
        List<String> holidayWorkers = Arrays.asList("H1", "H2", "A");

        // when
        Map<WorkDay, String> schedule = onCallService.generateSchedule(workDays, weekdayWorkers, holidayWorkers);

        // then
        assertThat(schedule.get(workDays.getWorkDays().get(6))).isEqualTo("A");
        assertThat(schedule.get(workDays.getWorkDays().get(7))).isEqualTo("B");
        assertThat(schedule.get(workDays.getWorkDays().get(8))).isEqualTo("A");
    }
}
