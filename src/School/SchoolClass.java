package School;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchoolClass {
    private Map<String, List<Schedule>> schedules;

    public SchoolClass() {
        schedules = new HashMap<>();
    }

    public void addSchedule(Schedule schedule) {
        String className = "default";
        if (!schedules.containsKey(className)) {
            schedules.put(className, new ArrayList<>());
        }
        schedules.get(className).add(schedule);
    }

    public List<Schedule> getSchedules() {
        List<Schedule> allSchedules = new ArrayList<>();
        for (List<Schedule> classSchedules : schedules.values()) {
            allSchedules.addAll(classSchedules);
        }
        return allSchedules;
    }
}