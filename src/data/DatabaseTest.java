/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import architecture.Member;
import architecture.Probation;
import architecture.Vote;
import architecture.Voting;
import architecture.VotingMember;
import architecture.VotingRecord;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.AfterClass;

import static architecture.VoteType.FAVORABLE;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import ui.Login;

/**
 *
 * @author Igor
 */
public class DatabaseTest {
    
    //static Database testDatabase;
    
    
    @BeforeClass
    public static void setUpClass() {
        //testDatabase = new Database();
        
        
    }
    
    @AfterClass
    public static void tearDownClass() {
       // testDatabase = null;
    }

    @Test
    public void testDatabase() {
        Database testDatabase = new Database();
        assertTrue(testDatabase instanceof Database);
    }
    
    
        
    /**
     * Test of getMemberCollection method, of class Database.
     */
    @Test
    public void testGetMemberCollection() {
         Database testDatabase = new Database();
         Map<Login, Member> testMap = testDatabase.getMemberMap();
         int testSize = testMap.size();
         Collection<Member> result = testDatabase.getMemberCollection();
         assertEquals(testSize, result.size());
           
    }

    /**
     * Test of getVotingMembers method, of class Database.
     */
    @Test
    public void testGetVotingMembers() {
        Database testDatabase = new Database();
        int expResult = 12;
        List<VotingMember> result = testDatabase.getVotingMembers();
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getVotings method, of class Database.
     */
    @Test
    public void testGetVotings() {
        Database testDatabase = new Database();
        Voting testVoting = new Probation (1, "Joao", new Date(), new Date(), new String(), new String());
        testDatabase.addVoting(testVoting);
       
        int expResult = 1;
        List<Voting> result = testDatabase.getVotings();
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getUnrecordedClosedVotings method, of class Database.
     */
    @Test
    public void testGetUnrecordedClosedVotings() {
        Database testDatabase = new Database();
        
        Voting testVoting = new Probation (1, "Joao", new Date(), new Date(), new String(), new String());
        testDatabase.addVoting(testVoting);
        try {
            Thread.sleep(5);
        } catch (InterruptedException ex) {
            Logger.getLogger(DatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        int expResult = 1;
        List<Voting> result = testDatabase.getUnrecordedClosedVotings();
           
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getUnrecordedUnclosedVotings method, of class Database.
     */
    @Test
    public void testGetUnrecordedUnclosedVotings() {
        Database testDatabase = new Database();
        Voting testVoting = new Probation (1, "Joao", new Date(), new Date(), new String(), new String());
        testDatabase.addVoting(testVoting);
        
        int expResult = 1;
        List<Voting> result = testDatabase.getUnrecordedUnclosedVotings();
        assertEquals(expResult, result.size());
    }

    /**
     * Test of getUnauthorizedVotings method, of class Database.
     */
    @Test
    public void testGetUnauthorizedVotings() {
        Database testDatabase = new Database();
        Voting testVoting = new Probation (1, "Joao", new Date(), new Date(), new String(), new String());
        testDatabase.addVoting(testVoting);
        
        int expResult = 1;
        List<Voting> result = testDatabase.getUnauthorizedVotings();
        assertEquals(expResult, result.size());
    }

    /**
     * Test of getUnrecordedUnopenVotings method, of class Database.
     */
    @Test
    public void testGetUnrecordedUnopenVotings() {
        Database testDatabase = new Database();
        Voting testVoting = new Probation (1, "Joao", new Date(), new Date(), new String(), new String());
        testDatabase.addVoting(testVoting);
        
        int expResult = 1;
        List<Voting> result = testDatabase.getUnrecordedUnopenVotings();
        assertEquals(expResult, result.size());
    }

    /**
     * Test of getUnrecordedUnreleasedVotings method, of class Database.
     */
    @Test
    public void testGetUnrecordedUnreleasedVotings() {
        Database testDatabase = new Database();
        Voting testVoting = new Probation (1, "Joao", new Date(), new Date(), new String(), new String());
        testDatabase.addVoting(testVoting);
        
        int expResult = 1;
        List<Voting> result = testDatabase.getUnrecordedUnreleasedVotings();
        assertEquals(expResult, result.size());
    }

    /**
     * Test of getUnrecordedOpenAuthorizedReleasedVotings method, of class Database.
     */
    @Test
    public void testGetUnrecordedOpenAuthorizedReleasedVotings() {
        Database testDatabase = new Database();
        Voting testVoting = new Probation (1, "Joao", new Date(), new Date(), new String(), new String());
        testVoting.close();
        testDatabase.addVoting(testVoting);
        
        int expResult = 1;
        List<Voting> result = testDatabase.getUnrecordedClosedVotings();
        assertEquals(expResult, result.size());
    }

    /**
     * Test of recordVoting method, of class Database.
     */
    @Test
    public void testRecordVoting() {
        Database testDatabase = new Database();
        Voting testVoting = new Probation (1, "Joao", new Date(), new Date(), new String(), new String());
        testDatabase.recordVoting(testVoting);
        
        assertTrue(testVoting.isRecorded());
    }

    /**
     * Test of addVoting method, of class Database.
     */
    @Test
    public void testAddVoting() {
        Database testDatabase = new Database();
        Voting testVoting = new Probation (1, "Joao", new Date(), new Date(), new String(), new String());
        testDatabase.addVoting(testVoting);
        
        List<Voting> testVotingsList = testDatabase.getVotings();
        List<Voting> testUnrecordedVotingsList = testDatabase.getUnauthorizedVotings();
        int votingsListSize = testVotingsList.size();
        int unrecordedVotingsListSize = testUnrecordedVotingsList.size();
        
        assertEquals (votingsListSize, unrecordedVotingsListSize);
    }

    /**
     * Test of deleteVoting method, of class Database.
     */
    @Test
    public void testDeleteVoting() {
        Database testDatabase = new Database();
        Voting testVoting = new Probation (1, "Joao", new Date(), new Date(), new String(), new String());
        testDatabase.addVoting(testVoting);
        testDatabase.deleteVoting(testVoting);
        List<Voting> testList = testDatabase.getVotings();
        
        assertTrue(testList.isEmpty());
        
    }

    /**
     * Test of addVotingRecord method, of class Database.
     */
    @Test
    public void testAddVotingRecord() {
        Database testDatabase = new Database();
       Voting testVoting = new Probation (1, "Joao", new Date(), new Date(), new String(), new String());
       VotingRecord testVotingRecord = new VotingRecord(1, testVoting, null, null, null);
       
       testDatabase.addVotingRecord(testVotingRecord);
       
       
    }
    
    @Test
    public void testGetAllClosedVotings() {
    	Database testDatabase = new Database();
        Voting testVoting1 = new Probation (1, "Joao", new Date(), new Date(), new String(), new String());
        Voting testVoting2 = new Probation (2, "Joao", new Date(), new Date(), new String(), new String());
        
        testDatabase.addVoting(testVoting1);
        testDatabase.addVoting(testVoting2);
        
        int expResult = 0;
        List<Voting> result = testDatabase.getAllClosedVotings();
        assertEquals(expResult, result.size());
        
        testVoting1.close();
        expResult = 1;
        result = testDatabase.getAllClosedVotings();
        assertEquals(expResult, result.size());

        testDatabase.recordVoting(testVoting2);
        expResult = 1;
        result = testDatabase.getAllClosedVotings();
        assertEquals(expResult, result.size());
        
        testVoting2.close();
        expResult = 2;
        result = testDatabase.getAllClosedVotings();
        assertEquals(expResult, result.size());
    }
    
    @Test
    public void testGetUnvotedClosedVotings() {
    	Database testDatabase = new Database();
    	VotingMember testMember = new VotingMember("Jão");
        Voting testVoting = new Probation (1, "Joao", new Date(), new Date(), new String(), new String());
        
        testDatabase.addVoting(testVoting);
        
        int expResult = 0;
        List<Voting> result = testDatabase.getUnvotedClosedVotings(testMember);
        assertEquals(expResult, result.size());
        
        testVoting.close();
        assertTrue(testVoting.isClosed());
        expResult = 1;
        result = testDatabase.getUnvotedClosedVotings(testMember);
        assertEquals(expResult, result.size());

        testVoting.addVote(new Vote(FAVORABLE, testMember, ""));
        expResult = 0;
        result = testDatabase.getUnvotedClosedVotings(testMember);
        assertEquals(expResult, result.size());
    }
    
}
