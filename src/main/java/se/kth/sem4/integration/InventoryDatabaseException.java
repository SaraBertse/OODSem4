package se.kth.sem4.integration;

/**
 * Thrown when an invalid item ID is entered.
 */
public class InventoryDatabaseException extends RuntimeException {

    /**
     * Creates an instance of the exception.
     */
    public InventoryDatabaseException(String message){
        super(message);
    }
    
    //This is new
    public InventoryDatabaseException(String message, Exception cause){
        super (message, cause);
    }
    
}
