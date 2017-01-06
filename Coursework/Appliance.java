/**
 * Models a house appliance that can be connected to consumption meters and has an ON, OFF state
 * It is affected by time, which affects the state and the consumption that is written to the meters
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
        this.currentState = State.OFF;
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

    /**
     * Turns the appliance on and resets the ongoing timePassed if it was already on
     */
    public void use() {
        this.setCurrentState(State.ON);
        this.timePassed = 0;
    }

    /**
     * Adds consumption to the attached meters if turned on and turns off when on time is reached
     */
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

    /**
     * Creates a snapshot of the current Appliance state, how long it will be on for,
     * for how long it's usually on, and how much it's consumption is
     * @return Snapshot of the Appliance
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        String timeOn = this.timeOn == -1 ? "forever" : String.valueOf(this.timeOn);
        sb.append(this.getClass().getName() + ". Current state " + this.getCurrentState().toString() + ". On time - " + timeOn);

        if (this.getCurrentState() == State.ON) {
            int remainingTime = this.timeOn - this.timePassed;
            sb.append("\nON for " + this.timePassed + ". Time until OFF - " + remainingTime + ".");
        }

        sb.append("\nConsumptions: electricity - " + this.electricityUse + "; gas - " + this.gasUse + "; water - " + this.waterUse + ".");

        return sb.toString();
    }
}
