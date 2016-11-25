public class TestCalculator {
    private final Calculator mockCalculator;

    public TestCalculator() {
        this.mockCalculator = new Calculator();
    }
    
    /*
    * Tests if the Calculator class parses correctly addition and multiplication expressions.
    * Tests if invalid expression return null.
    * Returns true if all tests pass, false otherwise.
    */
    public boolean testParser() {
        boolean succeeded = true;

        // Test addition expression
        Double resultAddition = this.mockCalculator.x("12 + 5");
        Double expectedAddition = new Double(17);
        
        if (!resultAddition.equals(expectedAddition)) {
            succeeded = false;
            System.out.println("[FAIL] Basic parsing fails to add.");
        } else {
            System.out.println("[ OK ] Parser adds correctly.");
        }

        // Test multiplication expression
        Double resultMulti = this.mockCalculator.x("12 x 5");
        Double expectedMulti = new Double(60);
        
        if (!resultMulti.equals(expectedMulti)) {
            succeeded = false;
            System.out.println("[FAIL] Basic parsing multiply to add.");
        } else {
            System.out.println("[ OK ] Parser multiplies correctly.");
        }
        
        // Test invalid expression
        Double resultInvalid = this.mockCalculator.x("12 [ 5");
        
        if (null != resultInvalid) {
            succeeded = false;
            System.out.println("[FAIL] Parser does not return null for operators which are not supported.");
        } else {
            System.out.println("[ OK ] Parser returns null for operators which are not supported.");
        }

        return succeeded;
    }

    /*
    * Tests if the Calculator class adds correctly positive and negative Doubles.
    * Returns true if all tests pass, false otherwise.
    */
    public boolean testAdd() {
        boolean succeeded = true;

        // Test positive addition
        this.mockCalculator.x = new Double(10);
        
        Double resultPositive = this.mockCalculator.x(new Double(5));
        Double expectedPositive = new Double(15);

        if (!resultPositive.equals(expectedPositive)) {
            succeeded = false;
            System.out.println("[FAIL] Calculator adds incorrectly");
        } else {
            System.out.println("[ OK ] Calculator can add positive numbers");
        }

        // Test negative addition
        this.mockCalculator.x = new Double(-10);
        
        Double resultNegative = this.mockCalculator.x(new Double(-5));
        Double expectedNegative = new Double(-15);
        
        if (!resultNegative.equals(expectedNegative)) {
            succeeded = false;
            System.out.println("[FAIL] Calculator adds with negative numbers incorrectly");
        } else {
            System.out.println("[ OK ] Calculator can add a negative number");
        }

        return succeeded;
    }

    /*
    * Tests if the Calculator class multiplies correctly positives and by a negative double values.
    * Returns true if all tests pass, false otherwise.
    */
    public boolean testMultiplication() {
        boolean succeeded = true;

        // Test positive multiplication
        this.mockCalculator.x = new Double(10);
        
        Double resultPositive = this.mockCalculator.x(5);
        Double expectedPositive = new Double(50);
        
        if (!resultPositive.equals(expectedPositive)) {
            succeeded = false;
            System.out.println("[FAIL] Calculator multiplies incorrectly");
        } else {
            System.out.println("[ OK ] Calculator can multiply positive numbers");
        }

        // Test negative multiplication        
        Double resultNegative = this.mockCalculator.x(-5);
        Double expectedNegative = new Double(-50);
        
        if (!resultNegative.equals(expectedNegative)) {
            succeeded = false;
            System.out.println("[FAIL] Calculator multiplies by negative incorrectly");
        } else {
            System.out.println("[ OK ] Calculator can multiply by a negative number");
        }

        return succeeded;
    }
}