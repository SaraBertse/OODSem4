/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sem4.model.discounts;

import se.kth.sem4.model.Amount;

/**
 * This class represents a new customer discount, giving a 15% discount
 * if eligible.
 */
public class NewCustomerDiscount implements DiscountEligibility{
    
    /**
     * Checks if the customer is eligible for the 15% new customer discount and
     * returns the new discounted price if eligible.
     * 
     * @param customerID the ID of the customer. For the new customer discount,
     * the customer ID must start with 11 to be eligible.
     * @param totalPrice The total price of the sale.
     * @return A new price with discount if eligible, the old price if not.
     */
    @Override
    public Amount checkDiscount(int customerID, Amount totalPrice){
        
        int customerIDIdentifier = (customerID/10000);
        
        if(customerIDIdentifier == 11){
            Amount fifteenPercent = new Amount(0.15);
            Amount totalPriceWithDiscount = totalPrice.minus(totalPrice.multiplied(fifteenPercent));
            return totalPriceWithDiscount;
             
        }
        return totalPrice;
    }
}
