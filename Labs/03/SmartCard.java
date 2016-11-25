public class SmartCard {
    // Declare class member variables accessible only to the class
    private String owner;
    
    // Make every new card to be a student's card
    private boolean staffStatus = false;

    public SmartCard(String owner) {
        // Using "this" because of high-quality programming code standards
        // And readability
        this.owner = owner;
    }
    
    // Declare methods to manipulate the card's data
    public String getOwner() {
        return this.owner;
    }
    
    public boolean isStaff() {
        return this.staffStatus;
    }
    
    public void setStaff(boolean status) {
        this.staffStatus = status;
    }
}
