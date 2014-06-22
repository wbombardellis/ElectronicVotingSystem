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
public class VisualizeVotingsCommandTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static VisualizeVotingsCommand testVisualize;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testVisualize = new VisualizeVotingsCommand(testDatabase, testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testVisualize = null;
    }

    /**
     * Test of VisualizeVotingsCommand method, of class VisualizeVotingsCommand.
     */
    @Test
    public void testVisualizeVotingsCommand() {
       assertTrue(testVisualize instanceof VisualizeVotingsCommand);
    }

    /**
     * Test of toString method, of class VisualizeVotingsCommand.
     */
    @Test
    public void testToString() {
        
        String expResult = "Visualize all votings";
        String result = testVisualize.toString();
        assertEquals(expResult, result);
       
    }
    
}
