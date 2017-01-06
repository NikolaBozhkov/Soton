/**
 * Holds different Meter types and their string respresentations
 */
public enum MeterType {
    GAS("gas"),
    WATER("water"),
    ELECTRIC("electric");

    private final String text;

    MeterType(final String text) {
        this.text = text;
    }

    @Override
    public final String toString() {
        return this.text;
    }
}
