
package se.kth.sem4.view;

import java.util.ArrayList;
import java.util.List;
import se.kth.sem4.model.Amount;
import se.kth.sem4.model.RevenueObserver;

/**
 * This class represents a display that shows the total amount paid since the
 * program started.
 */
public class TotalRevenueView implements RevenueObserver {
    private List<Amount> payments = new ArrayList<>();
    Amount totalRevenue = new Amount(0);
    int i = 0;
    
    /**
     * Prints the total revenue since the start of the program.
     * @param totalPrice this is the price for each sale.
     */
    @Override
    public void newPayment(Amount totalPrice){
        addNewPayment(totalPrice);
        printCurrentState();
    }
    
    /**
     * Adds a new payment to the list of payments.
     * @param totalPrice 
     */
    private void addNewPayment(Amount totalPrice){
        payments.add(totalPrice);
    }
    
    /**
     * Calculates and prints the total revenue so far.
     */
    private void printCurrentState(){
        while (i < payments.size()){
            totalRevenue = totalRevenue.plus(payments.get(i));
            i++;
        }
        System.out.println("Total revenue so far: " + totalRevenue);
    }
}
