public class Calculator {
	Double x;
	/*
	* Chops up input on ' ' then decides whether to add or multiply.
	* If the string does not contain a valid format returns null.
	*/
	public Double x(String x) {
        // Gets the first number of the expression
        this.x = Double.parseDouble(x.split(" ")[0]);
        
        // Return addition or multiplication with the second number in the expression(or null)
        switch(x.split(" ")[1]) {
            case "+":
                return this.x(new Double(Double.parseDouble(x.split(" ")[2])));
            case "x":
                return this.x(Double.parseDouble(x.split(" ")[2]));
            default:
                return null;
        }
	}

	/*
	* Adds the parameter x to the instance variable x and returns the answer as a Double.
	*/
	public Double x(Double x) {
		System.out.println("== Adding ==");
		return this.x + x;
	}

	/*
	* Multiplies the parameter x by instance variable x and return the value as a Double.
	*/
	public Double x(double x) {
		System.out.println("== Multiplying ==");
		return this.x * x;
	}
}