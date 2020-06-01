/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sem4.model.discounts;

import se.kth.sem4.model.Amount;


/**
 * This class represents a pensioner discount, giving a 10% discount
 * if eligible.
 */
public class PensionerDiscount implements DiscountEligibility{
    public PensionerDiscount(){}
    
     /**
     * Checks if the customer is eligible for the 10% pensioner discount and
     * returns the new discounted price if eligible.
     * 
     * @param customerID the ID of the customer. For the pensioner discount,
     * the customer ID must start with 99 to be eligible.
     * @param totalPrice The total price of the sale.
     * @return A new price with discount if eligible, the old price if not.
     */
    @Override
    public Amount checkDiscount(int customerID, Amount totalPrice){
        
        int customerIDIdentifier = (customerID/10000);
        
        if(customerIDIdentifier == 99){
        Amount tenPercent = new Amount(0.1);
        Amount totalPriceWithDiscount = totalPrice.minus(totalPrice.multiplied(tenPercent));
        return totalPriceWithDiscount;
        }
        return totalPrice; 
    }
}
