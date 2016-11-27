/**
 * Created by nikolabozhkov on 11/23/16.
 */
public abstract class Appliance extends TimeAffected {

    private State currentState;

    private int electricityUse;
    private int gasUse;
    private int waterUse;

    private Meter electricMeter;
    private Meter gasMeter;
    private Meter waterMeter;

    // timeOn represents time by 15 minute intervals i.e. 2 = 30 minutes
    private int timeOn;

    protected Appliance(int electricityUse, int gasUse, int waterUse, int timeOn) {
        super();
        this.electricityUse = electricityUse;
        this.gasUse = gasUse;
        this.waterUse = waterUse;
        this.timeOn = timeOn;
    }

    public int getElectricityUse() {
        return this.electricityUse;
    }

    public int getGasUse() {
        return this.gasUse;
    }

    public int getWaterUse() {
        return this.waterUse;
    }

    public State getCurrentState() {
        return this.currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;

        // Print the state of the appliance
        System.out.println(this.getClass().getName() + " is now " + currentState.toString());
    }

    public void setElectricMeter(Meter electricMeter) {
        this.electricMeter = electricMeter;
    }

    public void setGasMeter(Meter gasMeter) {
        this.gasMeter = gasMeter;
    }

    public void setWaterMeter(Meter waterMeter) {
        this.waterMeter = waterMeter;
    }

    public abstract ApplianceType getType();

    /*
     * Turns the appliance on and resets the ongoing timePassed if it was already on
     */
    public void use() {
        this.setCurrentState(State.ON);
        this.timePassed = 0;
    }

    @Override
    public void timePasses() {
        if (this.currentState == State.ON) {
            super.timePasses();

            // Only increment consumption if connected to meter
            if (this.electricMeter != null) {
                this.electricMeter.increaseConsumed(this.electricityUse);
            }

            if (this.gasMeter != null) {
                this.gasMeter.increaseConsumed(this.gasUse);
            }

            if (this.waterMeter != null) {
                this.waterMeter.increaseConsumed(this.waterUse);
            }

            // If the appliance finished it's task turn it off and reset the time since it's been on
            if (this.timePassed == this.timeOn) {
                this.setCurrentState(State.OFF);
                this.timePassed = 0;
            }
        }
    }
}
