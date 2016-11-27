/**
 * Created by nikolabozhkov on 11/23/16.
 */
public abstract class Cooker extends Appliance {

    protected Cooker(int electricityUse, int gasUse, int waterUse, int timeOn) {
        super(electricityUse, gasUse, waterUse, timeOn);
    }

    @Override
    public ApplianceType getType() {
        return ApplianceType.COOKER;
    }
}
