/**
 * Created by nikolabozhkov on 11/23/16.
 */
public class Refrigerator extends Appliance {
    public static final int TIME_ON = -1;

    public Refrigerator(int electricityUse, int gasUse, int waterUse) {
        super(electricityUse, gasUse, waterUse, TIME_ON);
        this.setCurrentState(State.ON);
    }

    @Override
    public ApplianceType getType() {
        return ApplianceType.REFRIGERATOR;
    }
}
