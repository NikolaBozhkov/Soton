import java.util.*;

// Holds the vital information about a user and its functions
public class User {
	public static String[] USER_TYPES = { "user", "admin", "editor" };
	
	private String username;
	private String userType;
	private String name;
	
	// Take the username, user type and the real name of the user to init
	public User(String username, String userType, String name) {
		this.username = username;
		this.setUserType(userType);
		this.name = name;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getUserType() {
		return this.userType;
	}
	
    /*
     * Validates the user type and sets it to "user" if not valid
     */
	public void setUserType(String userType) {
        if (Arrays.asList(User.USER_TYPES).indexOf(userType) != -1) {
            this.userType = userType;
        } else {
            this.userType = "user";
        }
	}
	
	public String getName() {
		return this.name;
	}
}
