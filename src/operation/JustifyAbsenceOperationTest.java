package operation;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ui.text.Interface;
import architecture.Probation;
import architecture.Voting;
import data.Database;

public class JustifyAbsenceOperationTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static Voting testVoting;
    static JustifyAbsenceOperation testJustifyAbsenceOperation;
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testVoting = new Probation(1, null, null, null, null, null);
        testJustifyAbsenceOperation = new JustifyAbsenceOperation(testDatabase, testInterface);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
        testDatabase = null;
        testInterface = null;
        testVoting = null;
        testJustifyAbsenceOperation = null;
	}

	@Test
	public void testJustifyAbsenceOperation() {
        assertTrue(testJustifyAbsenceOperation instanceof JustifyAbsenceOperation);
	}

}
