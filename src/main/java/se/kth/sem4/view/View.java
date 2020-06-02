package se.kth.sem4.view;
import java.io.IOException;
import se.kth.sem4.controller.Controller;
import se.kth.sem4.controller.OperationFailedException;
import se.kth.sem4.integration.InvalidItemException;
import se.kth.sem4.integration.InventoryDatabaseException;
import se.kth.sem4.model.PurchaseInfoDTO;
import se.kth.sem4.model.Amount;
import se.kth.sem4.util.LogHandler;

/**
 * Currently the placeholder class for the user interface. Also has a 
 * hardcoded sample execution.
 */
public class View {
    public Controller contr; //Should be private but is public for now!
    public Amount payment;
    ErrorMessageHandler errorMsgHandler = new ErrorMessageHandler();
    public Amount totalPrice;
    LogHandler logger = new LogHandler();
    private Amount change;
    
    /**
     * Creates a new instance.
     * @param contr The controller that is used for all operations.
     */
    public View(Controller contr) throws IOException{
            this.contr = contr;
            contr.addRevenueObserver(new TotalRevenueView());
    }
    
    /**
     * This is the hardcoded sample execution.
     * 
     * @throws IOException This is thrown if the program is not working for some
     * unknown reason.
     */
    public void sampleExecution() throws IOException{
    try{    
        contr.startSale();
        PurchaseInfoDTO purchaseInfo1 = contr.enterItem(112, 2);
        PurchaseInfoDTO purchaseInfo2 = contr.enterItem(112, 1);
        PurchaseInfoDTO purchaseInfo3 = contr.enterItem(114, 2);
        PurchaseInfoDTO purchaseInfo4 = contr.enterItem(111, 1);
        PurchaseInfoDTO purchaseInfo5 = contr.enterItem(112, 1);
    
        System.out.println(purchaseInfo1);
        System.out.println(purchaseInfo2);
        System.out.println(purchaseInfo3);
        System.out.println(purchaseInfo4); 
        System.out.println(purchaseInfo5);
        
        
        this.totalPrice = contr.endSale(purchaseInfo5);
        
        System.out.println("The total price is " + totalPrice);
       
        this.change = contr.enterAmountPaid(new Amount(200), totalPrice);
        
        System.out.println("The change is " + change);
        System.out.println();
        
        String receipt = contr.getReceiptString();
        System.out.println(receipt);
        
       
        contr.updateExternalSystems();
        
        contr.startSale();
        PurchaseInfoDTO purchaseInfo6 = contr.enterItem(112, 2);
        PurchaseInfoDTO purchaseInfo7 = contr.enterItem(112, 2);
        System.out.println(purchaseInfo6);
        System.out.println(purchaseInfo7);
        this.totalPrice = contr.endSale(purchaseInfo7);
        System.out.println("The total price is " + totalPrice);
        contr.signalDiscountRequest();
        Amount priceAfterDiscount = contr.enterCustomerID(992233);
        System.out.println("Price with discount if applicable, otherwise without: " + priceAfterDiscount);
        this.change = contr.enterAmountPaid(new Amount(200), totalPrice);
      
        }
        catch(OperationFailedException exc){
            handleException("Could not reach item database, please try again.", exc);
            
        }
        catch(InvalidItemException exc){
         handleException("The item with that item ID doesn't exist, please"
                 + " enter the right item ID.", exc);
        }
}
    /**
     * Prints a message and logs the exception.
     * 
     * @param message The message to be printed.
     * @param exc The exception to log.
     */
    private void handleException(String message, Exception exc) {
        errorMsgHandler.showErrorMessage(message);
        logger.logException(exc);
    }
}


