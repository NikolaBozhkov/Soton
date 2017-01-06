public class MeterFactory {
    public static Meter createMeter(MeterType type, String[] params) throws IllegalArgumentException {
        // Get param values or set them to default if not present
        int initialConsumption = params.length > 0 ? Integer.parseInt(params[0]) : Meter.DEFAULT_CONSUMED;
        boolean canGenerate = params.length > 1 ? Boolean.parseBoolean(params[1]) : Meter.DEFAULT_CAN_GENERATE;

        switch (type) {
            case ELECTRIC:
                return new ElectricMeter(initialConsumption, canGenerate);
            case GAS:
                return new GasMeter(initialConsumption, canGenerate);
            case WATER:
                return new WaterMeter(initialConsumption, canGenerate);
            default:
                throw new IllegalArgumentException("Invalid MeterType " + type.toString());
        }
    }
}
