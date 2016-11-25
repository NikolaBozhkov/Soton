import java.util.*;

public class UserGroup {
	public ArrayList<User> users;
	
	// Instantiates a new user group by creating an empty ArrayList of users
	public UserGroup() {
		this.users = new ArrayList<User>();
	}
	
	// Adds 10 different users to the user group
	public void addSampleData() {
		for (int i = 0; i < 10; i++) {
			// Alternate the userType, so they are equally distributed
			String userType = User.USER_TYPES[i % User.USER_TYPES.length];
			
			User user = new User("user" + i, userType, "name" + i);
			this.users.add(user);
		}
	}
	
	// Prints the username and userType of each user in the user group
	public void printUsernames() {
		for (User user : this.users) {
			System.out.println(user.getUsername() + " " + user.getUserType());
		}
	}

	// Removes the first entry of the users property
	public void removeFirstUser() {
		// Only remove if there are users
		if (this.users.size() != 0) {
			this.users.remove(0);
		}
	}
	
	// Removes the last entry of the users property
	public void removeLastUser() {
		// Only remove if there are users
		if (this.users.size() != 0) {
			this.users.remove(this.users.size() - 1);
		}
	}
	
	// Removes a user from the users by its username
	public void removeUser(String username) {
		Iterator<User> iterator = this.getUserIterator();
		
		// Iterates through all users until it finds a match
		while (iterator.hasNext()) {
			User user = iterator.next();
			
			// If the usernames is found remove the user and stop looking
			if (user.getUsername().equals(username)) {
				iterator.remove();
				return;
			}
		}
	}
	
	public Iterator<User> getUserIterator() {
		return this.users.iterator();
	}
}
