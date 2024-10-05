package source.data.experiment;

import source.data.tool.Tool;
import source.data.usage.Usage;
import source.data.user.User;
import source.data.user.UserRole;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Experiment extends Usage {
    private String experimentID;
    private String name;
    private String description;

    @SuppressWarnings("all")
    public Experiment(String experimentID, User user, String name, String description, ArrayList<Tool> requiredTools, LocalDateTime startTime, LocalDateTime endTime) {
        super(experimentID, user, requiredTools, startTime, endTime);
        if(user.getUserRole() == UserRole.PROFESSOR) {
            this.experimentID = experimentID;
            this.name = name;
            this.description = description;
        } else {
            throw new IllegalArgumentException("User is not a professor");
        }
    }

    public String getExperimentID() {return experimentID;}
    public void setExperimentID(String experimentID) {this.experimentID = experimentID;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public ArrayList<Tool> getTools() {return super.getTools();}
    public void setTools(ArrayList<Tool> tools) {super.setTool(tools);}
    public User getUser() {return super.getUser();}
    public void setUser(User user) {
        if(user.getUserRole() != UserRole.PROFESSOR) {
            super.setUser(user);
        } else {
            throw new IllegalArgumentException("User is not a professor");
        }
    }

    @Override
    public String toString() {
        return "LabExperiment [experimentID=" + experimentID
                + ", name=" + name
                + ", description=" + description
                + ", user=" + super.getUser().getUserID()
                + ", tool=" + super.getTools()
                + ", start time=" + this.getStartTime()
                + ", end time=" + this.getEndTime() + "]";
    }
}
