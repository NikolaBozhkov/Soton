import java.util.List;
import java.util.ArrayList;

/**
 * Models a House that can contains Appliances and People, and is connected to consumption meters
 * Can run an endless simulation, showing each day's consumption
 */
public class House extends TimeAffected {
    private static final int STATE_LOG_INTERVAL = 16;
    public static final int MAX_APPLIANCES = 25;
    public static final int DAY_TIME_PERIOD = 96;

    private HouseLogger logger;

    // Used to measure each days consumption without resetting the meters
    private int electricityConsumed;
    private int gasConsumed;
    private int waterConsumed;
    protected int dayCount;

    protected Meter electricMeter;
    protected Meter gasMeter;
    protected Meter waterMeter;

    protected List<Appliance> appliances;
    protected List<Person> people;

    public House(HouseLogger logger) {
        super();
        this.logger = logger;
        this.appliances = new ArrayList<>();
        this.people = new ArrayList<>();
        this.electricityConsumed = 0;
        this.gasConsumed = 0;
        this.waterConsumed = 0;
        this.dayCount = 1;
    }

    /**
     * Checks whether the appliance can be connected to it's required meters
     * and if there is enough space for more appliances
     * @param appliance
     * @return if it is possible to add the appliance
     */
    private boolean canAddAppliance(Appliance appliance) {
        boolean allMetersConnected = true;

        if (appliance.getElectricityUse() > 0 && this.electricMeter == null
                || appliance.getGasUse() > 0 && this.gasMeter == null
                || appliance.getWaterUse() > 0 && this.waterMeter == null) {
            allMetersConnected = false;
        }

        return allMetersConnected && this.appliances.size() < MAX_APPLIANCES;
    }

    /**
     * Assigns the given meter to the correct meter field by type
     * Overrides previously attached meter
     * @param meter meter to add
     */
    public void addMeter(Meter meter) {
        // Using toString because specs needed getType to return a string
        if (meter.getType().toString().equals(MeterType.ELECTRIC.toString())) {
            this.electricMeter = meter;
        } else if (meter.getType().toString().equals(MeterType.GAS.toString())) {
            this.gasMeter = meter;
        } else if (meter.getType().toString().equals(MeterType.WATER.toString())) {
            this.waterMeter = meter;
        }
    }

    /**
     * Adds an appliance to the house, but ignores it if it cannot be connected
     * @param appliance appliance to add
     */
    public void addAppliance(Appliance appliance) {
        if (this.canAddAppliance(appliance)) {
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

    /**
     * Prints the passed time and calls timePasses for appliances and people
     */
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

    /**
     * Begins an endless simulation, prints each day's consumption
     */
    public void go() {
        while (this.dayCount < 2) {
            try {
                this.timePasses();

                // Every 4 hours log the current state
                if (this.timePassed % STATE_LOG_INTERVAL == 0) {
                    this.logger.logState(this);
                }

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

                    // Update logs file
                    logger.logDailyConsumption(this.dayCount, todayElectricityConsumed, todayGasConsumed, todayWaterConsumed);

                    this.electricityConsumed += todayElectricityConsumed;
                    this.gasConsumed += todayGasConsumed;
                    this.waterConsumed += todayWaterConsumed;
                    this.dayCount += 1;
                    this.timePassed = 0;
                }

                Thread.sleep(0);
            } catch (InterruptedException e) { }
        }
    }
}
