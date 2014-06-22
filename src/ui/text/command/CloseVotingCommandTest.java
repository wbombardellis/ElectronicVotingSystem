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
public class CloseVotingCommandTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static CloseVotingCommand testCloseVoting;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testCloseVoting = new CloseVotingCommand(testDatabase, testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testCloseVoting = null;
    }

    /**
     * Test of CloseVotingCommand method, of class CloseVotingCommand.
     */
    @Test
    public void testCloseVotingCommand() {
        assertTrue(testCloseVoting instanceof CloseVotingCommand);
    }

    /**
     * Test of toString method, of class CloseVotingCommand.
     */
    @Test
    public void testToString() {
        String expResult = "Close voting";
        String result = testCloseVoting.toString();
        assertEquals(expResult, result);
        
    }
    
}
