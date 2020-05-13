
package se.kth.sem4.controller;
import java.util.ArrayList;
import java.util.List;
import se.kth.sem4.integration.ExternalAccountingDBHandler;
import se.kth.sem4.model.PurchaseInfoDTO;
import se.kth.sem4.model.Sale;
import se.kth.sem4.model.ItemDTO;
import se.kth.sem4.integration.ExternalInventoryDBHandler;
import se.kth.sem4.integration.HandlerCreator;
import se.kth.sem4.integration.InvalidItemException;
import se.kth.sem4.integration.InventoryDatabaseException;
import se.kth.sem4.model.Amount;
import se.kth.sem4.model.CashRegister;
import se.kth.sem4.integration.PrinterHandler;
import se.kth.sem4.model.RevenueObserver;

/**
 * The controller class passes calls from the view to the model or integration.
 */
public class Controller {
    ExternalInventoryDBHandler extInv = new ExternalInventoryDBHandler();
    ExternalAccountingDBHandler extAcc = new ExternalAccountingDBHandler();
    HandlerCreator handler = new HandlerCreator();
    Sale sale;
    CashRegister cashreg = new CashRegister();
    private List<Integer> enteredIDs = new ArrayList<>();
    PrinterHandler printerHandler = new PrinterHandler();
    private List<RevenueObserver> revenueObservers = new ArrayList<>();
    
    /**
     * Creates a new sale
     */
    public void startSale(){
        this.sale = new Sale();
        sale.resetTotalPrice();
        sale.addRevenueObservers(revenueObservers);
    }
    
    /**
     * Inputs the item ID and quantity, and outputs purchase info in the form
     * of description, price and running total.
     * 
     * @param itemID The item ID of the item.
     * @param quantity How many of the item is being purchased.
     * 
     * @return Returns item description, item price and running total. 
     */  
     public PurchaseInfoDTO enterItem(int itemID, int quantity) throws InvalidItemException, 
                                                                     OperationFailedException{
        PurchaseInfoDTO purchaseInfo = null;
        try{
        ItemDTO item = extInv.retrieveItemInfo(itemID);    
        enteredIDs.add(new Integer(itemID));
        purchaseInfo = sale.updatePurchaseInfo(item, quantity);  
        }
        catch(InventoryDatabaseException exc){
            throw new OperationFailedException("Could not enter item, "
                    + "please try again", exc);
        }
        return purchaseInfo;
    }
    
    /**
     * Ends the sale and returns the total price for the sale.
     * 
     * @param purchaseInfo Part of this contains the total price.
     * @return Returns the total price.
     */
    public Amount endSale(PurchaseInfoDTO purchaseInfo){
        
        Amount totalPrice = sale.endSale(purchaseInfo); 
         
        return totalPrice;
    }
    
    /**
     * Takes the amount that was paid and returns the change.
     * 
     * @param payment How much the customer paid.
     * @param totalPrice The total price of the sale.
     * @return Returns how much change belongs to the customer.
    */
    public Amount enterAmountPaid(Amount payment, Amount totalPrice){
       
        Amount change = cashreg.addPayment(payment, totalPrice);
        
        sale.updateAmountPaid(payment);
        return change;
    }
    
    /**
     * Displays the receipt on the View.
     * 
     * @return Returns the formatted receipt with all relevant info. 
     */
    public String getReceiptString(){
        String receipt = printerHandler.printReceipt(sale.getSalesLogDTO());
    
        return receipt;
    }
    
    /**
     * Updates the external inventory system and the external accounting system.
     */
    public void updateExternalSystems(){
        extInv.updateInventory(sale.getSalesLogDTO());
        extAcc.updateAccounting(sale.getSalesLogDTO());
    }
    
    /**
     * Adds a revenue observer.
     * 
     * @param obs the observer to add. 
     */
    public void addRevenueObserver(RevenueObserver obs){
        revenueObservers.add(obs);
    }
}
