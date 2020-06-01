
package se.kth.sem4.model.discounts;

import java.util.ArrayList;
import java.util.List;
import se.kth.sem4.model.Amount;


/**
 * This class cycles through the various discount types and checks if a
 * customer's ID is eligible for the different discounts. If it is, a new
 * discounted price is calculated.
 */
public class CompositeDiscount implements DiscountEligibility{
    private List<DiscountEligibility> typesOfDiscount = new ArrayList<>();
    
    /**
     * Checks if there's discount eligibility for any of the various discounts,
     * based on the customer's ID number.
     * 
     * @param customerID the customer's ID number.
     * @param totalPrice the total price of the sale before discount.
     * @return If the discount is granted, a new price is returned. If a
     * customer is not eligible for any of the discounts, the old price
     * is returned.
     */
    @Override
    public Amount checkDiscount(int customerID, Amount totalPrice){
        addDiscountEligibility();
        Amount totalPriceWithDiscount = null;
        for (DiscountEligibility discount : typesOfDiscount){
            totalPriceWithDiscount = discount.checkDiscount(customerID, totalPrice);
                        if (!(totalPriceWithDiscount.equals(totalPrice))){
                        return totalPriceWithDiscount;
                        }
        }
       return totalPrice;
    }
    
    /**
     * Populates the typesOfDiscount List with the various discounts.
     */
    void addDiscountEligibility(){
        typesOfDiscount.add(new NewCustomerDiscount());
        typesOfDiscount.add(new PensionerDiscount());
        typesOfDiscount.add(new VIPCustomerDiscount());
    }
}
