/**
 * Models a Child that is below 18 y/o and cannot perform dangerous tasks
 * Children ignore turn TV off commands
 */
public class Child extends Person {

    public Child(String name, int age, String gender) {
        super(name, age, gender);
    }

    /**
     * Adds the given task to the task list of the Child but ignores it if it
     * is a turn TV off. Tasks cannot be related to Cooker, Boiler or Kettle.
     * @param task the type of the task(must be safe)
     * @throws IllegalArgumentException
     */
    @Override
    public void addTask(Task task) throws IllegalArgumentException {
        // Check if trying to add a turn off TV task and ignore it
        if (task.getTargetApplianceType() == ApplianceType.TV
                && task.getType() == TaskType.TURN_OFF) {
            return;
        }

        // Check if the task is dangerous
        if (task.getTargetApplianceType() != ApplianceType.COOKER
                && task.getTargetApplianceType() != ApplianceType.BOILER
                && task.getTargetApplianceType() != ApplianceType.KETTLE) {
            super.addTask(task);
        } else {
            throw new IllegalArgumentException("Child cannot perform dangerous task of type "
                    + task.getType() + " on " + task.getTargetApplianceType());
        }
    }

    /**
     * Sets the age of the Child, throws an IllegalArgumentException if the age is more than 17
     * @param age
     * @throws IllegalArgumentException
     */
    @Override
    public void setAge(int age) throws IllegalArgumentException {
        if (age > 17) {
            throw new IllegalArgumentException("Child cannot have age more than 17.");
        }

        super.setAge(age);
    }
}
