/**
 * Created by nikolabozhkov on 11/23/16.
 */
public class Kettle extends Appliance {
    public static final int TIME_ON = 1;
    public static final int DEFAULT_ELECTRICITY_USE = 20;
    public static final int DEFAULT_GAS_USE = 0;
    public static final int DEFAULT_WATER_USE = 1;

    public Kettle() {
        this(DEFAULT_ELECTRICITY_USE);
    }

    public Kettle(int electricityUse) {
        this(electricityUse, DEFAULT_GAS_USE);
    }

    public Kettle(int electricityUse, int gasUse) {
        this(electricityUse, gasUse, DEFAULT_WATER_USE);
    }

    public Kettle(int electricityUse, int gasUse, int waterUse) {
        super(electricityUse, gasUse, waterUse, TIME_ON);
    }
}
