import java.util.*;

public class Main {
	private static int STEPS = 20;
	private static int THRESHOLD = 500;
	
	public static void main(String[] args) throws InputMismatchException {
		System.out.print("Enter value to multiply by: ");

		// Can encouter InputMismatchException if value is not int
		Scanner scanner = new Scanner(System.in);
		int multiplier = scanner.nextInt();
		
		// Calculate max number's length
		int maxNumLen = Integer.toString(multiplier * STEPS).length();
		
		// Print the multiplier's steps
		for (int i = 1; i <= STEPS; i++) {
			int num = i * multiplier;
			int numLen = Integer.toString(num).length();
			
			// Create spacing between numbers for alignment
			String spacing = new String(new char[maxNumLen * 2 - numLen]).replace('\0', ' ');
			System.out.print(num + spacing);
			
			// Every 5th number shift to the next line
			if (i % 5 == 0) {
				System.out.println();
			}
		}
		
		int sum = 0;
		int counter = 0;
		while(sum <= THRESHOLD) {
			// sum integers starting from 1, so counter + 1
			sum += counter + 1;
			++counter;
		}
		
		// Print num of iterations it took
		System.out.println("\nIt took " + counter + " iterations to get a sum over " + THRESHOLD);
		System.out.println();
		
		// Create new UserGroup and test it
		UserGroup userGroup = new UserGroup();
		userGroup.addSampleData();
		
		System.out.println("Main user group:");
		userGroup.printUsernames();
		
		// Create new administrator only UserGroup
		UserGroup administrators = new UserGroup();
		
		// Add only the admins from userGroup to administrators
		Iterator<User> iterator = userGroup.getUserIterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			
			if (user.getUserType().equals("admin")) {
				administrators.users.add(user);
			}
		}
		
		// Check if filtering worked
		System.out.println("\nAdministrators user group:");
		administrators.printUsernames();
		
		// Set the userType of the last administrator back to user
		administrators.users.get(administrators.users.size() - 1).setUserType("user");
		
		// Check how the the user groups were affected
		/*
        * Changing the user type of a user in administrators changed
		* the same user's type in the main user group because they share a reference,
		* thus pointing to the same object in memory.
		* Copying the user into a new reference before adding it to administrators will resolve the issue.
        * Another not so smart solution may be to overwrite with a new instance each time a property is changed
		*/
		System.out.println("\nMain user group after change:");
		userGroup.printUsernames();
		System.out.println("\nAdministrators user group after change:");
		administrators.printUsernames();
	}
}
