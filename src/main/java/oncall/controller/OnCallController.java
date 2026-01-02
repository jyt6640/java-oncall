package oncall.controller;

import oncall.view.OutputView;

public class OnCallController {

    private final InputController inputController;
    private final OutputView outputView;

    public OnCallController(InputController inputController, OutputView outputView) {
        this.inputController = inputController;
        this.outputView = outputView;
    }

    public void run() {
        String monthAndDay = inputController.getMonthAndDay();
        String weekDayWorker = inputController.getWeekDayWorker();
        String holiDayWorker = inputController.getHoliDayWorker();
    }
}
