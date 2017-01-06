public class PowerShower extends Shower {
    public static final int TIME_ON = 1;

    public PowerShower(int electricityUse, int gasUse, int waterUse) {
        super(electricityUse, gasUse, waterUse, TIME_ON);
    }
}
