/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.text.command;

import data.Database;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ui.text.Interface;

/**
 *
 * @author Igor
 */
public class CreateLeaveCountryCommandTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static Date testEndDate;
    static Date testStartDate;
    static CreateLeaveCountryCommand testCreation;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testEndDate = new Date();  
        testStartDate = new Date();
        testCreation = new CreateLeaveCountryCommand(testDatabase, testInterface, testEndDate, testStartDate);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testEndDate = null; 
        testStartDate = null;
        testCreation = null;
    }

    /**
     * Test of CreateLeaveCountryCommand method, of class CreateLeaveCountryCommand.
     */
    @Test
    public void testCreateLeaveCountryCommand() {
        assertTrue(testCreation instanceof CreateLeaveCountryCommand);
    }

    
}
