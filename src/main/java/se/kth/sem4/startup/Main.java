
package se.kth.sem4.startup;
import java.io.IOException;
import se.kth.sem4.integration.HandlerCreator;
import se.kth.sem4.controller.Controller;
import se.kth.sem4.integration.InvalidItemException;
import se.kth.sem4.integration.InventoryDatabaseException;
import se.kth.sem4.view.View;
import se.kth.sem4.model.CashRegister;
import se.kth.sem4.model.Sale;
import se.kth.sem4.util.LogHandler;

/**
 * This starts up the entire program.
 */
public class Main {
    
    /**
     * The main method, which controls the flow of the program.
     * @param args Leave as is with no changes.
     */
    public static void main(String args[]){
       
        try{
        HandlerCreator handle = new HandlerCreator();
        Sale sale = new Sale();
        CashRegister cashreg = new CashRegister();
        Controller contr = new Controller();
        new View(contr).sampleExecution();
        }
        catch (InventoryDatabaseException exc){
            exc.printStackTrace();
        }
        catch(IOException exc){
           System.out.println("Application unable to start");
           exc.printStackTrace();
        }
    }
    
}
