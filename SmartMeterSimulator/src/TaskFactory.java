/**
 * Created by nikolabozhkov on 11/27/16.
 */
public class TaskFactory {

    public static Task createTask(String command, int startTime) {
        switch (command) {
            case "DoWashing":
                return new Task(TaskType.DO_WASHING, ApplianceType.WASHING_MACHINE, startTime);
            case "Boil":
                return new Task(TaskType.BOIL, ApplianceType.KETTLE, startTime);
            case "WashDishes":
                return new Task(TaskType.WASH_DISHES, ApplianceType.DISHWASHER, startTime);
            case "Cook":
                return new Task(TaskType.COOK, ApplianceType.COOKER, startTime);
            case "Shower":
                return new Task(TaskType.SHOWER, ApplianceType.SHOWER, startTime);
            case "TurnOnTV":
                return new Task(TaskType.TURN_ON, ApplianceType.TV, startTime);
            case "TurnOffTV":
                return new Task(TaskType.TURN_OFF, ApplianceType.TV, startTime);
            case "TurnOnBoiler":
                return new Task(TaskType.TURN_ON, ApplianceType.BOILER, startTime);
            case "TurnOffBoiler":
                return new Task(TaskType.TURN_OFF, ApplianceType.BOILER, startTime);
            case "TurnOnNightLight":
                return new Task(TaskType.TURN_ON, ApplianceType.NIGHT_LIGHT, startTime);
            case "TurnOffNightLight":
                return new Task(TaskType.TURN_OFF, ApplianceType.NIGHT_LIGHT, startTime);
            default:
                throw new IllegalArgumentException("Command " + command + " was not recognized.");
        }
    }
}
