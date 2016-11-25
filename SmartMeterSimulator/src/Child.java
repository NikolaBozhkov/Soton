/**
 * Created by nikolabozhkov on 11/25/16.
 */
public class Child extends Person {

    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    public void setAge(int age) {
        if (age > 17) {
            throw new IllegalArgumentException("Child cannot have age more than 17.");
        }

        super.setAge(age);
    }
}
