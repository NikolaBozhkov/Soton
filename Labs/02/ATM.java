import java.util.Scanner;

public class ATM {	
	// Declare constants that only the class will use and will not be changed
	private static final String HEADING_BREAK = "*****************************************";
	private static final int WITHDRAW = 1;
	private static final int DEPOSIT = 2;
	private static final int INQUIRE = 3;
	private static final int QUIT = 4;

	// Declare an int class member variable that is only accessible within the class
	private int bankBalance = 0;
	
	public void go() {
		// Initial bank account set up, executed only once
		this.setUpAccount();
		
		// Display the CLI, get user input, handle it and loop until handleInput stops the program
		while (true) {
			this.displayMenu();
			int input = this.getInput();
			this.handleInput(input);
		}
	}
	
	public void setUpAccount() {
		// Print welcome message and prompt for number
		System.out.print("Welcome to online ATM banking\nHow much do you want in your account?\nEnter your number ");
		
		// Ensure the input is a positive integer
		int amount = this.readPositiveInt();
		
		// Confirm that the bankBalance was set
		this.bankBalance = amount;
		System.out.println("\nYour balance was set to " + this.bankBalance);
	}
	
	public void displayMenu() {
		System.out.println("\nWhat do you want to do?");
		System.out.println("1 : Withdraw");
		System.out.println("2 : Deposit");
		System.out.println("3 : Inquire");
		System.out.println("4 : Quit");
		System.out.print("Enter your number ");
	}
	
	public int getInput() {
		// Validate option choice and ask for new input until a valid one is entered
		int input = this.readPositiveInt();
		while (input != WITHDRAW && input != DEPOSIT && input != INQUIRE && input != QUIT) {
			System.out.print("That is an invalid option, please try again: ");
			input = this.readPositiveInt();
		}
		
		// Return the value to be used in other context
		return input;
	}
	
	public void displayHeading(String text) {
		System.out.println();
		System.out.println(HEADING_BREAK);
		
		// A bit of text centering for the heading, not precise
		int spaceNum = (HEADING_BREAK.length() - text.length()) / 2;
		System.out.println(new String(new char[spaceNum]).replace('\0', ' ') + text);
		
		System.out.println(HEADING_BREAK);
	}
	
	public void handleInput(int input) {
		// Call handling method and don't display heading on invalid input
		if (input == WITHDRAW) {
			this.displayHeading("Withdraw");
			this.withdraw();
		} else if (input == DEPOSIT) {
			this.displayHeading("Deposit");
			this.deposit();
		} else if (input == INQUIRE) {
			this.inquire();
		} else if (input == QUIT) {
			this.quit();
		} else {
			// This empty else with return indicated that not doing anything on a wrong input is the desired behavior
			return;
		}
	}
	
	public int readPositiveInt() {
		// Creates a new Scanner with input stream the default System.in
		Scanner scanner = new Scanner(System.in);
		
		// Scan the next entered integer and assign it to the amount variable
		// If it is not an integer an error will be thrown
		int amount = scanner.nextInt();
		
		// Ask for new input until a positive integer is entered
		while (amount < 0) {
			System.out.println("Invalid input, please enter a positive value");
			System.out.print("Enter your number ");
			amount = scanner.nextInt();
		}
		
		// Return the value to be used in other context
		return amount;
	}
	
	public void withdraw() {
		System.out.println("How much would you like to withdraw?");
		System.out.print("Enter your number ");
		
		// Make sure the client has enough money in his/her account
		int amount = this.readPositiveInt();
		while (this.bankBalance - amount < 0) {
			System.out.println("Withdraw amount cannot exceed bank balance.");
			amount = this.readPositiveInt();
		}
		
		// Update the account balance and print out the appropriate message
		this.bankBalance -= amount;
		System.out.println(amount + (amount == 1 ? " has" : " have") + " been successfully withdrawn from your account.");
	}
	
	public void deposit() {
		System.out.println("How much would you like to deposit?");
		System.out.print("Enter your number ");
		
		// Ensure a positive deposit value
		int amount = this.readPositiveInt();
		
		// Update the account balance and print out the appropriate message
		this.bankBalance += amount;
		System.out.println(amount + (amount == 1 ? " has" : " have") + " been successfully deposited to your account.");
	}
	
	public void inquire() {
		this.displayHeading("Your balance is " + this.bankBalance);
	}
	
	public void quit() {
		this.displayHeading("GoodBye!");
		System.exit(0);
	}
}