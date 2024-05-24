interface UserManagement {
    void registerNewUser(String username, String userID, String role, String email, String phoneNumber, String address, boolean isActive);
    void removeUser(String userID);
    void displayUsers();
    void updateUserDetails(String userID, String username, String role, String email, String phoneNumber, String address, boolean isActive);
}
