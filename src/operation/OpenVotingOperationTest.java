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
public class OpenVotingOperationTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static OpenVotingOperation testVotingOpening;
    
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testVotingOpening = new OpenVotingOperation(testDatabase, testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testVotingOpening = null;
    }

    /**
     * Test of OpenVotingOperation method, of class OpenVotingOperation.
     */
    @Test
    public void testOpenVotingOperation() {
        assertTrue(testVotingOpening instanceof OpenVotingOperation);
    }
        
}
