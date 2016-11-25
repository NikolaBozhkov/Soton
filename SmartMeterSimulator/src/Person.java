/**
 * Created by nikolabozhkov on 11/23/16.
 */
public abstract class Person extends TimeAffected {
    protected String name;
    protected int age;

    protected Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        if (name.length() != 0) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Person name cannot be an empty string.");
        }
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Person age cannot be a negative number.");
        }
    }
}
