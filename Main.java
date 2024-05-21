import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        while (!exit) {
            System.out.println("\nTask Management System:");
            System.out.println("1. Add User");
            System.out.println("2. Remove User");
            System.out.println("3. List all users");
            System.out.println("4. Update user details");
            System.out.println("5. Create Task");
            System.out.println("6. Remove task");
            System.out.println("7. List all created tasks");
            System.out.println("8. Assign task to user");
            System.out.println("9. Update task assignment");
            System.out.println("10. Deallocate task");
            System.out.println("11. Complete task");
            System.out.println("12. View ongoing tasks");
            System.out.println("13. View completed tasks");
            System.out.println("14. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter user ID: ");
                    String userID = scanner.nextLine();
                    System.out.print("Enter role: ");
                    String role = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Is active (true/false): ");
                    boolean isActive = scanner.nextBoolean();
                    scanner.nextLine(); // Consume newline
                    manager.registerNewUser(username, userID, role, email, phoneNumber, address, isActive);
                    break;
                case 2:
                    System.out.print("Enter user ID to remove: ");
                    userID = scanner.nextLine();
                    manager.removeUser(userID);
                    break;
                case 3:
                    manager.displayUsers();
                    break;

                case 4:
                    System.out.print("Enter user ID to update: ");
                    userID = scanner.nextLine();
                    System.out.print("Enter new username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter new role: ");
                    role = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    email = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    phoneNumber = scanner.nextLine();
                    System.out.print("Enter new address: ");
                    address = scanner.nextLine();
                    System.out.print("Is active (true/false): ");
                    isActive = scanner.nextBoolean();
                    scanner.nextLine(); // Consume newline
                    manager.updateUserDetails(userID, username, role, email, phoneNumber, address, isActive);
                    break;

                case 5:
                    System.out.print("Enter task ID: ");
                    String taskID = scanner.nextLine();
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter start date (dd-MM-yyyy): ");
                    String startDateStr = scanner.nextLine();
                    System.out.print("Enter end date (dd-MM-yyyy): ");
                    String endDateStr = scanner.nextLine();
                    System.out.print("Enter priority: ");
                    String priority = scanner.nextLine();
                    try {
                        Date startDate = dateFormat.parse(startDateStr);
                        Date endDate = dateFormat.parse(endDateStr);
                        manager.createTask(taskID, title, description, startDate, endDate, priority);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use dd-MM-yyyy.");
                    }
                    break;

                case 6:
                    System.out.print("Enter task ID to remove: ");
                    taskID = scanner.nextLine();
                    manager.removeTask(taskID);
                    break;

                case 7:
                    manager.displayTasks();
                    break;

                case 8:
                    System.out.print("Enter task ID: ");
                    taskID = scanner.nextLine();
                    System.out.print("Enter user ID to assign: ");
                    userID = scanner.nextLine();
                    manager.assignUserToTask(taskID, userID);
                    break;

                case 9:
                    System.out.print("Enter task ID: ");
                    taskID = scanner.nextLine();
                    System.out.print("Enter new user ID to assign: ");
                    userID = scanner.nextLine();
                    manager.assignUserToTask(taskID, userID);
                    break;

                case 10:

                    break;

                case 11:
                    break;

                case 12:
                    manager.displayTasksByStatus("Ongoing");
                    break;

                case 13:
                    manager.displayTasksByStatus("Completed");
                    break;

                case 14:
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        
        }
        scanner.close();
    }
}
