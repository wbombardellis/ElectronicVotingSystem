/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package architecture;

import static architecture.VoteType.FAVORABLE;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author Igor
 */
public class VoteTest {
    
    static VoteType testVoteType;
    static VotingMember testVotingMember;
    static String testOptionalExplanation;
    static Vote testVote;
    
    @BeforeClass
    public static void setUpClass() {
        testVoteType = FAVORABLE;
        String testName = "Joao";
        testVotingMember = new VotingMember(testName);
        testOptionalExplanation = new String();
        testVote = new Vote(testVoteType, testVotingMember, testOptionalExplanation);     
    }
    
    @AfterClass
    public static void tearDownClass() {
        testVotingMember = null;
        testOptionalExplanation = null;
        testVote = null;
    }
    
    
    @Test
    public void testVote() {
        assertTrue(testVote instanceof Vote);        
    }

    /**
     * Test of getVotingMember method, of class Vote.
     */
    @Test
    public void testGetVotingMember() {
        String expResult = "Joao";
        VotingMember result = testVote.getVotingMember();
        assertEquals(expResult, result.getName());
    }

    /**
     * Test of getType method, of class Vote.
     */
    @Test
    public void testGetType() {
        VoteType expResult = FAVORABLE;
        VoteType result = testVote.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Vote.
     */
    @Test
    public void testToString() {
        DateFormat testDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date testDate = new Date();
        String expResult = "Vote: FAVORABLE\n" +
                            "Author: Joao\n" +
                            "Date: " + testDateFormat.format(testDate) + "\n";
        String result = testVote.toString();
        assertEquals(expResult, result);
        
    }
    
}
