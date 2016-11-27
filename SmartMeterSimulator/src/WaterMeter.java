/**
 * Created by nikolabozhkov on 11/23/16.
 */
public class WaterMeter extends Meter {

    public WaterMeter(int initialConsumed, boolean canGenerate) {
        super(initialConsumed, canGenerate);
    }

    @Override
    public MeterType getType() {
        return MeterType.WATER;
    }
}
