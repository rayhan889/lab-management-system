package source.data.laboratory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Laboratory {
    public static int MAX_CAPACITY = 35;

    private String labID;
    private String name;
    private int capacity;
    private List<LabSchedule> schedules;

    @SuppressWarnings("all")
    public Laboratory(String labID, String name, int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalArgumentException("Capacity exceeds maximum capacity which is : " + MAX_CAPACITY);
        } else {
            this.labID = labID;
            this.name = name;
            this.capacity = capacity;
            this.schedules = new ArrayList<>();
        }
    }

    public String getLabID() {return labID;}
    public void setLabID(String labID) {this.labID = labID;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getCapacity() {return capacity;}
    public void setCapacity(int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalArgumentException("Capacity exceeds maximum capacity which is : " + MAX_CAPACITY);
        } else {
            this.capacity = capacity;
        }
    }
    public List<LabSchedule> getSchedules() {return schedules;}
    public void setSchedules(List<LabSchedule> schedules) {this.schedules = schedules;}

    public void addScheduleEntry(LabSchedule schedule) {schedules.add(schedule);}

    public boolean isAvailable(LocalDateTime start, LocalDateTime end) {
        for (LabSchedule schedule : schedules) {
            if (!(end.isBefore(schedule.getStartTime())) || start.isAfter(schedule.getEndTime())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Laboratory [labID=" + labID
                + ", name=" + name
                + ", capacity=" + capacity + "]";
    }
}
