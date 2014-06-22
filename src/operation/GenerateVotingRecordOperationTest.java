/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operation;

import architecture.Probation;
import architecture.Voting;
import data.Database;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import ui.text.Interface;

/**
 *
 * @author Igor
 */
public class GenerateVotingRecordOperationTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static Voting testVoting;
    static GenerateVotingRecordOperation TestVotingRecordGeneration;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testVoting = new Probation(1, null, null, null, null, null);
        TestVotingRecordGeneration = new GenerateVotingRecordOperation(testDatabase, testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testVoting = null;
        TestVotingRecordGeneration = null;
    }

    /**
     * Test of GenerateVotingRecordOperation method, of class GenerateVotingRecordOperation.
     */
    @Test
    public void testGenerateVotingRecordOperation() {
        assertTrue(TestVotingRecordGeneration instanceof GenerateVotingRecordOperation);
    }
    
}
