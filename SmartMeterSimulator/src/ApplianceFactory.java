/**
 * Created by nikolabozhkov on 11/25/16.
 */
public class ApplianceFactory {

    public static Appliance createAppliance(ApplianceType type, String[] params) {
        // Parse usage parameters or set to default value if non are provided
        int electricityUse = params.length > 0 ? Integer.parseInt(params[0]) : type.DEFAULT_ELECTRICITY_USE;
        int gasUse = params.length > 1 ? Integer.parseInt(params[1]) : type.DEFAULT_GAS_USE;
        int waterUse = params.length > 2 ? Integer.parseInt(params[2]) : type.DEFAULT_WATER_USE;

        // Return an instance of the appropriate class or throw exception if type is not recognized
        switch (type) {
            case BOILER:
                return new Boiler(electricityUse, gasUse, waterUse);
            case DISHWASHER:
                return new Dishwasher(electricityUse, gasUse, waterUse);
            case ELECTRIC_COOKER:
                return new ElectricCooker(electricityUse, gasUse, waterUse);
            case GAS_COOKER:
                return  new GasCooker(electricityUse, gasUse, waterUse);
            case ELECTRIC_SHOWER:
                return new ElectricShower(electricityUse, gasUse, waterUse);
            case POWER_SHOWER:
                return new PowerShower(electricityUse, gasUse, waterUse);
            case KETTLE:
                return new Kettle(electricityUse, gasUse, waterUse);
            case NIGHT_LIGHT:
                return new NightLight(electricityUse, gasUse, waterUse);
            case REFRIGERATOR:
                return new Refrigerator(electricityUse, gasUse, waterUse);
            case TV:
                return new TV(electricityUse, gasUse, waterUse);
            case WASHING_MACHINE:
                return new WashingMachine(electricityUse, gasUse, waterUse);
            default:
                throw new IllegalArgumentException("Invalid ApplianceType " + type.toString());
        }
    }
}
