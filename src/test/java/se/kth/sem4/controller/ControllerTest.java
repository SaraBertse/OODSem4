
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
            fail("InvalidItemException is not thrown when it should be.");
        } catch (InvalidItemException exc) {
        
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
            fail("OperationFaiedException is not thrown when it should be.");
        } catch (OperationFailedException exc) {
 
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