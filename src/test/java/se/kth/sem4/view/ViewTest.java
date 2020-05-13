
package se.kth.sem4.view;

import se.kth.sem4.view.View;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.sem4.controller.Controller;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.Disabled;
import se.kth.sem4.integration.HandlerCreator;
import se.kth.sem4.integration.InvalidItemException;
import se.kth.sem4.model.CashRegister;
import se.kth.sem4.model.Sale;

public class ViewTest {
    private View instance;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;
    
    @BeforeEach
    public void setUp() {
       
        Sale sale = new Sale();
        Controller contr = new Controller();
        contr.startSale();
        try{
        instance = new View(contr);
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
        }
        catch (IOException exc){
            exc.printStackTrace();
        }
       
    }
    
    @AfterEach
    public void tearDown() {
        instance = null;
        
        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Disabled
    public void testSampleExecution() {
        String expectedOutput = "price";
        String printout = printoutBuffer.toString();
        try{
        instance.sampleExecution();   
        assertTrue(printout.contains(expectedOutput), "View class isn't working.");
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
    
    
    
    
    /* private View instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;
    
    @BeforeEach
    public void setUp() {
        HandlerCreator handle = new HandlerCreator();
        Sale sale = new Sale();
        CashRegister cashreg = new CashRegister();
        Controller contr = new Controller();
        try{
        instanceToTest = new View(contr);
        }
        catch(IOException exc){
            exc.printStackTrace(); 
        }
        ErrorMessageHandler errorMsgHandler = new ErrorMessageHandler(); 
        
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }
    
    @AfterEach
    public void tearDown() {
        instanceToTest = null;
        
        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Test
    public void testSampleExecution() {
        String expectedOutput = "price";
        String printout = printoutBuffer.toString();
        try{
        instanceToTest.sampleExecution();
        assertTrue(printout.contains(expectedOutput), "View class isn't working.");
        }
        catch(IOException exc){
            exc.printStackTrace();
        }
    }*/
}