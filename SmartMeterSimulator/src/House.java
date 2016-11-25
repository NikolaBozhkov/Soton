import java.util.ArrayList;

/**
 * Created by nikolabozhkov on 11/23/16.
 */
public class House extends TimeAffected{
    public static final int MAX_APPLIANCES = 25;
    public static final int DAY_TIME_PERIOD = 96;

    private ArrayList<Appliance> appliances;
    private ArrayList<Person> people;

    public House() {
        super();
        this.appliances = new ArrayList<>();
    }

    public void addMeter(Meter meter) {

    }

    public void addAppliance(Appliance appliance) {
        if (this.appliances.size() < MAX_APPLIANCES) {
            this.appliances.add(appliance);
        }
    }

    public void removeAppliance(Appliance appliance) {
        this.appliances.remove(appliance);
    }

    public int numAppliances() {
        return this.appliances.size();
    }

    @Override
    public void timePasses() {
        super.timePasses();

        for (TimeAffected appliance : this.appliances) {
            appliance.timePasses();
        }

        for (TimeAffected person : this.people) {
            person.timePasses();
        }
    }

    public void go() {
        try {
            Thread.sleep(500);
            this.timePasses();
        } catch (InterruptedException e) { }
    }
}
