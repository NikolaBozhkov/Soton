public class Main {

	public static void main(String[] args) {
		Animal wolf = new Wolf("Joe The Wolf", 4);
		Animal parrot = new Parrot("Rex the Parrot", 1);
		Animal deer = new Deer("Bambo the Deer", 2);
		
		Food meat = new Meat("Beefy");
		Food plant = new Plant("Planty");
		
		// Test repeat eating
		wolf.eat(meat, 5);
		deer.eat(plant, 2);
		parrot.eat(meat, 1);

		Animal wolfNewborn = new Wolf();
		System.out.println(wolfNewborn.getName() + " is " + wolfNewborn.getAge() + " years old.");
	}
}
