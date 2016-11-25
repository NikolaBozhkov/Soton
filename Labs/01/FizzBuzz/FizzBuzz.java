public class FizzBuzz {
	public static void main(String[] args) {
		// Loop through all integers from 1 to 61(exclusive)
		for(Integer i = new Integer(1); i < 61; i++) {
			// Print Fizz if int is divisible by 3
			if(i % 3 == 0) {
				System.out.print("Fizz");
			}
			
			// Print Fizz if int is divisible by 5
			if(i % 5 == 0) {
				System.out.print("Buzz");
			}
			
			// Print the int if it is not divisible by both 3 and 5
			if(i % 3 != 0 && i % 5 != 0) {
				System.out.print(i);	
			}
			
			// Print new line to avoid clutter of output on a single line
			System.out.println();
		}
	}
}