public class TaskFactory {

    /**
     * Creates a Task of some TaskType and target ApplianceType based on the command given.
     * @param command one of the following commands: DoWashing, Boil, WashDishes, Cook, Shower,
     *                TurnOn/TurnOff + TV/Boiler/NightLight
     * @param startTime time the Task should be performed
     * @return the newly created Task
     * @throws IllegalArgumentException
     */
    public static Task createTask(String command, int startTime) throws IllegalArgumentException {
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
