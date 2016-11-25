public class Main {

	public static void main(String[] args) {
		Animal wolf = new Wolf("Joe The Wolf", 4);
		Animal parrot = new Parrot("Rex the Parrot", 1);
		
		wolf.makeNoise();
		parrot.makeNoise();
		
		Food meat = new Meat("Beefy");
		Food plant = new Plant("Planty");
	}
}