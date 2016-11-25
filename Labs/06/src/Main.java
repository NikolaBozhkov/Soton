public class Main {
    public static void main(String[] args) {
        TestCalculator calcTester = new TestCalculator();
		
        // Tests all calculator functions
        boolean parserSucceeded = calcTester.testParser();
        boolean addSucceeded = calcTester.testAdd();
        boolean multiplicationSucceeded = calcTester.testMultiplication();

        if (parserSucceeded && addSucceeded && multiplicationSucceeded) {
                System.out.println("Congratulations, your Calculator appears to be working.");
        }
    }
}
