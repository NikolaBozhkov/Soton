/**
 * Created by nikolabozhkov on 11/23/16.
 */
public class Kettle extends Appliance {
    public static final int TIME_ON = 1;

    public Kettle(int electricityUse, int gasUse, int waterUse) {
        super(electricityUse, gasUse, waterUse, TIME_ON);
    }

    @Override
    public ApplianceType getType() {
        return ApplianceType.KETTLE;
    }
}
