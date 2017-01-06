public abstract class Shower extends Appliance {

    protected Shower(int electricityUse, int gasUse, int waterUse, int timeOn) {
        super(electricityUse, gasUse, waterUse, timeOn);
    }

    @Override
    public ApplianceType getType() {
        return ApplianceType.SHOWER;
    }
}
