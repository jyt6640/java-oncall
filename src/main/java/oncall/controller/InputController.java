package oncall.controller;

import oncall.validator.InputValidator;
import oncall.view.InputView;
import oncall.view.OutputView;

public class InputController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;

    public InputController(InputView inputView, OutputView outputView, InputValidator inputValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
    }

    public String getWeekdayWorker() {
        while (true) {
            try {
                return weekdayWorker();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    public String getHolidayWorker() {
        while (true) {
            try {
                return holidayWorker();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    public String getMonthAndDay() {
        while (true) {
            try {
                return monthAndDay();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private String monthAndDay() {
        String input = inputView.readMonthAndDay();
        inputValidator.validateMonthAndDay(input);
        return input;
    }

    private String weekdayWorker() {
        String input = inputView.readWeekdayWorker();
        inputValidator.validateWeekday(input);
        return input;
    }

    private String holidayWorker() {
        String input = inputView.readHolidayWorker();
        inputValidator.validateHoliday(input);
        return input;
    }

}
