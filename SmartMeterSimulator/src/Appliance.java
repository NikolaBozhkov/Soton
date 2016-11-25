import java.util.HashSet;

/**
 * Created by nikolabozhkov on 11/23/16.
 */
public abstract class Appliance extends TimeAffected {

    protected int electricityUse;
    protected int gasUse;
    protected int waterUse;

    protected ElectricMeter electricMeter;
    protected GasMeter gasMeter;
    protected WaterMeter waterMeter;

    // timeOn represents time by 15 minute intervals i.e. 2 = 30 minutes
    protected int timeOn;
    protected State currentState;

    protected Appliance(int electricityUse, int gasUse, int waterUse, int timeOn) {
        super();
        this.electricityUse = electricityUse;
        this.gasUse = gasUse;
        this.waterUse = waterUse;
        this.timeOn = timeOn;
    }

    public void setElectricMeter(ElectricMeter electricMeter) {
        this.electricMeter = electricMeter;
    }

    public void setGasMeter(GasMeter gasMeter) {
        this.gasMeter = gasMeter;
    }

    public void setWaterMeter(WaterMeter waterMeter) {
        this.waterMeter = waterMeter;
    }

    @Override
    public void timePasses() {
        if (this.currentState == State.ON) {
            super.timePasses();

            this.electricMeter.incrementConsumed(this.electricityUse);
            this.gasMeter.incrementConsumed(this.gasUse);
            this.waterMeter.incrementConsumed(this.waterUse);
//            for (Meter meter : this.meters) {
//                // Find which type of meter this is and increment by appropriate type of consumption
//                if (meter.getType().equals(MeterType.ELECTRIC.toString())) {
//                    meter.incrementConsumed(this.electricityUse);
//                } else if (meter.getType().equals((MeterType.GAS.toString()))) {
//                    meter.incrementConsumed(this.gasUse);
//                } else if (meter.getType().equals(MeterType.WATER.toString())) {
//                    meter.incrementConsumed(this.waterUse);
//                }
//            }
        }
    }
}
