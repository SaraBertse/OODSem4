package se.kth.sem4.integration;

/**
 * Thrown when an invalid item ID is entered.
 */
public class InvalidItemException extends Exception {

    /**
     * Creates an instance of the exception with a message.
     * 
     * @param message This is the message for the exception.
     */
    public InvalidItemException(String message){
        super (message);
    }
    
    /**
     * Creates an instance of the exception with the cause.
     * 
     * @param cause The exception that caused this exception to be thrown.
     */
     public InvalidItemException(Exception cause){
        super ("No item exists with that item ID, please enter a valid item ID.", cause);
    }
}
