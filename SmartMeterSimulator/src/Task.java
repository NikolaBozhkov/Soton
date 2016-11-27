/**
 * Created by nikolabozhkov on 11/26/16.
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
}
