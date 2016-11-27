/**
 * Created by nikolabozhkov on 11/23/16.
 */
public abstract class Meter {
    public static final int DEFAULT_CONSUMED = 0;
    public static final boolean DEFAULT_CAN_GENERATE = false;

    private int consumed;
    private int generated;
    private boolean canGenerate;

    public Meter(int initialConsumed, boolean canGenerate) {
        this.generated = 0;
        this.consumed = initialConsumed;
        this.canGenerate = canGenerate;
    }

    public int getConsumed() {
        return this.consumed;
    }

    public int getGenerated() {
        return this.generated;
    }

    public boolean canGenerate() {
        return this.canGenerate;
    }

    public abstract MeterType getType();

    public void incrementConsumed() {
        this.consumed += 1;
    }

    public void increaseConsumed(int consumption) {
        this.consumed += consumption;
    }

    public void incrementGenerated() {
        if (this.canGenerate) {
            this.generated += 1;
        }
    }
}
