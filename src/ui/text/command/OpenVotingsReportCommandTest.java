package ui.text.command;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ui.text.Interface;
import data.Database;

public class OpenVotingsReportCommandTest {
	
	static Database testDatabase;
    static Interface testInterface;
    static OpenVotingsReportCommand testVotingsReport;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testVotingsReport = new OpenVotingsReportCommand(testDatabase, testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testVotingsReport = null;
    }

    /**
     * Test of OpenVotingCommand method, of class OpenVotingCommand.
     */
    @Test
    public void testOpenVotingCommand() {
        assertTrue(testVotingsReport instanceof OpenVotingsReportCommand);
    }

    /**
     * Test of toString method, of class OpenVotingCommand.
     */
    @Test
    public void testToString() {
      
        String expResult = "Open Votings Report";
        String result = testVotingsReport.toString();
        assertEquals(expResult, result);
        
    }
}
