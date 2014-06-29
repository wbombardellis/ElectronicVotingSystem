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
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Igor
 */
public class VotingTest {
    
    static int testId;
    static String testAuthor;
    static Date testStartDate;
    static Date testEndDate;
    static String testTeacherReport;
    static String testTutorReport;
    static Voting testVoting;
    
    @BeforeClass
    public static void setUpClass() {
        testId = 3;
        testAuthor = new String();
        testStartDate = new Date();
        testEndDate = new Date();
        testTeacherReport = new String();
        testTutorReport = new String();
        testVoting = new Probation(testId, testAuthor, testStartDate, testEndDate, testTeacherReport, testTutorReport);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testAuthor = null;
        testStartDate = null;
        testEndDate = null;
        testTeacherReport = null;
        testTutorReport = null;
        testVoting = null;
    }

    
    @Test
    public void testVoting() {
        assertTrue(testVoting instanceof Voting);    
    }
    
    
    /**
     * Test of getId method, of class Voting.
     */
    @Test
    public void testGetId() {
        int expResult = 3;
        int result = testVoting.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMembersWhoVoted method, of class Voting.
     */
    @Test
    public void testGetMembersWhoVoted() {
        VotingMember testMember = new VotingMember("Joao");
        Vote testVote = new Vote(FAVORABLE, testMember, null);
        testVoting.addVote(testVote);
        
        String expResult = "Joao";
        List<VotingMember> resultList = testVoting.getMembersWhoVoted();
        VotingMember result = resultList.get(0);
        assertEquals(expResult, result.getName());
    }

    /**
     * Test of isClosed method, of class Voting.
     */
    @Test
    public void testIsClosed() {
        boolean expResult = true;
        boolean result = testVoting.isClosed();
        assertEquals(expResult, result);
    }

    /**
     * Test of close method, of class Voting.
     */
    @Test
    public void testClose() {
       testVoting.close();
       assertTrue(testVoting.wasClosedManually()); 
    }

    /**
     * Test of isAuthorized method, of class Voting.
     */
    @Test
    public void testIsAuthorized() {
        boolean expResult = false;
        boolean result = testVoting.isAuthorized();
        assertEquals(expResult, result);
    }

    /**
     * Test of authorize method, of class Voting.
     */
    @Test
    public void testAuthorize() {
        testVoting.authorize();
        assertTrue(testVoting.isAuthorized());
    }

    /**
     * Test of isRecorded method, of class Voting.
     */
    @Test
    public void testIsRecorded() {
        boolean expResult = true;
        boolean result = testVoting.isRecorded();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of record method, of class Voting.
     */
    @Test
    public void testRecord() {
        testVoting.record();
        assertTrue(testVoting.isRecorded());
    }

    /**
     * Test of isReleased method, of class Voting.
     */
    @Test
    public void testIsReleased() {
        boolean expResult = false;
        boolean result = testVoting.isReleased();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of release method, of class Voting.
     */
    @Test
    public void testRelease() {
        testVoting.release();
        assertTrue(testVoting.isReleased());
    }

    /**
     * Test of addVote method, of class Voting.
     */
    @Test
    public void testAddVote() {
        VotingMember testMember = new VotingMember("Joao");
        Vote testVote = new Vote(FAVORABLE, testMember, null);
        testVoting.addVote(testVote);
        List<Vote> testListVote = testVoting.getVotes();
        Vote resultVote = testListVote.get(0);
                
        assertEquals(testVote.getType(), resultVote.getType());
        
    }

    /**
     * Test of getStartDate method, of class Voting.
     */
    @Test
    public void testGetStartDate() {
        DateFormat testDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();
        
        Date result = testVoting.getStartDate();
        assertEquals(testDateFormat.format(currentDate), testDateFormat.format(result));
    }

    /**
     * Test of getEndDate method, of class Voting.
     */
    @Test
    public void testGetEndDate() {
        DateFormat testDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();
        
        Date result = testVoting.getEndDate();
        assertEquals(testDateFormat.format(currentDate), testDateFormat.format(result));
    }

    /**
     * Test of hasStarted method, of class Voting.
     */
    @Test
    public void testHasStarted() {
        boolean expResult = true;
        boolean result = testVoting.hasStarted();
        assertEquals(expResult, result);
    }

    /**
     * Test of wasClosedManually method, of class Voting.
     */
    @Test
    public void testWasClosedManually() {
        boolean expResult = true;
        boolean result = testVoting.wasClosedManually();
        assertEquals(expResult, result);
    }

    /**
     * Test of open method, of class Voting.
     */
    @Test
    public void testOpen() {
        DateFormat testDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();
        
        testVoting.open();
        Date testResultStartDate = testVoting.getStartDate();
        assertEquals(testDateFormat.format(currentDate), testDateFormat.format(testResultStartDate));
        
      }

    /**
     * Test of getVotes method, of class Voting.
     */
    @Test
    public void testGetVotes() {
        VotingMember testMember = new VotingMember("Joao");
        Vote testVote = new Vote(FAVORABLE, testMember, null);
        testVoting.addVote(testVote);
        List<Vote> testListVote = testVoting.getVotes();
        Vote resultVote = testListVote.get(0);
                
        assertEquals(testVote.getType(), resultVote.getType());
    }

    
    @Test
    public void testGetJustification() {
        Justification testJustification = new Justification("JUSTIFICAÇÃO", new VotingMember("Jão"));
        
        assertEquals(testVoting.getJustifications().size(), 0);
        
        testVoting.addJustification(testJustification);
        
        assertEquals(testVoting.getJustifications().size(), 1);
        
        List<Justification> testListJust = testVoting.getJustifications();
        
        assertEquals(testVoting.getJustifications().size(), 1);
        
        Justification resultJust = testListJust.get(0);
        
        assertEquals(testJustification, resultJust);
    }
    
}
