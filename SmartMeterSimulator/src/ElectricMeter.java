/**
 * Created by nikolabozhkov on 11/23/16.
 */
public class ElectricMeter extends Meter {

    public ElectricMeter(int initialConsumption, boolean canGenerate) {
        super(initialConsumption, canGenerate);
    }

    @Override
    public MeterType getType() {
        return MeterType.ELECTRIC;
    }
}
