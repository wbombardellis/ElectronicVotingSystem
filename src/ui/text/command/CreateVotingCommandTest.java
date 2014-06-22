/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.text.command;

import data.Database;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ui.text.Interface;


/**
 *
 * @author Igor
 */
public class CreateVotingCommandTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static CreateVotingCommand testCreation;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testCreation = new CreateVotingCommand(testDatabase, testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testCreation = null;
    }

    /**
     * Test of CreateVotingCommand method, of class CreateVotingCommand.
     */
    @Test
    public void testCreateVotingCommand() {
        assertTrue(testCreation instanceof CreateVotingCommand);
    }

    /**
     * Test of toString method, of class CreateVotingCommand.
     */
    @Test
    public void testToString() {
        
        String expResult = "Create voting";
        String result = testCreation.toString();
        assertEquals(expResult, result);
       
    }
    
}
