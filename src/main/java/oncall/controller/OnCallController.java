package oncall.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import oncall.domain.WorkDay;
import oncall.domain.WorkDays;
import oncall.service.GenerateScheduleService;
import oncall.view.OutputView;

public class OnCallController {

    private final InputController inputController;
    private final OutputView outputView;
    private final GenerateScheduleService generateScheduleService;

    public OnCallController(InputController inputController, OutputView outputView,
                            GenerateScheduleService generateScheduleService) {
        this.inputController = inputController;
        this.outputView = outputView;
        this.generateScheduleService = generateScheduleService;
    }

    public void run() {
        String[] monthAndDay = (inputController.getMonthAndDay()).split(",");
        String weekDayWorker = inputController.getWeekDayWorker();
        String holiDayWorker = inputController.getHoliDayWorker();

        int month = Integer.parseInt(monthAndDay[0]);
        String startDay = monthAndDay[1];

        List<String> weekDayWorkers = Arrays.asList(weekDayWorker.split(","));
        List<String> holiDayWorkers = Arrays.asList(holiDayWorker.split(","));

        WorkDays workDays = new WorkDays(month, startDay);

        Map<WorkDay, String> schedule = generateScheduleService.generateSchedule(workDays, weekDayWorkers,
                holiDayWorkers);
        printSchedule(schedule);
    }

    private void printSchedule(Map<WorkDay, String> schedule) {
        for (Map.Entry<WorkDay, String> entry : schedule.entrySet()) {
            outputView.printSchedule(entry.getKey(), entry.getValue());
        }
    }
}
