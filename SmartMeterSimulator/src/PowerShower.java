/**
 * Created by nikolabozhkov on 11/23/16.
 */
public class PowerShower extends Shower {
    public static final int TIME_ON = 1;
    public static final int DEFAULT_ELECTRICITY_USE = 0;
    public static final int DEFAULT_GAS_USE = 10;
    public static final int DEFAULT_WATER_USE = 5;

    public PowerShower() {
        this(DEFAULT_ELECTRICITY_USE);
    }

    public PowerShower(int electricityUse) {
        this(electricityUse, DEFAULT_GAS_USE);
    }

    public PowerShower(int electricityUse, int gasUse) {
        this(electricityUse, gasUse, DEFAULT_WATER_USE);
    }

    public PowerShower(int electricityUse, int gasUse, int waterUse) {
        super(electricityUse, gasUse, waterUse, TIME_ON);
    }
}
