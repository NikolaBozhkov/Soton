public class WaterMeter extends Meter {

    public WaterMeter(int initialConsumed, boolean canGenerate) {
        super(initialConsumed, canGenerate);
    }

    @Override
    public String getType() {
        return MeterType.WATER.toString();
    }
}
