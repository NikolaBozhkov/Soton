/**
 * Created by nikolabozhkov on 11/25/16.
 */
public enum ApplianceType {
    BOILER(0, 1, 0),
    ELECTRIC_COOKER(5, 0, 0),
    GAS_COOKER(0, 4, 0),
    DISHWASHER(2, 0, 1),
    ELECTRIC_SHOWER(12, 0, 4),
    POWER_SHOWER(0, 10, 5),
    KETTLE(20, 0, 1),
    NIGHT_LIGHT(1, 0, 0),
    REFRIGERATOR(1, 0, 0),
    TV(1, 0, 0),
    WASHING_MACHINE(2, 0, 1),
    COOKER(0, 0, 0),
    SHOWER(0, 0, 0);

    public final int DEFAULT_ELECTRICITY_USE;
    public final int DEFAULT_GAS_USE;
    public final int DEFAULT_WATER_USE;

    ApplianceType(int electricityUse, int gasUse, int waterUse) {
        this.DEFAULT_ELECTRICITY_USE = electricityUse;
        this.DEFAULT_GAS_USE = gasUse;
        this.DEFAULT_WATER_USE = waterUse;
    }
}
