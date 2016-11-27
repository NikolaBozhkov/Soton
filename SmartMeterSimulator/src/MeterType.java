/**
 * Created by nikolabozhkov on 11/23/16.
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
    public String toString() {
        return this.text;
    }
}
