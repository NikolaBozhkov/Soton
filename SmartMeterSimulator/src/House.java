import java.util.List;
import java.util.ArrayList;

/**
 * Created by nikolabozhkov on 11/23/16.
 */
public class House extends TimeAffected {
    public static final int MAX_APPLIANCES = 25;
    public static final int DAY_TIME_PERIOD = 96;

    private List<Appliance> appliances;
    private List<Person> people;

    private Meter electricMeter;
    private Meter gasMeter;
    private Meter waterMeter;

    // Used to measure each days consumption without resetting the meters
    private int electricityConsumed;
    private int gasConsumed;
    private int waterConsumed;
    private int dayCount;

    public House() {
        super();
        this.appliances = new ArrayList<>();
        this.people = new ArrayList<>();
        this.electricityConsumed = 0;
        this.gasConsumed = 0;
        this.waterConsumed = 0;
        this.dayCount = 1;
    }

    /*
     * Returns whether the required meters for the appliance are connected to the house and if there is room for more appliances
     */
    private boolean canConnectAppliance(Appliance appliance) {
        boolean allMetersConnected = true;

        if (appliance.getElectricityUse() > 0 && this.electricMeter == null
                || appliance.getGasUse() > 0 && this.gasMeter == null
                || appliance.getWaterUse() > 0 && this.waterMeter == null) {
            allMetersConnected = false;
        }

        return allMetersConnected && this.appliances.size() < MAX_APPLIANCES;
    }

    /*
     * Assigns to given meter to the correct meter field by type
     * Overrides previously attached meter
     */
    public void addMeter(Meter meter) {
        switch (meter.getType()) {
            case ELECTRIC:
                this.electricMeter = meter;
                break;
            case GAS:
                this.gasMeter = meter;
                break;
            case WATER:
                this.waterMeter = meter;
                break;
        }
    }

    /*
     * Adds an appliance to the house, but ignores it if it cannot be connected
     */
    public void addAppliance(Appliance appliance) {
        if (this.canConnectAppliance(appliance)) {
            this.appliances.add(appliance);

            // Connect the required meters to the appliance
            if (appliance.getElectricityUse() > 0) {
                appliance.setElectricMeter(this.electricMeter);
            }

            if (appliance.getGasUse() > 0) {
                appliance.setGasMeter(this.gasMeter);
            }

            if (appliance.getWaterUse() > 0) {
                appliance.setWaterMeter(this.waterMeter);
            }
        }
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public void removeAppliance(Appliance appliance) {
        this.appliances.remove(appliance);
    }

    public int numAppliances() {
        return this.appliances.size();
    }

    @Override
    public void timePasses() {
        System.out.println(timePassed);

        for (TimeAffected appliance : this.appliances) {
            appliance.timePasses();
        }

        for (Person person : this.people) {
            person.timePasses(this.appliances);
        }

        super.timePasses();
    }

    /*
     * Begins an endless simulation, prints each day's consumption
     */
    public void go() {
        while (true) {
            try {
                this.timePasses();

                if (this.timePassed == DAY_TIME_PERIOD) {
                    // Get today's consumptions if connected to the appropriate meter
                    int todayElectricityConsumed = 0;
                    if (this.electricMeter != null) {
                        todayElectricityConsumed = this.electricMeter.getConsumed() - this.electricityConsumed;
                    }

                    int todayGasConsumed = 0;
                    if (this.gasMeter != null) {
                        todayGasConsumed = this.gasMeter.getConsumed() - this.gasConsumed;
                    }

                    int todayWaterConsumed = 0;
                    if (this.waterMeter != null) {
                        todayWaterConsumed = this.waterMeter.getConsumed() - this.waterConsumed;
                    }

                    // Print consumption for the day
                    System.out.println("----- DAY " + this.dayCount + " -----");
                    System.out.println("Electricity consumed - " + todayElectricityConsumed);
                    System.out.println("Gas consumed - " + todayGasConsumed);
                    System.out.println("Water consumed - " + todayWaterConsumed);

                    this.electricityConsumed += todayElectricityConsumed;
                    this.gasConsumed += todayGasConsumed;
                    this.waterConsumed += todayWaterConsumed;
                    this.dayCount += 1;
                    this.timePassed = 0;
                }

                Thread.sleep(300);
            } catch (InterruptedException e) { }
        }
    }
}
