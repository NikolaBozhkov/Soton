public class Refrigerator extends Appliance {
    public static final int TIME_ON = -1;

    /**
     * Sets the currentState to ON, cannot be turned OFF
     * @param electricityUse
     * @param gasUse
     * @param waterUse
     */
    public Refrigerator(int electricityUse, int gasUse, int waterUse) {
        super(electricityUse, gasUse, waterUse, TIME_ON);
        this.setCurrentState(State.ON);
    }

    @Override
    public ApplianceType getType() {
        return ApplianceType.REFRIGERATOR;
    }
}
