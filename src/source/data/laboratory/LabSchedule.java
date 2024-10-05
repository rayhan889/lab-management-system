package source.data.laboratory;

import java.time.LocalDateTime;

public class LabSchedule {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String experimentName;

    public LabSchedule(LocalDateTime startTime, LocalDateTime endTime, String experimentName) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.experimentName = experimentName;
    }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
    public String getExperimentName() { return experimentName; }
    public void setExperimentName(String experimentName) { this.experimentName = experimentName; }

    @Override
    public String toString() {
        return "LabSchedule [startTime=" + startTime + ", endTime=" + endTime + ", experiment name=" + experimentName + "]";
    }
}
