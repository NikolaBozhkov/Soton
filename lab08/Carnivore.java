/*
 * Models an Animal that does not eat plants
 */
public abstract class Carnivore extends Animal {

    public Carnivore() {
        super();
    }

    public Carnivore(String name, int age) {
        super(name, age);
    }

    public void eat(Food food) throws IllegalArgumentException {
		// Do not allow Herbivore to eat food of type Plant
		if (food instanceof Plant) {
			throw new IllegalArgumentException("Carnivore cannot eat food of type Plant.");
		} else {
			System.out.println(this.getName() + " is eating " + food.getName());
		}
    }
}
