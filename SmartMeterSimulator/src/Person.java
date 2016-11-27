import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikolabozhkov on 11/23/16.
 */
public abstract class Person extends TimeAffected {
    private String name;
    private int age;
    private String gender;
    private List<Task> tasks;

    protected Person(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.gender = gender;
        this.tasks = new ArrayList<>();
    }

    private void setName(String name) {
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

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void timePasses(List<Appliance> appliances) {
        for (Task task : this.tasks) {
            if (task.getStartTime() == this.timePassed) {
                // If an appliance that can perform the given task is found, use it and stop searching
                for (Appliance appliance : appliances) {
                    if (appliance.getType() == task.getTargetApplianceType()) {
                        // Print which person performed the task on which appliance
                        System.out.println(this.name + " performed task " + task.getType() + " on " + appliance.getClass().getName());

                        appliance.use();
                        break;
                    }
                }
            }
        }

        this.timePassed += 1;
    }
}
