package oncall.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DayTest {

    @DisplayName("문자열로 요일을 올바르게 가져오는 기능")
    @ParameterizedTest
    @CsvSource({"월,MONDAY", "화,TUESDAY", "수,WEDNESDAY", "목,THURSDAY", "금,FRIDAY", "토,SATURDAY", "일,SUNDAY"})
    void 문자열로_요일을_올바르게_가져오는_기능(String input, Day expected) {
        //when&than
        assertThat(Day.fromString(input)).isEqualTo(expected);
    }

    @DisplayName("다음 요일을 올바르게 가져오는 기능")
    @Test
    void 다음_요일을_올바르게_가져오는_기능() {
        //when&than
        assertThat(Day.MONDAY.getNextDay()).isEqualTo(Day.TUESDAY);
        assertThat(Day.TUESDAY.getNextDay()).isEqualTo(Day.WEDNESDAY);
        assertThat(Day.WEDNESDAY.getNextDay()).isEqualTo(Day.THURSDAY);
        assertThat(Day.THURSDAY.getNextDay()).isEqualTo(Day.FRIDAY);
        assertThat(Day.FRIDAY.getNextDay()).isEqualTo(Day.SATURDAY);
        assertThat(Day.SATURDAY.getNextDay()).isEqualTo(Day.SUNDAY);
        assertThat(Day.SUNDAY.getNextDay()).isEqualTo(Day.MONDAY);
    }

    @DisplayName("잘못된 문자열로 요일을 가져오면 예외 발생")
    @Test
    void 잘못된_문자열로_요일을_가져오면_예외_발생() {
        //when&than
        assertThatThrownBy(() -> Day.fromString("ivalid"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
