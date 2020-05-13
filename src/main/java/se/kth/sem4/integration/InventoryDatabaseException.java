package se.kth.sem4.integration;

/**
 * Thrown when an invalid item ID is entered.
 */
public class InventoryDatabaseException extends RuntimeException {

    /**
     * Creates an instance of the exception with a message.
     * 
     * @param message This is the message for the exception.
     */
    public InventoryDatabaseException(String message){
        super(message);
    }
    
    /**
     * Creates an instance of the exception with a message and a cause.
     * 
     * @param message The message of the exception.
     * @param cause The exception that caused this exception to be thrown.
     */
    public InventoryDatabaseException(String message, Exception cause){
        super (message, cause);
    }
    
}
