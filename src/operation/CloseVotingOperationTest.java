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
public class CloseVotingOperationTest {
     static CloseVotingOperation testVotingClosure;
     static Database testDatabase;
     static Interface testInterface;
    
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testVotingClosure = new CloseVotingOperation(testDatabase,testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testVotingClosure = null;
        testDatabase = null;
        testInterface = null;
    }

    /**
     * Test of execute method, of class CloseVotingOperation.
     */
    @Test
    public void testExecute() {
        assertTrue (testVotingClosure instanceof CloseVotingOperation);
    }
    
}
