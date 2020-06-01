
package se.kth.sem4.model.discounts;

import se.kth.sem4.model.Amount;

/**
 * This class represents a VIP discount, giving a 5% discount
 * if eligible.
 */
public class VIPCustomerDiscount implements DiscountEligibility{
    
    /**
     * Checks if the customer is eligible for the 5% VIP discount and
     * returns the new discounted price if eligible.
     * 
     * @param customerID the ID of the customer. For the VIP discount,
     * the customer ID must start with 55 to be eligible.
     * @param totalPrice The total price of the sale.
     * @return A new price with discount if eligible, the old price if not.
     */
    @Override
    public Amount checkDiscount(int customerID, Amount totalPrice){
        
        int customerIDIdentifier = (customerID/10000);
        
        if(customerIDIdentifier == 55){
        Amount fivePercent = new Amount(0.05);
        Amount totalPriceWithDiscount = totalPrice.minus(totalPrice.multiplied(fivePercent));
        return totalPriceWithDiscount;
        }
        return totalPrice; 
    }
}

