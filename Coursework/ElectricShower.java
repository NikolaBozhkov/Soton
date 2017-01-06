public class ElectricShower extends Shower {
    public static final int TIME_ON = 1;

    public ElectricShower(int electricityUse, int gasUse, int waterUse) {
        super(electricityUse, gasUse, waterUse, TIME_ON);
    }
}
