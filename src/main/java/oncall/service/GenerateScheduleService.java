package oncall.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import oncall.domain.WorkDay;
import oncall.domain.WorkDays;

public class GenerateScheduleService {

    public Map<WorkDay, String> generateSchedule(WorkDays workDays, List<String> weekdayWorkers,
                                                 List<String> holidayWorkers) {
        List<String> mutableWeekdayWorkers = new ArrayList<>(weekdayWorkers);
        List<String> mutableHolidayWorkers = new ArrayList<>(holidayWorkers);
        Map<WorkDay, String> schedule = new LinkedHashMap<>();

        int weekDayWorkerIndex = 0;
        int holidayWorkerIndex = 0;
        String previousWorker = null;

        for (WorkDay workDay : workDays.getWorkDays()) {
            String currentWorker = null;
            if (workDay.isHoliday()) {
                currentWorker = assignHolidayWorker(previousWorker, holidayWorkerIndex, mutableHolidayWorkers);
                holidayWorkerIndex++;
            }
            if (!workDay.isHoliday()) {
                currentWorker = assignWeekDayWorker(previousWorker, weekDayWorkerIndex, mutableWeekdayWorkers);
                weekDayWorkerIndex++;
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
