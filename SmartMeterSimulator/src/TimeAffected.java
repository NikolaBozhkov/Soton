/**
 * Created by nikolabozhkov on 11/23/16.
 */
public abstract class TimeAffected {
    protected int timePassed;

    protected TimeAffected() {
        this.timePassed = 0;
    }

    public void timePasses() {
        this.timePassed += 1;
    }
}
