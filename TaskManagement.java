import java.util.Date;
interface TaskManagement {
    void createTask(String taskID, String title, String description, Date startDate, Date endDate, String priority);
    void removeTask(String taskID);
    void displayTasks();
    void assignUserToTask(String taskID, String userID);
    void deallocateTask(String taskID);
    void updateTaskStatus(String taskID, String status);
    void displayTasksByStatus(String status);
}
