/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.text.command;

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
public class VoteCommandTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static VoteCommand testVote;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testVote = new VoteCommand(testDatabase, testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testVote = null;
    }

    /**
     * Test of VoteCommand method, of class VoteCommand.
     */
    @Test
    public void testVoteCommand() {
      assertTrue(testVote instanceof VoteCommand);
    }

    /**
     * Test of toString method, of class VoteCommand.
     */
    @Test
    public void testToString() {
       
        String expResult = "Vote";
        String result = testVote.toString();
        assertEquals(expResult, result);
       
    }
    
}
