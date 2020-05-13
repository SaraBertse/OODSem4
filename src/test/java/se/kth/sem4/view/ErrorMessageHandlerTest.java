/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sem4.view;

import se.kth.sem4.view.ErrorMessageHandler;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class ErrorMessageHandlerTest {
    ByteArrayOutputStream outContent;
    PrintStream originalSysOut;

    @BeforeEach
    public void setUpStreams() {
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void cleanUpStreams() {
        outContent = null;
        System.setOut(originalSysOut);
    }

    @Test
    public void testShowErrorMessage() {
        String errorMsg = "this is the message";
        ErrorMessageHandler instance = new ErrorMessageHandler();
        instance.showErrorMessage(errorMsg);
        String expResultMsg = "ERROR: " + errorMsg;
        String result = outContent.toString();
        assertTrue(result.contains(expResultMsg), "Wrong printout.");
    }
}