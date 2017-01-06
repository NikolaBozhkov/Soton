/**
 * Models a Grown Up Person that can perform any task without limitations
 * Grown Ups cannot be below 18 y/o
 */
public class GrownUp extends Person {

    public GrownUp(String name, int age, String gender) {
        super(name, age, gender);
    }

    /**
     * Sets the age of the GrownUp, throws an IllegalArgumentException if it is less than 18
     * @param age
     * @throws IllegalArgumentException
     */
    @Override
    public void setAge(int age) throws IllegalArgumentException {
        if (age < 18) {
            throw new IllegalArgumentException("GrownUp cannot have age less than 18.");
        }

        super.setAge(age);
    }
}
