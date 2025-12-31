package oncall.validator;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    private static final String MONTH_AND_DAY_REGEX = "^[0-9]+,[ㄱ-ㅎ가-힣]+$";
    private static final String WORKER_REGEX = "^[ㄱ-ㅎ가-힣A-Za-z]+(,[ㄱ-ㅎ가-힣A-Za-z]+)*$";
    private static final List<String> VALID_DAYS = Arrays.asList("일", "월", "화", "수", "목", "금", "토");


    public void validateMonthAndDay(String input) {
        empty(input);
        monthAndDayInput(input);
    }

    public void validateWeekday(String input) {
        empty(input);
        workerInput(input);
    }

    public void validateHoliday(String input) {
        empty(input);
        workerInput(input);
    }

    private void empty(String input) {
        if(input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 공백일 수 없습니다. 다시 입력해 주세요.");
        }
    }

    private void monthAndDayInput(String input) {
        if (!input.matches(MONTH_AND_DAY_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
        String[] parts = input.split(",");
        int month = Integer.parseInt(parts[0]);
        String day = parts[1];
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
        if (!VALID_DAYS.contains(day)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    private void workerInput(String input) {
        if (!input.matches(WORKER_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }
}
