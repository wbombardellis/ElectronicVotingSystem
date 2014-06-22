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
public class CreateProbationCommandTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static Date testEndDate;
    static Date testStartDate;
    static CreateProbationCommand testCreation;
            
            
            
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testEndDate = new Date();  
        testStartDate = new Date();
        testCreation = new CreateProbationCommand(testDatabase, testInterface, testEndDate, testStartDate);
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
     * Test of CreateProbationCommand method, of class CreateProbationCommand.
     */
    @Test
    public void testCreateProbationCommand() {
        assertTrue(testCreation instanceof CreateProbationCommand);
    }
    
}
