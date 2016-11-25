public class CardLock {
    // Declare class member variables accessible only to the class
    private SmartCard lastCardSeen;
    
    // Set the default value of the student's access to false
    private boolean studentAccess = false;
    
    // Declare methods that handle the interaction with the lock
    public void swipeCard(SmartCard card) {
        // Save the swiped card as the last card seen
        this.lastCardSeen = card;
    }
    
    public SmartCard getLastCardSeen() {
        return this.lastCardSeen;
    }
    
    public boolean isUnlocked() {
        // If no card was swiped since the lock was created then it is still locked
        if (this.lastCardSeen != null) {
            // If there is a card and students have access then returns true
            // If students don't have access, check if the last card was a staff's member
            return this.studentAccess || this.lastCardSeen.isStaff();
        }
        
        return false;
    }
    
    public void toggleStudentAccess() {
        // Changes the current value to the opposite
        this.studentAccess = !this.studentAccess;
    }
}