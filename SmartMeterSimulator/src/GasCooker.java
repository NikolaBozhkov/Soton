/**
 * Created by nikolabozhkov on 11/23/16.
 */
public class GasCooker extends Cooker {
    public static final int TIME_ON = 4;
    public static final int DEFAULT_ELECTRICITY_USE = 0;
    public static final int DEFAULT_GAS_USE = 4;
    public static final int DEFAULT_WATER_USE = 0;

    public GasCooker() {
        this(DEFAULT_ELECTRICITY_USE);
    }

    public GasCooker(int electricityUse) {
        this(electricityUse, DEFAULT_GAS_USE);
    }

    public GasCooker(int electricityUse, int gasUse) {
        this(electricityUse, gasUse, DEFAULT_WATER_USE);
    }

    public GasCooker(int electricityUse, int gasUse, int waterUse) {
        super(electricityUse, gasUse, waterUse, TIME_ON);
    }
}
