package Users;
import java.lang.String;

public class Users {

    private String userName;
    private String userId;
    private String email;
    private int phoneNumber;

    public Users(String userName, String userId, String email, int phoneNumber) {
        this.userName = userName;
        this.userId = userId;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public String getUserName() {
        return userName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getUserId() {
        return userId;
    }
}
