
package se.kth.sem4.view;

import java.util.ArrayList;
import java.util.List;
import se.kth.sem4.model.Amount;
import se.kth.sem4.model.RevenueObserver;
import se.kth.sem4.model.Sale;

/**
 * This class represents a display that shows the total amount paid since the
 * program started.
 */
public class TotalRevenueView implements RevenueObserver {
    private List<Amount> payments = new ArrayList<>();
    Amount totalRevenue = new Amount(0);
    
    @Override
    public void newPayment(Amount totalPrice){
        addNewPayment(totalPrice);
        printCurrentState();
    }
    
    private void addNewPayment(Amount totalPrice){
        payments.add(totalPrice);
    }
    
    int i = 0;
    private void printCurrentState(){
        while (i < payments.size()){
            totalRevenue = totalRevenue.plus(payments.get(i));
            i++;
        }
        System.out.println("Total revenue so far: " + totalRevenue);
    }
    
}
