import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {

    /** What is an interface? How does it differ from an abstract class?
     * An interface models functionality but can not declare default behaviour
     * In other words an interface has abstract methods by default and only constants
     * Abstract classes are used to give a base functionality for many children
     * Interfaces are used to show that a given object can do something, usually
     * used when the functionality differs completely from child to child OR
     * when you want to provide another level of abstraction
     */

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();

        animals.add(new Wolf("wolfy", 5));
        animals.add(new Wolf("dolfy", 2));
        animals.add(new Deer("deery", 1));
        animals.add(new Parrot("bob", 10));
        animals.add(new Deer("bipsy", 3));

        // Print animals before ordering
        System.out.println("Animals before ordering:");
        printAnimals(animals);

        /**
         * For highest to lowest we would subtract the current animal's age from the other animal's age
         * as a result of compareTo, which will swap them if the other animal's age is bigger
         */
        Collections.sort(animals);

        // Print animals after ordering
        System.out.println("\nAnimals after ordering:");
        printAnimals(animals);

    }

    private static void printAnimals(List<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal.getName() + " is " + animal.getAge() + " years old.");
        }
    }
}
