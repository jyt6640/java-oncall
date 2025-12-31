package oncall.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import oncall.domain.WorkDay;
import oncall.domain.WorkDays;
import oncall.service.OnCallService;
import oncall.view.OutputView;

public class OnCallController {

    private final InputController inputController;
    private final OutputView outputView;
    private final OnCallService onCallService;

    public OnCallController(InputController inputController, OutputView outputView, OnCallService onCallService) {
        this.inputController = inputController;
        this.outputView = outputView;
        this.onCallService = onCallService;
    }

    public void run() {
        String monthAndDay = inputController.getMonthAndDay();
        String weekdayWorkerString = inputController.getWeekdayWorker();
        String holidayWorkerString = inputController.getHolidayWorker();

        String[] monthAndDayParts = monthAndDay.split(",");
        int month = Integer.parseInt(monthAndDayParts[0]);
        String startDayName = monthAndDayParts[1];

        List<String> weekdayWorkers = Arrays.asList(weekdayWorkerString.split(","));
        List<String> holidayWorkers = Arrays.asList(holidayWorkerString.split(","));

        WorkDays workDays = new WorkDays(month, startDayName);

        Map<WorkDay, String> schedule = onCallService.generateSchedule(workDays, weekdayWorkers, holidayWorkers);
        printSchedule(schedule);
    }

    private void printSchedule(Map<WorkDay, String> schedule) {
        for (Map.Entry<WorkDay, String> entry : schedule.entrySet()) {
            outputView.printSchedule(entry.getKey(), entry.getValue());
        }
    }
}
