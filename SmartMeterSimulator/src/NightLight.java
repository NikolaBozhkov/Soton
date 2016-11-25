/**
 * Created by nikolabozhkov on 11/23/16.
 */
public class NightLight extends ToggleAppliance {
    public static final int DEFAULT_ELECTRICITY_USE = 1;
    public static final int DEFAULT_GAS_USE = 0;
    public static final int DEFAULT_WATER_USE = 0;

    public NightLight() {
        this(DEFAULT_ELECTRICITY_USE);
    }

    public NightLight(int electricityUse) {
        this(electricityUse, DEFAULT_GAS_USE);
    }

    public NightLight(int electricityUse, int gasUse) {
        this(electricityUse, gasUse, DEFAULT_WATER_USE);
    }

    public NightLight(int electricityUse, int gasUse, int waterUse) {
        super(electricityUse, gasUse, waterUse);
    }
}
