/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package architecture;

import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Igor
 */
public class ProbationTest {
    
    static String testAuthor;
    static Date testStartDate;
    static Date testEndDate;
    static String testTeacherReport;
    static String testTutorReport;
    static Probation testProbation;
    
    @BeforeClass
    public static void setUpClass() {
        int id = 2;
        testAuthor = new String ();
        testStartDate = new Date();
        testEndDate = new Date();
        testTeacherReport = new String();
        testTutorReport = new String();
        testProbation = new Probation(id, testAuthor, testStartDate, testEndDate, testTeacherReport, testTutorReport);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testAuthor = null;
        testStartDate = null;
        testEndDate = null;
        testTeacherReport = null;
        testTutorReport = null;
        testProbation = null;
    }

    @Test
    public void testProbation () {
        assertTrue(testProbation instanceof Probation);      
    }
    
    /**
     * Test of toString method, of class Probation.
     */
    @Test
    public void testToString() {
        String expResult = "Voting id: 2\n" +
                            "Type: Probation\n" +
                            "Teacher Report: \n" +
                            "Tutor Report: ";
        String result = testProbation.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of missingDocuments method, of class Probation.
     */
    @Test
    public void testMissingDocuments() {
        boolean expResult = false;
        boolean result = testProbation.missingDocuments();
        assertEquals(expResult, result);
    }
    
}
