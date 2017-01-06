public class GasCooker extends Cooker {
    public static final int TIME_ON = 4;

    public GasCooker(int electricityUse, int gasUse, int waterUse) {
        super(electricityUse, gasUse, waterUse, TIME_ON);
    }
}
