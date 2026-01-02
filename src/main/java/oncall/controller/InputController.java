package oncall.controller;

import java.util.Arrays;
import java.util.List;
import oncall.view.InputView;
import oncall.view.OutputView;

public class InputController {

    private static final String MONTH_AND_DAY_REGEX = "^[0-9]+,[ㄱ-ㅎ가-힣]+$";
    private static final List<String> VALID_DAYS = Arrays.asList("일", "월", "화", "수", "목", "금", "토");

    private final InputView inputView;
    private final OutputView outputView;

    public InputController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String getMonthAndDay() {
        while (true) {
            try {
                return readMonthAndDay();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    public String getWeekDayWorker() {
        while (true) {
            try {
                return readWeekDayWorker();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    public String getHoliDayWorker() {
        while (true) {
            try {
                return readHolidayWorker();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private String readMonthAndDay() {
        String input = inputView.readMonthAndDay();
        validateMonthAndDay(input);
        return input;
    }

    private String readWeekDayWorker() {
        return inputView.readWeekdayWorker();
    }

    private String readHolidayWorker() {
        return inputView.readHolidayWorker();
    }

    private void validateMonthAndDay(String input) {
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

}
