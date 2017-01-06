import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Models an abstract Person that is affected by time and has a list of Tasks
 * The Person has the ability to perform Tasks when their time comes
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

    /**
     * Performs all Tasks scheduled for this moment, only if an Appliance able to perform the Task is found.
     * Increments the passed time for the person(may differ from the house's)
     * Performed Tasks are deleted from the list of Tasks
     * @param appliances the House appliances
     */
    public void timePasses(List<Appliance> appliances) {
        Iterator<Task> taskIterator = this.tasks.iterator();

        while (taskIterator.hasNext()) {
            Task task = taskIterator.next();

            if (task.getStartTime() == this.timePassed) {
                // If an appliance that can perform the given task is found, use it and stop searching
                for (Appliance appliance : appliances) {
                    if (appliance.getType() == task.getTargetApplianceType()) {
                        // Print which person performed the task on which appliance
                        System.out.println(this.name + " performed task " + task.getType() + " on " + appliance.getClass().getName());

                        appliance.use();
                        taskIterator.remove();
                        break;
                    }
                }
            }
        }

        this.timePassed += 1;
    }

    /**
     * Creates a description of the person and the tasks that he/she currently contains
     * @return the Person's description
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.name + ". " + this.age + " years old. " + this.gender + ".\nTasks: ");

        if (this.tasks.size() == 0) {
            sb.append("NO TASKS.");
        }

        for (Task task : this.tasks) {
            sb.append("\n" + task.toString());
        }

        return sb.toString();
    }
}
