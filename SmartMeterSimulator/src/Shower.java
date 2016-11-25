/**
 * Created by nikolabozhkov on 11/23/16.
 */
public abstract class Shower extends Appliance {

    protected Shower(int electricityUse, int gasUse, int waterUse, int timeOn) {
        super(electricityUse, gasUse, waterUse, timeOn);
    }

    public void shower() {

    }
}
