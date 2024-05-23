package CarRentalSystem.entities;

public class User {

    int userId;
    String username;
    String licenseNumber;

    public User(int userId, String username, String licenseNumber) {
        this.userId = userId;
        this.username = username;
        this.licenseNumber = licenseNumber;
    }
}
