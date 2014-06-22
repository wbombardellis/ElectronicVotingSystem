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
public class ReleaseVotingCommandTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static ReleaseVotingCommand testRelease;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testRelease = new ReleaseVotingCommand(testDatabase, testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testRelease = null;
    }

    /**
     * Test of ReleaseVotingCommand method, of class ReleaseVotingCommand.
     */
    @Test
    public void testReleaseVotingCommand() {
        assertTrue(testRelease instanceof ReleaseVotingCommand);
    }

    /**
     * Test of toString method, of class ReleaseVotingCommand.
     */
    @Test
    public void testToString() {
     
        String expResult = "Release voting";
        String result = testRelease.toString();
        assertEquals(expResult, result);
        
    }
    
}
