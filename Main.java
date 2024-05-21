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
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    break;

                case 9:
                    break;

                case 10:

                    break;

                case 11:
                    break;

                case 12:

                    break;

                case 13:

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
