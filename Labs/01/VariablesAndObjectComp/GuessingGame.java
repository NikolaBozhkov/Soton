public class GuessingGame {
	public static void main(String[] args) {
		// Declare integers to use later
		Integer numberToGuess;
		Integer guessedNumber;
		
		// Create a new instance of the class Toolbox
		Toolbox myToolbox = new Toolbox();
		
		// Set integer values to a random number and a user input respectively
		numberToGuess = myToolbox.getRandomInteger(10);	
		guessedNumber = myToolbox.readIntegerFromCmd();
			
		// Give hints to what the numberToGuess is
		if (numberToGuess.equals(guessedNumber)) {
			System.out.println("Gratz! You guessed right!");	
		} else if (guessedNumber > numberToGuess) {
			System.out.println("The number is lower than " + guessedNumber);
		} else {
			System.out.println("The number is higher than " + guessedNumber);
		}
	}
	
	public static void guessUntilRightVersion() {
		Integer numberToGuess;
		Integer guessedNumber;
		
		Toolbox myToolbox = new Toolbox();
		
		numberToGuess = myToolbox.getRandomInteger(10);
		
		// Ask for number until guessed
		do {
			guessedNumber = myToolbox.readIntegerFromCmd();
			
			// Give hints to what the numberToGuess is
			if (guessedNumber < numberToGuess) {
				System.out.println("The number is higher than " + guessedNumber);
			} else if (guessedNumber > numberToGuess) {
				System.out.println("The number is lower than " + guessedNumber);
			}
		} while (!guessedNumber.equals(numberToGuess));
			
		System.out.println("Gratz! You guessed right!");
	}
}