package ui.text.command;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ui.text.Interface;
import data.Database;

public class JustifyAbsenceCommandTest {

	static Database testDatabase;
    static Interface testInterface;
    static JustifyAbsenceCommand testJustify;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testJustify = new JustifyAbsenceCommand(testDatabase, testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testJustify = null;
    }

    /**
     * Test of OpenVotingCommand method, of class OpenVotingCommand.
     */
    @Test
    public void testOpenVotingCommand() {
        assertTrue(testJustify instanceof JustifyAbsenceCommand);
    }

    /**
     * Test of toString method, of class OpenVotingCommand.
     */
    @Test
    public void testToString() {
      
        String expResult = "Justify absence";
        String result = testJustify.toString();
        assertEquals(expResult, result);
        
    }

}
