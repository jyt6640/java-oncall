package oncall.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import oncall.domain.WorkDay;
import oncall.domain.WorkDays;

public class OnCallService {

    public Map<WorkDay, String> generateSchedule(WorkDays workDays, List<String> weekdayWorkers, List<String> holidayWorkers) {
        List<String> mutableWeekdayWorkers = new ArrayList<>(weekdayWorkers);
        List<String> mutableHolidayWorkers = new ArrayList<>(holidayWorkers);
        Map<WorkDay, String> schedule = new LinkedHashMap<>();

        int weekdayWorkerIndex = 0;
        int holidayWorkerIndex = 0;
        String previousWorker = null;

        for (WorkDay workDay : workDays.getWorkDays()) {
            String currentWorker;
            if (workDay.isHoliday()) {
                currentWorker = assignHolidayWorker(previousWorker, holidayWorkerIndex, mutableHolidayWorkers);
                holidayWorkerIndex++;
            } else {
                currentWorker = assignWeekdayWorker(previousWorker, weekdayWorkerIndex, mutableWeekdayWorkers);
                weekdayWorkerIndex++;
            }
            schedule.put(workDay, currentWorker);
            previousWorker = currentWorker;
        }
        return schedule;
    }

    private String assignHolidayWorker(String previousWorker, int index, List<String> workers) {
        String worker = workers.get(index % workers.size());
        if (!worker.equals(previousWorker)) {
            return worker;
        }
        Collections.swap(workers, index % workers.size(), (index + 1) % workers.size());
        return workers.get(index % workers.size());
    }

    private String assignWeekdayWorker(String previousWorker, int index, List<String> workers) {
        String worker = workers.get(index % workers.size());
        if (!worker.equals(previousWorker)) {
            return worker;
        }
        Collections.swap(workers, index % workers.size(), (index + 1) % workers.size());
        return workers.get(index % workers.size());
    }
}
