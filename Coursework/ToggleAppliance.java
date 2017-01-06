/**
 * Models an Appliance that can't turn itself off and is on forever when turned on
 * Using it toggles between ON and OFF
 */
public abstract class ToggleAppliance extends Appliance {
    public static final int TIME_ON = -1;

    public ToggleAppliance(int electricityUse, int gasUse, int waterUse) {
        super(electricityUse, gasUse, waterUse, TIME_ON);
    }

    @Override
    public void use() {
        if (this.getCurrentState() == State.ON) {
            this.setCurrentState(State.OFF);
        } else {
            this.setCurrentState(State.ON);
        }
    }
}
