/**
 * Models a Task of given type and targeted at some House Appliance Type
 * It can be started at a given time
 */
public class Task {

    private TaskType type;
    private ApplianceType targetApplianceType;

    private int startTime;

    public Task(TaskType type, ApplianceType targetApplianceType, int startTime) {
        this.type = type;
        this.targetApplianceType = targetApplianceType;
        this.startTime = startTime;
    }

    public TaskType getType() {
        return this.type;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public ApplianceType getTargetApplianceType() {
        return this.targetApplianceType;
    }

    @Override
    public String toString() {
        return this.type.toString() + " aimed at "
                + this.targetApplianceType.toString() + " scheduled for " + this.startTime;
    }
}
