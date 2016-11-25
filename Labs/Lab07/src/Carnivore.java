/**
 * Created by nikolabozhkov on 11/25/16.
 */
public abstract class Carnivore extends Animal {

    public Carnivore(String name, int age) {
        super(name, age);
    }

    public void eat(Food food) {
        System.out.println(this.getName() + " is eating " + food.getName());
    }
}
