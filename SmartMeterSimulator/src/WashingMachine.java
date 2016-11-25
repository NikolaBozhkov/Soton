/**
 * Created by nikolabozhkov on 11/23/16.
 */
public class WashingMachine extends Appliance {
    public static final int TIME_ON = 8;
    public static final int DEFAULT_ELECTRICITY_USE = 2;
    public static final int DEFAULT_GAS_USE = 0;
    public static final int DEFAULT_WATER_USE = 1;

    public WashingMachine() {
        this(DEFAULT_ELECTRICITY_USE);
    }

    public WashingMachine(int electricityUse) {
        this(electricityUse, DEFAULT_GAS_USE);
    }

    public WashingMachine(int electricityUse, int gasUse) {
        this(electricityUse, gasUse, DEFAULT_WATER_USE);
    }

    public WashingMachine(int electricityUse, int gasUse, int waterUse) {
        super(electricityUse, gasUse, waterUse, TIME_ON);
    }
}