import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/**
 * Declares functionality for reading a file and parsing it to a House with Appliances and People
 */
public class ConfigReader {

    /**
     * Parses a House in the following format from a .txt file
     * House - House:
     * Meter - type:[start value, can generate]
     * Appliance - type:[electric consumption, gas consumption, water consumption]
     * Person - Person:name,age,gender
     * Task - task:startTime
     * Parameters in square brackets[] are optional
     * @param fileName the path of the file that contains the configuration
     * @return House object created from the config commands
     * @throws IOException
     */
    public static House getHouseFromFile(String fileName) throws IOException {
        // Get the path of the file and read all lines
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);

        House house = null;

        // The person that will need to execute tasks
        Person lastPerson = null;

        for (String line : lines) {
            String[] inputArray = line.split(":");

            // Start with an empty command and parameter array
            String command = "";
            String[] params = new String[0];

            // If a command and a params list exist put them in their variables
            if (inputArray.length != 0) {
                command = inputArray[0];
            }

            if (inputArray.length > 1) {
                params = inputArray[1].split(",");
            }

            // Variables that may be potentially created
            Meter meter = null;
            Appliance appliance = null;
            Person person = null;
            Task task = null;

            switch (command) {
                case "House":
                    house = new House(new HouseLogger("houseLogs.txt"));
                    break;
                case "ElectricMeter":
                    meter = MeterFactory.createMeter(MeterType.ELECTRIC, params);
                    break;
                case "GasMeter":
                    meter = MeterFactory.createMeter(MeterType.GAS, params);
                    break;
                case "WaterMeter":
                    meter = MeterFactory.createMeter(MeterType.WATER, params);
                    break;
                case "Boiler":
                    appliance = ApplianceFactory.createAppliance(ApplianceType.BOILER, params);
                    break;
                case "Dishwasher":
                    appliance = ApplianceFactory.createAppliance(ApplianceType.DISHWASHER, params);
                    break;
                case "ElectricShower":
                    appliance = ApplianceFactory.createAppliance(ApplianceType.ELECTRIC_SHOWER, params);
                    break;
                case "PowerShower":
                    appliance = ApplianceFactory.createAppliance(ApplianceType.POWER_SHOWER, params);
                    break;
                case "ElectricCooker":
                    appliance = ApplianceFactory.createAppliance(ApplianceType.ELECTRIC_COOKER, params);
                    break;
                case "GasCooker":
                    appliance = ApplianceFactory.createAppliance(ApplianceType.GAS_COOKER, params);
                    break;
                case "Kettle":
                    appliance = ApplianceFactory.createAppliance(ApplianceType.KETTLE, params);
                    break;
                case "NightLight":
                    appliance = ApplianceFactory.createAppliance(ApplianceType.NIGHT_LIGHT, params);
                    break;
                case "Refrigerator":
                    appliance = ApplianceFactory.createAppliance(ApplianceType.REFRIGERATOR, params);
                    break;
                case "TV":
                    appliance = ApplianceFactory.createAppliance(ApplianceType.TV, params);
                    break;
                case "WashingMachine":
                    appliance = ApplianceFactory.createAppliance(ApplianceType.WASHING_MACHINE, params);
                    break;
                case "Person":
                    // Check if all Person parameters have been provided
                    if (params.length > 2) {
                        String name = params[0];
                        String gender = params[2];
                        int age = Integer.parseInt(params[1]);

                        if (age < 18) {
                            person = new Child(name, age, gender);
                        } else {
                            person = new GrownUp(name, age, gender);
                        }
                    }

                    break;
                default:
                    // Consider that command is a task, since it is not anything else
                    if (params.length > 0) {
                        int startTime = Integer.parseInt(params[0]);
                        task = TaskFactory.createTask(command, startTime);
                    }
            }

            // Only add elements to the house if it is created
            if (house != null) {
                // If a meter was created add it to the house
                if (meter != null) {
                    house.addMeter(meter);
                }

                // If an appliance was created add it to the house
                if (appliance != null) {
                    house.addAppliance(appliance);
                }

                // If a person was created add it to the house
                if (person != null) {
                    lastPerson = person;
                    house.addPerson(person);
                }

                // If a task was created add it to the last person
                if (task != null) {
                    lastPerson.addTask(task);
                }
            }
        }

        return house;
    }
}
