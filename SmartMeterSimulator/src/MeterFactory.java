/**
 * Created by nikolabozhkov on 11/25/16.
 */
public class MeterFactory {
    public static Meter createMeter(MeterType type, String[] params) {
        Meter meter;

        // Get param values or set them to default if not present
        int initialConsumption = params.length > 0 ? Integer.parseInt(params[0]) : Meter.DEFAULT_CONSUMED;
        boolean canGenerate = params.length > 1 ? Boolean.parseBoolean(params[1]) : Meter.DEFAULT_CAN_GENERATE;

        switch (type) {
            case ELECTRIC:
                meter = new ElectricMeter(initialConsumption, canGenerate);
                break;
            case GAS:
                meter = new GasMeter(initialConsumption, canGenerate);
                break;
            case WATER:
                meter = new WaterMeter(initialConsumption, canGenerate);
                break;
            default:
                throw new IllegalArgumentException("Invalid MeterType " + type.toString());
        }

        return meter;
    }
}
