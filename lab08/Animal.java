public abstract class Animal implements Comparable<Animal> {

    private static final String DEFAULT_NAME = "newborn";

	private String name;
	private int age;

	public Animal() {
        this(DEFAULT_NAME, 0);
    }
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public abstract void makeNoise();

	public abstract void eat(Food food) throws IllegalArgumentException;

	public void eat(Food food, int repeatCount) throws IllegalArgumentException {
	    for (int i = 0; i < repeatCount; i++) {
	        this.eat(food);
        }
    }

    @Override
    public int compareTo(Animal o) {
        return this.getAge() - o.getAge();
    }
}