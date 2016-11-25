/**
 * Created by nikolabozhkov on 11/23/16.
 */
public class ElectricCooker extends Cooker {
    public static final int TIME_ON = 4;
    public static final int DEFAULT_ELECTRICITY_USE = 5;
    public static final int DEFAULT_GAS_USE = 0;
    public static final int DEFAULT_WATER_USE = 0;

    public ElectricCooker() {
        this(DEFAULT_ELECTRICITY_USE);
    }

    public ElectricCooker(int electricityUse) {
        this(electricityUse, DEFAULT_GAS_USE);
    }

    public ElectricCooker(int electricityUse, int gasUse) {
        this(electricityUse, gasUse, DEFAULT_WATER_USE);
    }

    public ElectricCooker(int electricityUse, int gasUse, int waterUse) {
        super(electricityUse, gasUse, waterUse, TIME_ON);
    }
}
