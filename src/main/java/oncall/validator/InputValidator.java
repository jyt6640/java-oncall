package oncall.validator;

public class InputValidator {

    private static final String MONTH_AND_DAY_REGEX = "^[0-9]+,[ㄱ-ㅎ가-힣]+$";
    private static final String WORKER_REGEX = "^[ㄱ-ㅎ가-힣A-Za-z]+(,[ㄱ-ㅎ가-힣A-Za-z]+)*$";


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
    }

    private void workerInput(String input) {
        if (!input.matches(WORKER_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }
}
