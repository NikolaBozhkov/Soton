/**
 * Created by nikolabozhkov on 11/23/16.
 */
public class NightLight extends ToggleAppliance {

    public NightLight(int electricityUse, int gasUse, int waterUse) {
        super(electricityUse, gasUse, waterUse);
    }

    @Override
    public ApplianceType getType() {
        return ApplianceType.NIGHT_LIGHT;
    }
}
