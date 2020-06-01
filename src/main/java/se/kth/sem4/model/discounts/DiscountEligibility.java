
package se.kth.sem4.model.discounts;

import se.kth.sem4.model.Amount;

/**
 * An object that checks for discount eligibility and calculates price
 * after discount.
 */
public interface DiscountEligibility {
    
    /**
     * Checks if the customer ID is valid for a discount. If it is, a new
     * discounted price is calculated.
     * 
     * @param customerID The customer ID.
     * @param totalPrice The total price of the sale.
     * @return If the discount is granted, a new discounted price is returned.
     * If it's not granted (customer ID not eligible for discount) the old price
     * is returned.
     */
    Amount checkDiscount(int customerID, Amount totalPrice);
}
