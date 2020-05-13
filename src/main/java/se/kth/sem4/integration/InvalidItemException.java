package se.kth.sem4.integration;

/**
 * Thrown when an invalid item ID is entered.
 */
public class InvalidItemException extends Exception {

    /**
     * Creates an instance of the exception.
     */
    public InvalidItemException(String message){
        super (message);
    }
    
    //This is new
    
     public InvalidItemException(Exception cause){
        super ("No item exists with that item ID, please enter a valid item ID.", cause);
    }
}
