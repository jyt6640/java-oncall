package oncall.controller;

import oncall.view.InputView;
import oncall.view.OutputView;

public class InputController {

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
        return inputView.readMonthAndDay();
    }

    private String readWeekDayWorker() {
        return inputView.readWeekdayWorker();
    }

    private String readHolidayWorker() {
        return inputView.readHolidayWorker();
    }

}
