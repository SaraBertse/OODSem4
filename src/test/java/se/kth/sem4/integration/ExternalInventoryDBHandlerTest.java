
package se.kth.sem4.integration;

import se.kth.sem4.integration.InventoryDatabaseException;
import se.kth.sem4.integration.InvalidItemException;
import se.kth.sem4.integration.ExternalInventoryDBHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

public class ExternalInventoryDBHandlerTest {
    ExternalInventoryDBHandler instance;

    @BeforeEach
    public void setUp() {
        instance = new ExternalInventoryDBHandler();
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testRetrieveItemInfoShouldThrowInvalidItemExc() {
        try {
            instance.retrieveItemInfo(115);
        } catch (InvalidItemException exc) {
            String expectedOutput = "Item";
            assertTrue(exc.getMessage().contains(expectedOutput), "InvalidItemException "
                    + " not thrown when it should be.");
        }
    }

    @Test
    public void testRetrieveItemInfoShouldNotThrowInvalidItemExc() {
        try {
            instance.retrieveItemInfo(112);
        } catch (InvalidItemException exc) {
            fail("InvalidItemException is thrown when it shouldn't be");
        }
    }

    @Test
    public void testRetrieveItemInfoShouldThrowInventoryDatabaseExc() {
        try {
            instance.retrieveItemInfo(666);
        } catch (InventoryDatabaseException exc) {
            String expectedOutput = "database";
            assertTrue(exc.getMessage().contains(expectedOutput), "InventoryDatabaseException"
                    + " is not thrown when it should be.");
        } catch (InvalidItemException exc) {
            fail("InvalidItemException is thrown when InventoryDatabaseException should be instead");
        }
    }

    @Test
    public void testRetrieveItemInfoShouldNotThrowInventoryDatabaseExc() {
        try {
            instance.retrieveItemInfo(112);
        } catch (InventoryDatabaseException exc) {
            fail("InventoryDatabaseException is thrown when it shouldn't be");

        } catch (InvalidItemException exc) {
            fail("InvalidItemException is thrown when it shouldn't be");
        }
    }
}
