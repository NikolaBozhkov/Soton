public class Boiler extends ToggleAppliance {

    public Boiler(int electricityUse, int gasUse, int waterUse) {
        super(electricityUse, gasUse, waterUse);
    }

    @Override
    public ApplianceType getType() {
        return ApplianceType.BOILER;
    }
}
