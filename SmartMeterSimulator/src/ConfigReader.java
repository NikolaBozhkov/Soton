import sun.management.*;
import sun.nio.cs.StandardCharsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/**
 * Created by nikolabozhkov on 11/25/16.
 */
public class ConfigReader {

    public static void getHouseFromFile(String fileName) throws IOException {
        // Get the path of the file and read all lines
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);

        House house = null;

        for (String line : lines) {
            String[] inputArray = line.split(":");

            String command = "";
            String[] params = new String[0];

            if (inputArray.length != 0) {
                command = inputArray[0];
            }

            if (inputArray.length > 1) {
                params = inputArray[1].split(",");
            }

            // Variables that may be potentially created
            Appliance appliance = null;

            switch (command) {
                case "House":
                    house = new House();
                    break;
                case "ElectricMeter":
                    Meter electricMeter = MeterFactory.createMeter(MeterType.ELECTRIC, params);
                    break;
                case "GasMeter":
                    Meter gasMeter = MeterFactory.createMeter(MeterType.GAS, params);
                    break;
                case "WaterMeter":
                    Meter waterMeter = MeterFactory.createMeter(MeterType.WATER, params);
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
                    break;
            }

            // Only add elements to the house if it is created
            if (house != null) {
                // If an appliance was created add it to the house
                if (appliance != null) {
                    house.addAppliance(appliance);
                }
            }
        }
    }
}
