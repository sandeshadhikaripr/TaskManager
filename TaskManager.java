import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskManager {
    private List<User> users;
    private List<Task> tasks;

    public TaskManager() {
        users = new ArrayList<>();
        tasks = new ArrayList<>();
    }

    // User Management Methods
    public void registerNewUser(String username, String userID, String role, String email, String phoneNumber, String address, boolean isActive) {
        User.addUser(users, username, userID, role, email, phoneNumber, address, isActive);
    }

    public void removeUser(String userID) {
        User.removeUser(users, userID);
    }

    public void displayUsers() {
        User.displayUsers(users);
    }

    public void updateUserDetails(String userID, String username, String role, String email, String phoneNumber, String address, boolean isActive) {
        for (User user : users) {
            if (user.getUserID().equals(userID)) {
                user.setUsername(username);
                user.setRole(role);
                user.setEmail(email);
                user.setPhoneNumber(phoneNumber);
                user.setAddress(address);
                user.setActive(isActive);
                System.out.println("User details updated for User ID: " + userID);
                return;
            }
        }
        System.out.println("User not found.");
    }

    // Task Management Methods
    public void createTask(String taskID, String title, String description, Date startDate, Date endDate, String priority) {
        Task.createTask(tasks, taskID, title, description, startDate, endDate, priority);
    }

    public void removeTask(String taskID) {
        Task.removeTask(tasks, taskID);
    }

    public void displayTasks() {
        Task.displayTasks(tasks);
    }
    
    public void assignUserToTask(String taskID, String userID) {
        for (Task task : tasks) {
            if (task.getTaskID().equals(taskID)) {
                for (User user : users) {
                    if (user.getUserID().equals(userID)) {
                        task.setAssignedUserID(userID);
                        task.setStatus("Ongoing");
                        System.out.println("Task " + taskID + " assigned to User ID: " + userID);
                        return;
                    }
                }
                System.out.println("User not found.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void deallocateTask(String taskID) {
        for (Task task : tasks) {
            if (task.getTaskID().equals(taskID)) {
                task.setAssignedUserID(null);
                task.setStatus("Pending");
                System.out.println("Task " + taskID + " deallocated.");
                return;
            }
        }
        System.out.println("Task not found.");
    }
}
