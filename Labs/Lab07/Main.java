public class Main {

	public static void main(String[] args) {
		Animal wolf = new Wolf("Joe The Wolf", 4);
		Animal parrot = new Parrot("Rex the Parrot", 1);
		Animal deer = new Deer("Bambo the Deer", 2);
		
		wolf.makeNoise();
		parrot.makeNoise();
		
		Food meat = new Meat("Beefy");
		Food plant = new Plant("Planty");
		
		// Test correct eating
		wolf.eat(meat);
		deer.eat(plant);
		parrot.eat(meat);
		
		// Test invalid eat method arguments
		try {
			deer.eat(meat);
			wolf.eat(plant);
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}
}
