/**
 * Created by nikolabozhkov on 11/23/16.
 */
public class ElectricCooker extends Cooker {
    public static final int TIME_ON = 4;

    public ElectricCooker(int electricityUse, int gasUse, int waterUse) {
        super(electricityUse, gasUse, waterUse, TIME_ON);
    }
}
