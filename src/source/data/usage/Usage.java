package source.data.usage;

import source.data.tool.Tool;
import source.data.user.User;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Usage {
    private String usageID;
    private User user;
    private ArrayList<Tool> tools;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Usage(String usageID, User user, ArrayList<Tool> tools, LocalDateTime startTime, LocalDateTime endTime) {
        this.usageID = usageID;
        this.user = user;
        this.tools = tools;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getUsageID() {return usageID;}
    public void setUsageID(String usageID) {this.usageID = usageID;}
    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    public ArrayList<Tool> getTools() {return tools;}
    public void setTool(ArrayList<Tool> tools) {this.tools = tools;}
    public LocalDateTime getStartTime() {return startTime;}
    public void setStartTime(LocalDateTime startTime) {this.startTime = startTime;}
    public LocalDateTime getEndTime() {return endTime;}
    public void setEndTime(LocalDateTime endTime) {this.endTime = endTime;}

    public void startUsage(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void endUsage(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int calculateUsageTime() {
        Duration duration = Duration.between(startTime, endTime);
        return (int) duration.toMinutes();
    }

    public void addTool(int index, Tool tool) {
        tools.add(index, tool);
    }

    public void removeTool(int index) {
        tools.remove(index);
    }

    public void updateTool(int index, Tool tool) {
        tools.set(index, tool);
    }

    @Override
    public String toString() {
        return "LabUsage [usageID=" + usageID
                + ", user=" + user.getUserID()
                + ", tool=" + tools
                + ", start time=" + startTime
                + ", end time=" + endTime + "]";
    }
}
