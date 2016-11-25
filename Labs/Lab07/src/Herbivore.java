/**
 * Created by nikolabozhkov on 11/25/16.
 */
public abstract class Herbivore extends Animal {

    public Herbivore(String name, int age) {
        super(name, age);
    }

    public void eat(Food food) {
        System.out.println(this.getName() + " is eating " + food.getName());
    }
}
