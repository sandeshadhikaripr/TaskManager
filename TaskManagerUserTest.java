import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerUserTest {

    private TaskManager manager;

    @BeforeEach
    void setUp() {
        manager = TaskManager.getInstance();
        manager.users.clear();
        manager.tasks.clear();
    }

    @Test
    void testAddNewUser() {
        manager.registerNewUser("JohnDoe", "U1", "Developer", "john.doe@example.com", "1234567890", "123 Main St", true);
        User user = manager.users.get(0);

        assertEquals("U1", user.getId());
        assertEquals("JohnDoe", user.getUsername());
        assertEquals("Developer", user.getRole());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("1234567890", user.getPhoneNumber());
        assertEquals("123 Main St", user.getAddress());
        assertTrue(user.isActive());
    }

    @Test
    void testRemoveExistingUser() {
        manager.registerNewUser("JohnDoe", "U1", "Developer", "john.doe@example.com", "1234567890", "123 Main St", true);
        manager.removeUser("U1");

        assertTrue(manager.users.isEmpty());
    }

    @Test
    void testUpdateUserDetails() {
        manager.registerNewUser("JohnDoe", "U1", "Developer", "john.doe@example.com", "1234567890", "123 Main St", true);
        manager.updateUserDetails("U1", "JaneDoe", "Manager", "jane.doe@example.com", "0987654321", "456 Main St", false);
        User user = manager.users.get(0);

        assertEquals("U1", user.getId());
        assertEquals("JaneDoe", user.getUsername());
        assertEquals("Manager", user.getRole());
        assertEquals("jane.doe@example.com", user.getEmail());
        assertEquals("0987654321", user.getPhoneNumber());
        assertEquals("456 Main St", user.getAddress());
        assertFalse(user.isActive());
    }

    @Test
    void testDisplayAllUsers() {
        manager.registerNewUser("JohnDoe", "U1", "Developer", "john.doe@example.com", "1234567890", "123 Main St", true);
        manager.registerNewUser("JaneDoe", "U2", "Manager", "jane.doe@example.com", "0987654321", "456 Main St", false);

        // Assuming we have a way to capture the console output or check the method's print statements
        manager.displayUsers();
        // Verify output manually or redirect System.out to capture and assert
    }

    @Test
    void testDisplayUserDetails() {
        manager.registerNewUser("JohnDoe", "U1", "Developer", "john.doe@example.com", "1234567890", "123 Main St", true);

        // Assuming we have a way to capture the console output or check the method's print statements
        User user = manager.users.get(0);
        user.displayDetails();
        // Verify output manually or redirect System.out to capture and assert
    }
}
 {

    private TaskManager manager;

    @BeforeEach
    void setUp() {
        manager = TaskManager.getInstance();
        manager.users.clear();
        manager.tasks.clear();
    }

    @Test
    void testAddNewUser() {
        manager.registerNewUser("JohnDoe", "U1", "Developer", "john.doe@example.com", "1234567890", "123 Main St", true);
        User user = manager.users.get(0);

        assertEquals("U1", user.getId());
        assertEquals("JohnDoe", user.getUsername());
        assertEquals("Developer", user.getRole());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("1234567890", user.getPhoneNumber());
        assertEquals("123 Main St", user.getAddress());
        assertTrue(user.isActive());
    }

    @Test
    void testRemoveExistingUser() {
        manager.registerNewUser("JohnDoe", "U1", "Developer", "john.doe@example.com", "1234567890", "123 Main St", true);
        manager.removeUser("U1");

        assertTrue(manager.users.isEmpty());
    }

    @Test
    void testUpdateUserDetails() {
        manager.registerNewUser("JohnDoe", "U1", "Developer", "john.doe@example.com", "1234567890", "123 Main St", true);
        manager.updateUserDetails("U1", "JaneDoe", "Manager", "jane.doe@example.com", "0987654321", "456 Main St", false);
        User user = manager.users.get(0);

        assertEquals("U1", user.getId());
        assertEquals("JaneDoe", user.getUsername());
        assertEquals("Manager", user.getRole());
        assertEquals("jane.doe@example.com", user.getEmail());
        assertEquals("0987654321", user.getPhoneNumber());
        assertEquals("456 Main St", user.getAddress());
        assertFalse(user.isActive());
    }

    @Test
    void testDisplayAllUsers() {
        manager.registerNewUser("JohnDoe", "U1", "Developer", "john.doe@example.com", "1234567890", "123 Main St", true);
        manager.registerNewUser("JaneDoe", "U2", "Manager", "jane.doe@example.com", "0987654321", "456 Main St", false);

        // Assuming we have a way to capture the console output or check the method's print statements
        manager.displayUsers();
        // Verify output manually or redirect System.out to capture and assert
    }

    @Test
    void testDisplayUserDetails() {
        manager.registerNewUser("JohnDoe", "U1", "Developer", "john.doe@example.com", "1234567890", "123 Main St", true);

        // Assuming we have a way to capture the console output or check the method's print statements
        User user = manager.users.get(0);
        user.displayDetails();
        // Verify output manually or redirect System.out to capture and assert
    }
}
