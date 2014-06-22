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
public class CreateFunctionalPromotionCommandTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static CreateFunctionalPromotionCommand testCreation;
    static Date testEndDate;
    static Date testStartDate;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testStartDate = new Date();
        testEndDate = new Date();
        testCreation = new CreateFunctionalPromotionCommand(testDatabase, testInterface, testStartDate, testEndDate);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testStartDate = null;
        testEndDate = null;
        testCreation = null;
    }

    /**
     * Test of CreateFunctionalPromotionCommand method, of class CreateFunctionalPromotionCommand.
     */
    @Test
    public void testCreateFunctionalPromotionCommand() {
        assertTrue(testCreation instanceof CreateFunctionalPromotionCommand);
    }
    
}
