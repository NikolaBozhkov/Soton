public abstract class RoadVehicle extends Transport {

    /**
     * Show a network of roads the vehicle can move through
     */
    public abstract void getAvailableRoads();

    /**
     * Moves the vehicle considering the available roads
     */
    @Override
    public void move() {
        // Use available roads for moving
        this.getAvailableRoads();
    }
}
