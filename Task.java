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
}
