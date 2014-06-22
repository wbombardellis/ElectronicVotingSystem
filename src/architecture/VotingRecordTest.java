/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package architecture;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Igor
 */
public class VotingRecordTest {
    
    static int testId;
    static Voting testVoting;
    static List<VotingMember> testMembersWhoVoted;
    static List<VotingMember> testMembersWhoDidNotVote;
    static List<VotingMember> testAbstentions;
    static VotingRecord testVotingRecord;
    
    @BeforeClass
    public static void setUpClass() {
        testId = 3;
        int votingId = 2;
        String votingAuthor = new String();
        Date votingStartDate = new Date();
        Date votingEndDate = new Date();
        String teacherReport = new String();
        String tutorReport = new String();
        
        testVoting = new Probation(votingId, votingAuthor, votingStartDate, votingEndDate, teacherReport, tutorReport);
        testMembersWhoVoted = new ArrayList<>();
        testMembersWhoDidNotVote = new ArrayList<>();
        testAbstentions = new ArrayList<>();
        testVotingRecord = new VotingRecord(testId, testVoting, testMembersWhoVoted, testMembersWhoDidNotVote, testAbstentions);      
    }
    
    @AfterClass
    public static void tearDownClass() {
        testVoting = null;
        testMembersWhoVoted = null;
        testMembersWhoDidNotVote = null;
        testAbstentions = null;
        testVotingRecord = null;  
    }
    
    @Test
    public void VotingRecord() {
        assertTrue(testVotingRecord instanceof VotingRecord);
    } 

    /**
     * Test of getResult method, of class VotingRecord.
     */
    @Test
    public void testGetResult() {
        boolean expResult = false;
        boolean result = testVotingRecord.getResult();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class VotingRecord.
     */
    @Test
    public void testToString() {
        DateFormat testDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date testDate = new Date();
        
        String expResult = "Id: 3\n" +
                            "End date: " + testDateFormat.format(testDate) + "\n" +
                            "Voting description:\n" +
                            "Voting id: 2\n" +
                            "Type: Probation\n" +
                            "Teacher Report: \n" +
                            "Tutor Report: \n" +
                            "Members who voted:\n" +
                            "Members who did not vote:\n" +
                            "Result: Not approved\n" +
                            "Abstentions:";
        String result = testVotingRecord.toString();
        assertEquals(expResult, result);
    }
    
}
