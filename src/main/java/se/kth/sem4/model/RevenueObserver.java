
package se.kth.sem4.model;

/**
 * This interface receives notifications every time a new payment comes in. Any class
 * that needs that functionality implements this interface.
 */
public interface RevenueObserver {
    
    /**
     * Registers that a new payment has come in. 
     * 
     * @param totalPrice The total price of the sale.
     */
    void newPayment(Amount totalPrice);
    
}
