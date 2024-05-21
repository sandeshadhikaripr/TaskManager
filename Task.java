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

    public void displayTaskDetails() {
        System.out.println("Task ID: " + taskID);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Priority: " + priority);
        System.out.println("Assigned User ID: " + (assignedUserID != null ? assignedUserID : "None"));
        System.out.println("Status: " + status);
    }
    
    //Create tasks
    public static void createTask(List<Task> tasks, String taskID, String title, String description, Date startDate, Date endDate, String priority) {
        Task newTask = new Task(taskID, title, description, startDate, endDate, priority, null, "Pending");
        tasks.add(newTask);
        System.out.println("New task created. Task ID: " + taskID);
    }

    //Remove tasks
    public static void removeTask(List<Task> tasks, String taskID) {
        for (Task task : new ArrayList<>(tasks)) {
            if (task.getTaskID().equals(taskID)) {
                tasks.remove(task);
                System.out.println("Task: " + taskID + " removed.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    //Display tasks
    public static void displayTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks created.");
            return;
        }
        System.out.println("All tasks:");
        for (Task task : tasks) {
            task.displayTaskDetails();
            System.out.println();
        }
    }
}
