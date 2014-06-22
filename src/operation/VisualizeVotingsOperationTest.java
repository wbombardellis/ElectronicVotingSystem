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
public class VisualizeVotingsOperationTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static VisualizeVotingsOperation testVotingsVisualization;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testVotingsVisualization = new VisualizeVotingsOperation(testDatabase, testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testVotingsVisualization = null;
    }

    /**
     * Test of VisualizeVotingsOperation method, of class VisualizeVotingsOperation.
     */
    @Test
    public void testVisualizeVotingsOperation() {
        assertTrue(testVotingsVisualization instanceof VisualizeVotingsOperation);
    }
    
}
