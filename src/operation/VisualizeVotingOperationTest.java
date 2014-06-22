/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operation;

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
public class VisualizeVotingOperationTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static VisualizeVotingOperation testVotingVisualization;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testVotingVisualization = new VisualizeVotingOperation(testDatabase, testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testVotingVisualization = null;
    }

    /**
     * Test of VisualizeVotingOperation method, of class VisualizeVotingOperation.
     */
    @Test
    public void testVisualizeVotingOperation() {
        assertTrue(testVotingVisualization instanceof VisualizeVotingOperation);
    }
    
}
