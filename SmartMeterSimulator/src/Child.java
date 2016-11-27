/**
 * Created by nikolabozhkov on 11/25/16.
 */
public class Child extends Person {

    public Child(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void addTask(Task task) {
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
                    + task.getType().toString() + " on " + task.getTargetApplianceType().toString());
        }
    }

    @Override
    public void setAge(int age) {
        if (age > 17) {
            throw new IllegalArgumentException("Child cannot have age more than 17.");
        }

        super.setAge(age);
    }
}
