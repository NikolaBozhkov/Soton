/**
 * Created by nikolabozhkov on 11/23/16.
 */
public class Dishwasher extends Appliance {
    public static final int TIME_ON = 6;

    public Dishwasher(int electricityUse, int gasUse, int waterUse) {
        super(electricityUse, gasUse, waterUse, TIME_ON);
    }

    @Override
    public ApplianceType getType() {
        return ApplianceType.DISHWASHER;
    }
}
