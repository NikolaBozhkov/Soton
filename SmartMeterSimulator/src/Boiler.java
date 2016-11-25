/**
 * Created by nikolabozhkov on 11/23/16.
 */
public class Boiler extends ToggleAppliance {
    public static final int DEFAULT_ELECTRICITY_USE = 0;
    public static final int DEFAULT_GAS_USE = 1;
    public static final int DEFAULT_WATER_USE = 0;

    public Boiler() {
        this(DEFAULT_ELECTRICITY_USE);
    }

    public Boiler(int electricityUse) {
        this(electricityUse, DEFAULT_GAS_USE);
    }

    public Boiler(int electricityUse, int gasUse) {
        this(electricityUse, gasUse, DEFAULT_WATER_USE);
    }

    public Boiler(int electricityUse, int gasUse, int waterUse) {
        super(electricityUse, gasUse, waterUse);
    }
}
