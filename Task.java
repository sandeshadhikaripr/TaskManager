import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Task {
    private String taskID;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private String priority;
    private String assignedUserID;
    private String status; // "Ongoing", "Completed", "Pending"

    public Task(String taskID, String title, String description, Date startDate, Date endDate, String priority, String assignedUserID, String status) {
        this.taskID = taskID;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
        this.assignedUserID = assignedUserID;
        this.status = status;
    }
        // Getter and Setter methods
    public String getTaskID() { 
        return taskID; 
    }
    public void setTaskID(String taskID) { 
        this.taskID = taskID; 
    }

    public String getTitle() { 
        return title; 
    }
    public void setTitle(String title) { 
        this.title = title; 
    }

    public String getDescription() { 
        return description; 
    }
    public void setDescription(String description) { 
        this.description = description; 
    }

    public Date getStartDate() { 
        return startDate; 
    }
    public void setStartDate(Date startDate) { 
        this.startDate = startDate; 
    }

    public Date getEndDate() { 
        return endDate; 
    }
    public void setEndDate(Date endDate) { 
        this.endDate = endDate; 
    }

    public String getPriority() { 
        return priority; 
    }
    public void setPriority(String priority) { 
        this.priority = priority; 
    }

    public String getAssignedUserID() { 
        return assignedUserID; 
    }
    public void setAssignedUserID(String assignedUserID) { 
        this.assignedUserID = assignedUserID; 
    }

    public String getStatus() { 
        return status; 
    }
    public void setStatus(String status) { 
        this.status = status; 
    }
}
