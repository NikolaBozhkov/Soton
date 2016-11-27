/**
 * Created by nikolabozhkov on 11/23/16.
 */
public class GasMeter extends Meter {

    public GasMeter(int initialConsumed, boolean canGenerate) {
        super(initialConsumed, canGenerate);
    }

    @Override
    public MeterType getType() {
        return MeterType.GAS;
    }
}
