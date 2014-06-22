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
public class ReleaseVotingOperationTest {
  
    static Database testDatabase;
    static Interface testInterface;
    static ReleaseVotingOperation testVotingRelease;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testVotingRelease = new ReleaseVotingOperation(testDatabase, testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testVotingRelease = null;
    }

    /**
     * Test of ReleaseVotingOperation method, of class ReleaseVotingOperation.
     */
    @Test
    public void testReleaseVotingOperation() {
        assertTrue(testVotingRelease instanceof ReleaseVotingOperation);
    }
    
}
