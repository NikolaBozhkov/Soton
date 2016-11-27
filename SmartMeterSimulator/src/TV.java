/**
 * Created by nikolabozhkov on 11/23/16.
 */
public class TV extends ToggleAppliance {

    public TV(int electricityUse, int gasUse, int waterUse) {
        super(electricityUse, gasUse, waterUse);
    }

    @Override
    public ApplianceType getType() {
        return ApplianceType.TV;
    }
}
