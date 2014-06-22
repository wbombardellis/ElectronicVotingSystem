/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operation;

import architecture.Probation;
import architecture.VoteType;
import static architecture.VoteType.FAVORABLE;
import architecture.Voting;
import architecture.VotingMember;
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
public class VoteOperationTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static Voting testVoting;
    static VoteType testVoteType;
    static VotingMember testVotingMember;
    static String testExplanation;
    static VoteOperation testVote;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testVoting = new Probation(1, null, null, null, null, null);
        testVoteType = FAVORABLE;
        String testVotingMemberName = new String();
        testVotingMember = new VotingMember(testVotingMemberName);
        testExplanation = new String();
        testVote = new VoteOperation(testDatabase, testInterface, testVoting, testVoteType, testVotingMember, testExplanation);      
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testVoting = null;
        testVoteType = null;
        testVotingMember = null;
        testExplanation = null;
        testVote = null;
    }

    /**
     * Test of VoteOperation method, of class VoteOperation.
     */
    @Test
    public void testVoteOperation() {
        assertTrue(testVote instanceof VoteOperation);
    }
    
}
