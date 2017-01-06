public class Parrot extends Omnivore {

	private static final String DEFAULT_NAME = "Polly";

	public Parrot(int age) {
		this(DEFAULT_NAME, age);
	}

	public Parrot(String name, int age) {
		super(name, age);
	}
	
	public void makeNoise() {
		System.out.println("Raaagh");
	}
}