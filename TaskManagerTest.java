import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    private TaskManager manager;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @BeforeEach
    void setUp() {
        manager = TaskManager.getInstance();
        // Clearing users and tasks list before each test
        manager.users.clear();
        manager.tasks.clear();
    }

    @Test
    void testCreateTask() throws ParseException {
        Date startDate = dateFormat.parse("01-01-2022");
        Date endDate = dateFormat.parse("10-01-2022");
        manager.createTask("T1", "Task 1", "Description", startDate, endDate, "High");
        assertEquals(1, manager.tasks.size());
        Task task = manager.tasks.get(0);
        assertEquals("Task 1", task.getTitle());
        assertEquals("Description", task.getDescription());
        assertEquals(startDate, task.getStartDate());
        assertEquals(endDate, task.getEndDate());
        assertEquals("High", task.getPriority());
        assertNull(task.getAssignedUserID());
        assertEquals("Pending", task.getState());
    }

    @Test
    void testAssignUserToTask() throws ParseException {
        manager.registerNewUser("JohnDoe", "U1", "Developer", "john@example.com", "1234567890", "123 Street", true);
        Date startDate = dateFormat.parse("01-01-2022");
        Date endDate = dateFormat.parse("10-01-2022");
        manager.createTask("T1", "Task 1", "Description", startDate, endDate, "High");
        manager.assignUserToTask("T1", "U1");
        Task task = manager.tasks.get(0);
        assertEquals("U1", task.getAssignedUserID());
        assertEquals("Ongoing", task.getState());
    }

    @Test
    void testDeallocateTask() throws ParseException {
        manager.registerNewUser("JohnDoe", "U1", "Developer", "john@example.com", "1234567890", "123 Street", true);
        Date startDate = dateFormat.parse("01-01-2022");
        Date endDate = dateFormat.parse("10-01-2022");
        manager.createTask("T1", "Task 1", "Description", startDate, endDate, "High");
        manager.assignUserToTask("T1", "U1");
        manager.deallocateTask("T1");
        Task task = manager.tasks.get(0);
        assertNull(task.getAssignedUserID());
        assertEquals("Pending", task.getState());
    }

    @Test
    void testUpdateTaskStatusToOngoing() throws ParseException {
        Date startDate = dateFormat.parse("01-01-2022");
        Date endDate = dateFormat.parse("10-01-2022");
        manager.createTask("T1", "Task 1", "Description", startDate, endDate, "High");
        manager.updateTaskStatus("T1", "Ongoing");
        Task task = manager.tasks.get(0);
        assertEquals("Ongoing", task.getState());
    }

    @Test
    void testUpdateTaskStatusToCompleted() throws ParseException {
        Date startDate = dateFormat.parse("01-01-2022");
        Date endDate = dateFormat.parse("10-01-2022");
        manager.createTask("T1", "Task 1", "Description", startDate, endDate, "High");
        manager.updateTaskStatus("T1", "Completed");
        Task task = manager.tasks.get(0);
        assertEquals("Completed", task.getState());
    }

    @Test
    void testDisplayTasksByStatus() throws ParseException {
        Date startDate = dateFormat.parse("01-01-2022");
        Date endDate = dateFormat.parse("10-01-2022");
        manager.createTask("T1", "Task 1", "Description", startDate, endDate, "High");
        manager.updateTaskStatus("T1", "Ongoing");

        Date startDate2 = dateFormat.parse("11-01-2022");
        Date endDate2 = dateFormat.parse("20-01-2022");
        manager.createTask("T2", "Task 2", "Description", startDate2, endDate2, "Medium");

        System.out.println("Ongoing tasks:");
        manager.displayTasksByStatus("Ongoing");

        System.out.println("Pending tasks:");
        manager.displayTasksByStatus("Pending");
    }
}
