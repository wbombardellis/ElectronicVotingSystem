package ui.text.command;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ui.text.Interface;
import data.Database;

public class JustifiedAbsenceReportCommandTest {

	static Database testDatabase;
    static Interface testInterface;
    static JustifiedAbsenceReportCommand testJustifyReport;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testJustifyReport = new JustifiedAbsenceReportCommand(testDatabase, testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testJustifyReport = null;
    }

    /**
     * Test of OpenVotingCommand method, of class OpenVotingCommand.
     */
    @Test
    public void testOpenVotingCommand() {
        assertTrue(testJustifyReport instanceof JustifiedAbsenceReportCommand);
    }

    /**
     * Test of toString method, of class OpenVotingCommand.
     */
    @Test
    public void testToString() {
      
        String expResult = "Justified Absence Report";
        String result = testJustifyReport.toString();
        assertEquals(expResult, result);
        
    }

}
