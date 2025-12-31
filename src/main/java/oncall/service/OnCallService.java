package oncall.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import oncall.domain.WorkDay;
import oncall.domain.WorkDays;

public class OnCallService {

    private int weekdayWorkerIndex = 0;
    private int holidayWorkerIndex = 0;
    private String previousWorker = null;
    private List<String> weekdayWorkers;
    private List<String> holidayWorkers;

    public Map<WorkDay, String> generateSchedule(WorkDays workDays, List<String> weekdayWorkers, List<String> holidayWorkers) {
        this.weekdayWorkers = new ArrayList<>(weekdayWorkers);
        this.holidayWorkers = new ArrayList<>(holidayWorkers);
        Map<WorkDay, String> schedule = new LinkedHashMap<>();

        for (WorkDay workDay : workDays.getWorkDays()) {
            String currentWorker = assignWorker(workDay);
            schedule.put(workDay, currentWorker);
            previousWorker = currentWorker;
        }
        return schedule;
    }

    private String assignWorker(WorkDay workDay) {
        if (workDay.isHoliday()) {
            return assignHolidayWorker();
        }
        return assignWeekdayWorker();
    }

    private String assignHolidayWorker() {
        String currentWorker = holidayWorkers.get(holidayWorkerIndex % holidayWorkers.size());
        if (currentWorker.equals(previousWorker)) {
            Collections.swap(holidayWorkers, holidayWorkerIndex % holidayWorkers.size(), (holidayWorkerIndex + 1) % holidayWorkers.size());
            currentWorker = holidayWorkers.get(holidayWorkerIndex % holidayWorkers.size());
        }
        holidayWorkerIndex++;
        return currentWorker;
    }

    private String assignWeekdayWorker() {
        String currentWorker = weekdayWorkers.get(weekdayWorkerIndex % weekdayWorkers.size());
        if (currentWorker.equals(previousWorker)) {
            Collections.swap(weekdayWorkers, weekdayWorkerIndex % weekdayWorkers.size(), (weekdayWorkerIndex + 1) % weekdayWorkers.size());
            currentWorker = weekdayWorkers.get(weekdayWorkerIndex % weekdayWorkers.size());
        }
        weekdayWorkerIndex++;
        return currentWorker;
    }
}
