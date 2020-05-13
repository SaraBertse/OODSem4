
package se.kth.sem4.controller;


import se.kth.sem4.controller.OperationFailedException;
import se.kth.sem4.controller.Controller;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import se.kth.sem4.integration.InvalidItemException;
import se.kth.sem4.model.Sale;


public class ControllerTest {
    Controller instance;
    Sale sale;

    @BeforeEach
    public void setUp() {
        instance = new Controller();
        instance.startSale();
    }

    @AfterEach
    public void tearDown() {
        instance = null;
        sale = null;
    }

    @Test
    public void testEnterItemInfoShouldThrowInvalidItemExc() {
        try {
            instance.enterItem(115, 1);
        } catch (InvalidItemException exc) {
            String expectedOutput = "Item";
            assertTrue(exc.getMessage().contains(expectedOutput), "InvalidItemException "
                    + " not thrown when it should be.");
        }
        catch (OperationFailedException exc){
            
        }
    }

    @Test
    public void testEnterItemInfoShouldNotThrowInvalidItemExc() {
        try {
            instance.enterItem(112, 1);
        } catch (InvalidItemException exc) {
            fail("InvalidItemException is thrown when it shouldn't be");
        }
         catch (OperationFailedException exc){
            
        }
    }

    @Test
    public void testEnterItemInfoShouldThrowOperationFailedException() {
        try {
            instance.enterItem(666, 1);
        } catch (OperationFailedException exc) {
            String expectedOutput = "please";
            System.out.println(exc.getMessage());
            assertTrue(exc.getMessage().contains(expectedOutput), "OperationFailedException"
                    + " is not thrown when it should be.");
        } catch (InvalidItemException exc) {
            fail("InvalidItemException is thrown when OperationFailedException should be instead");
        }
    }

    @Test
    public void testEnterItemInfoShouldNotThrowOperationFailedException() {
        try {
            instance.enterItem(112, 1);
        } catch (InvalidItemException exc) {
            fail("InventoryDatabaseException is thrown when it shouldn't be");

        } catch (OperationFailedException exc) {
            fail("InvalidItemException is thrown when it shouldn't be");
        }
    }
}

   /* private View instanceToTest;
    Controller contr;
    ExternalInventoryDBHandler extInv;
    HandlerCreator handle;
    Sale sale = new Sale();
    CashRegister cashreg;
    private List<Integer> enteredIDs;
    Amount amount = new Amount(500);
    private Amount totalPrice;
    private Amount payment;
    private Amount totalVAT;
    private Amount runningTotal = new Amount(0);
    private Amount calculateTotalVAT = new Amount(0);
    private LocalDateTime timeAndDateOfSale = LocalDateTime.now();
    private List<Sale.ItemData> items = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        handle = new HandlerCreator();
        cashreg = new CashRegister();
        contr = new Controller();
        try{
        instanceToTest = new View(contr);
        }
        catch (IOException exc){
            exc.printStackTrace();
        } 
        enteredIDs = new ArrayList<>();
        extInv = new ExternalInventoryDBHandler();
        contr.startSale();

    }

    @AfterEach
    public void tearDown() {
        instanceToTest = null;
    }

    @Disabled
    public void enterItemTest1() {
        try {
            PurchaseInfoDTO info = contr.enterItem(112, 3);
            System.out.println(info.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("");
        }
    }

    @Test
    public void testRetrieveItemInfoShouldThrowInvalidItemException() throws InvalidItemException {
        ExternalInventoryDBHandler extInv = new ExternalInventoryDBHandler();
        contr.startSale();
        try {
            contr.enterItem(115, 2);
        } catch (InvalidItemException exc) {
            String expectedOutput = "please";
            assertTrue(exc.getMessage().contains(expectedOutput), "InvalidItemException "
                    + " not thrown when it should be.");
        } catch (OperationFailedException exc){
            
        }
    }

    @Disabled
    public void testRetrieveItemInfoInvDBFailureShouldThrowExc2() {
        String expectedOutput = "database";
        try {
            contr.enterItem(666, 1);
        } catch (InventoryDatabaseException exc) {
            assertTrue(exc.getMessage().contains(expectedOutput), "InventoryDatabaseException "
                    + " not thrown when it should be.");
        } catch(InvalidItemException exc){
                //Something!
        } catch (OperationFailedException exc){
            
        }
    }

    @Test
    public void enterItemTestShouldNOTThrowInvalidItemException() {
        String expectedOutput = "please";
        try {
            contr.enterItem(112, 2);

        } catch (InvalidItemException exc) {

            assertFalse(exc.getMessage().contains(expectedOutput), "InvalidItemException "
                    + " is thrown when it shouldn't be");
        } catch (OperationFailedException exc){
            
        }
    }

    @Test
    public void testRetrieveItemInfoInvDBFailureShouldNotThrowExc2() {
        String expectedOutput = "database";
        try {
            contr.enterItem(112, 1);
        } catch (OperationFailedException exc) {
            assertFalse(exc.getMessage().contains(expectedOutput), "InventoryDatabaseException "
                    + " is thrown when it shouldn't be");
        } catch (InvalidItemException exc){
            //Something!
        }
    }
    
      @Test
    public void enterItemTestShouldNOTThrowInvalidItemException2() {
        String expectedOutput = "please";
        try {
            contr.enterItem(112, 2);

        } catch (InvalidItemException exc) {

            assertFalse(exc.getMessage().contains(expectedOutput), "InvalidItemException "
                    + " is thrown when it shouldn't be");
        } catch (OperationFailedException exc){
            //Something
        }
    }*/

