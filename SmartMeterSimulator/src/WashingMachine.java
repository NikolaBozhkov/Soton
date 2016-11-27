/**
 * Created by nikolabozhkov on 11/23/16.
 */
public class WashingMachine extends Appliance {
    public static final int TIME_ON = 8;

    public WashingMachine(int electricityUse, int gasUse, int waterUse) {
        super(electricityUse, gasUse, waterUse, TIME_ON);
    }

    @Override
    public ApplianceType getType() {
        return ApplianceType.WASHING_MACHINE;
    }
}
