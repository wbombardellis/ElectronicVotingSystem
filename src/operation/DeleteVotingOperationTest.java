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
public class DeleteVotingOperationTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static DeleteVotingOperation testVotingExclusion;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testVotingExclusion = new DeleteVotingOperation(testDatabase, testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testVotingExclusion = null;
    }

    /**
     * Test of DeleteVotingOperation method, of class DeleteVotingOperation.
     */
    @Test
    public void testDeleteVotingOperation() {
        assertTrue(testVotingExclusion instanceof DeleteVotingOperation);
    }
    
}
