package oncall.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oncall.domain.WorkDay;
import oncall.domain.WorkDays;

public class GenerateScheduleService {

    public Map<WorkDay, String> generateSchedule(WorkDays workDays, List<String> weekDayWorkers,
                                                 List<String> holidayWorkers) {
        Map<WorkDay, String> schedule = new HashMap<>();

        int weekDayWorkerIndex = 0;
        int holidayWorkerIndex = 0;
        String previousWorker = null;

        for (WorkDay workDay : workDays.getWorkDays()) {
            String currentWorker = null;
            if (workDay.isHoliday()) {
                currentWorker = assignHolidayWorker(previousWorker, holidayWorkerIndex, holidayWorkers);
                holidayWorkerIndex++;
            }
            if (!workDay.isHoliday()) {
                currentWorker = assignWeekDayWorker(previousWorker, weekDayWorkerIndex, weekDayWorkers);
                holidayWorkerIndex++;
            }
            schedule.put(workDay, currentWorker);
            previousWorker = currentWorker;
        }

        return schedule;
    }

    private String assignHolidayWorker(String previousWorker, int index, List<String> workers) {
        return workers.get(index % workers.size());
    }

    private String assignWeekDayWorker(String previousWorker, int index, List<String> workers) {
        return workers.get(index % workers.size());
    }
}
