/**
 * Created by nikolabozhkov on 11/23/16.
 */
public abstract class Meter {
    public static final int DEFAULT_CONSUMED = 0;
    public static final boolean DEFAULT_CAN_GENERATE = false;

    protected int consumed;
    protected int generated;
    protected boolean canGenerate;

    public Meter() {
        this(0);
    }

    public Meter(int initialConsumed) {
        this(initialConsumed, false);
    }

    public Meter(int initialConsumed, boolean canGenerate) {
        this.generated = 0;
        this.consumed = initialConsumed;
        this.canGenerate = canGenerate;
    }

    public double getConsumed() {
        return this.consumed;
    }

    public double getGenerated() {
        return this.generated;
    }

    public boolean canGenerate() {
        return this.canGenerate;
    }

    public abstract String getType();

    public void incrementConsumed() {
        this.incrementConsumed(1);
    }

    public void incrementConsumed(int consumption) {
        this.consumed += consumption;
    }

    public void incrementGenerated() {
        if (this.canGenerate) {
            this.generated += 1;
        }
    }
}
