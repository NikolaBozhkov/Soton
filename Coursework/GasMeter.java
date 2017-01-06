public class GasMeter extends Meter {

    public GasMeter(int initialConsumed, boolean canGenerate) {
        super(initialConsumed, canGenerate);
    }

    @Override
    public String getType() {
        return MeterType.GAS.toString();
    }
}
