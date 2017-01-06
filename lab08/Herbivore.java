/*
 * Models an Animal that does not eat meat
 */
public abstract class Herbivore extends Animal {

    public Herbivore(String name, int age) {
        super(name, age);
    }

    public void eat(Food food) throws IllegalArgumentException {
		// Do not allow Herbivore to eat food of type Meat
        if (food instanceof Meat) {
			throw new IllegalArgumentException("Herbivore cannot eat food of type Meat.");
		} else {
			System.out.println(this.getName() + " is eating " + food.getName());
		}
    }
}
