/**
 * Models a consumption Meter that has a type of ELECTRIC, GAS or WATER
 * Can be tagged to generate resource
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

    public abstract String getType();

    public void incrementConsumed() {
        this.consumed += 1;
    }

    public void increaseConsumed(int consumption) {
        this.consumed += consumption;
    }

    /**
     * Increments the generated resource, only if able to generate
     */
    public void incrementGenerated() {
        if (this.canGenerate) {
            this.generated += 1;
        }
    }
}
