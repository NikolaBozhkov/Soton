public class JetPlane extends Transport implements Refuelable {

    /**
     * Puts the plane in the air
     */
    public void takeOff() {

    }

    /**
     * Puts the plane on the ground
     */
    public void land() {

    }

    /**
     * Returns the airport plane roads
     */
    public void getAirportRoadMap() {

    }

    /**
     * Moves the plane, ignoring any terrain if it's in the air
     */
    @Override
    public void move() {
        // if not in the air moves considering airport roads
    }

    /**
     * Refills the tank in a jet plane specific way
     */
    @Override
    public void refillTank() {
    }
}
