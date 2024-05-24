import java.util.ArrayList;
import java.util.List;

class User extends Entity {
    private String username;
    private String role;
    private String email;
    private String phoneNumber;
    private String address;
    private boolean isActive;

    public User(String userID, String username, String role, String email, String phoneNumber, String address, boolean isActive) {
        super(userID);
        this.username = username;
        this.role = role;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.isActive = isActive;
    }

    // Getter and Setter methods
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    // Display user details
    @Override
    public void displayDetails() {
        System.out.println("User ID: " + getId() + ", Name: " + username + ", Role: " + role + ", Email: " + email + ", Phone: " + phoneNumber + ", Address: " + address + ", Active: " + (isActive ? "Yes" : "No"));
    }


    // Add new user
    public static void addUser(List<User> users, String username, String userID, String role, String email, String phoneNumber, String address, boolean isActive) {
        User newUser = new User(userID, username, role, email, phoneNumber, address, isActive);
        users.add(newUser);
        System.out.println("New user added. User ID: " + userID);
    }

    // Remove user
    public static void removeUser(List<User> users, String userID) {
        for (User user : new ArrayList<>(users)) {
            if (user.getId().equals(userID)) {
                users.remove(user);
                System.out.println("User: " + userID + " removed.");
                return;
            }
        }
        System.out.println("User not found.");
    }

    // Display all users
    public static void displayUsers(List<User> users) {
        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }
        System.out.println("All registered users:");
        for (User user : users) {
            user.displayDetails();
            System.out.println();
        }
    }
}
