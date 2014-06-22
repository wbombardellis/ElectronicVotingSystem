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
public class OpenVotingCommandTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static OpenVotingCommand testOpen;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testOpen = new OpenVotingCommand(testDatabase, testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testOpen = null;
    }

    /**
     * Test of OpenVotingCommand method, of class OpenVotingCommand.
     */
    @Test
    public void testOpenVotingCommand() {
        assertTrue(testOpen instanceof OpenVotingCommand);
    }

    /**
     * Test of toString method, of class OpenVotingCommand.
     */
    @Test
    public void testToString() {
      
        String expResult = "Open voting";
        String result = testOpen.toString();
        assertEquals(expResult, result);
        
    }
    
}
