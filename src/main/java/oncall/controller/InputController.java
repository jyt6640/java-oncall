package oncall.controller;

import oncall.view.InputView;

public class InputController {

    private final InputView inputView;

    public InputController(InputView inputView) {
        this.inputView = inputView;
    }

    public String getWeekdayWorker() {
        while (true) {
            return weekdayWorker();
        }
    }

    public String getHolidayWorker() {
        while (true) {
            return holidayWorker();
        }
    }

    public String getMonthAndDay() {
        while (true) {
            return monthAndDay();
        }
    }

    private String monthAndDay() {
        return inputView.readMonthAndDay();
    }

    private String weekdayWorker() {
        return inputView.readWeekdayWorker();
    }

    private String holidayWorker() {
        return inputView.readHolidayWorker();
    }

}
