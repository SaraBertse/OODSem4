
package se.kth.sem4.model;

import se.kth.sem4.model.discounts.CompositeDiscount;

/**
 * This is the class that's responsible for discounts.
 */
public class Discount {
    Sale sale = new Sale();
    Amount priceAfterDiscount;
    
    /**
     * Checks if a discount is applicable and calculates the new price.
     * 
     * @param customerID a six-figure customer ID of the customer. ID's starting 
     * with 11 (new customer discount), 55 (VIP customer discount) and 99 
     * (pensioner discount) grant discounts.
     * @param sale The current sale for which the customer wants discount.
     * @return The price, discounted if the discount is granted and unchanged 
     * if not granted.
     */
    public Amount calculatePriceAfterDiscount(int customerID, Sale sale){
        
        Amount totalPrice = sale.getTotalPrice();
        
        priceAfterDiscount = new CompositeDiscount().checkDiscount(customerID, totalPrice);
   
        if (priceAfterDiscount.equals(totalPrice)){
            System.out.println("That customer ID is not eligible for discount.");
        }
        sale.setTotalPrice(priceAfterDiscount);
        return priceAfterDiscount;
    }
}
