package oncall.controller;

public class OnCallController {
    private final InputController inputController;

    public OnCallController(InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        String monthAndDay = inputController.getMonthAndDay();
        String weekdayWorker = inputController.getWeekdayWorker();
        String holidayWorker = inputController.getHolidayWorker();
    }
}
