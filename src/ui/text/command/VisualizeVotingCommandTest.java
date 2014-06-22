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
public class VisualizeVotingCommandTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static VisualizeVotingCommand testVisualize;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testVisualize = new VisualizeVotingCommand(testDatabase, testInterface);
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testVisualize = null;
    }

    /**
     * Test of VisualizeVotingCommand method, of class VisualizeVotingCommand.
     */
    @Test
    public void testVisualizeVotingCommand() {
       assertTrue(testVisualize instanceof VisualizeVotingCommand);
    }

    /**
     * Test of toString method, of class VisualizeVotingCommand.
     */
    @Test
    public void testToString() {
     
        String expResult = "Visualize voting";
        String result = testVisualize.toString();
        assertEquals(expResult, result);
        
    }
    
}
