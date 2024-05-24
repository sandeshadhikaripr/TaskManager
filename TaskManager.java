import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskManager implements UserManagement, TaskManagement {
    private static TaskManager instance;
    private List<User> users;
    private List<Task> tasks;

    public TaskManager() {
        users = new ArrayList<>();
        tasks = new ArrayList<>();
    }

    public static TaskManager getInstance() {
        if (instance == null) {
            synchronized (TaskManager.class) {
                if (instance == null) {
                    instance = new TaskManager();
                }
            }
        }
        return instance;
    }


    // User Management Methods
    @Override
    public void registerNewUser(String username, String userID, String role, String email, String phoneNumber, String address, boolean isActive) {
        User.addUser(users, username, userID, role, email, phoneNumber, address, isActive);
    }

    @Override
    public void removeUser(String userID) {
        User.removeUser(users, userID);
    }
    @Override
    public void displayUsers() {
        User.displayUsers(users);
    }
    @Override
    public void updateUserDetails(String userID, String username, String role, String email, String phoneNumber, String address, boolean isActive) {
        for (User user : users) {
            if (user.getId().equals(userID)) {
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
    @Override
    public void createTask(String taskID, String title, String description, Date startDate, Date endDate, String priority) {
        Task.createTask(tasks, taskID, title, description, startDate, endDate, priority);
    }
    @Override
    public void removeTask(String taskID) {
        Task.removeTask(tasks, taskID);
    }
    @Override
    public void displayTasks() {
        Task.displayTasks(tasks);
    }
    @Override
    public void assignUserToTask(String taskID, String userID) {
        for (Task task : tasks) {
            if (task.getId().equals(taskID)) {
                for (User user : users) {
                    if (user.getId().equals(userID)) {
                        task.setAssignedUserID(userID);
                        task.setState(new OngoingState());
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
    @Override
    public void deallocateTask(String taskID) {
        for (Task task : tasks) {
            if (task.getId().equals(taskID)) {
                task.setAssignedUserID(null);
                task.setState(new PendingState());
                System.out.println("Task " + taskID + " deallocated.");
                return;
            }
        }
        System.out.println("Task not found.");
    }
    @Override
    public void updateTaskStatus(String taskID, String status) {
        for (Task task : tasks) {
            if (task.getId().equals(taskID)) {
                TaskState newState;
                switch (status) {
                    case "Pending":
                        newState = new PendingState();
                        break;
                    case "Ongoing":
                        newState = new OngoingState();
                        break;
                    case "Completed":
                        newState = new CompletedState();
                        break;
                    default:
                        System.out.println("Invalid status: " + status);
                        return;
                }
                task.setState(newState);
                System.out.println("Task " + taskID + " status updated to " + status);
                task.handleTask();
                return;
            }
        }
        System.out.println("Task not found.");
    }
    @Override
    public void displayTasksByStatus(String status) {
        boolean found = false;
        for (Task task : tasks) {
            if (task.getState().contains(status)) {
                task.displayDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks with status: " + status);
        }
    }
}
