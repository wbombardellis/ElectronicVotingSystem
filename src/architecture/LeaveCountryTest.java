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
public class LeaveCountryTest {
    
    static String testAuthor;
    static Date testStartDate;
    static Date testEndDate;
    static String testInvitationLetter;
    static String testTranslatedLetter;
    static String testTicket;
    static LeaveCountry testLeaveCountry;
    
    @BeforeClass
    public static void setUpClass() {
        int id = 1;
        testAuthor = new String ();
        testStartDate = new Date();
        testEndDate = new Date();
        testInvitationLetter = new String ();
        testTranslatedLetter = new String();
        testTicket = new String();
        testLeaveCountry = new LeaveCountry (id, testAuthor, testStartDate, testEndDate, testInvitationLetter, testTranslatedLetter, testTicket);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testAuthor = null;
        testStartDate = null;
        testEndDate = null;
        testInvitationLetter = null;
        testTranslatedLetter = null;
        testTicket = null;
        testLeaveCountry = null;
    }

    
    @Test
    public void testLeaveCountry() {
        assertTrue(testLeaveCountry instanceof LeaveCountry);
    }
    
    /**
     * Test of toString method, of class LeaveCountry.
     */
    @Test
    public void testToString() {
        String expResult = "Voting id: 1\n" +
                            "Type: Leave Country\n" +
                            "Invitation Letter: \n" +
                            "Translated Letter: \n" +
                            "Ticket: ";
        String result = testLeaveCountry.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of missingDocuments method, of class LeaveCountry.
     */
    @Test
    public void testMissingDocuments() {
        boolean expResult = false;
        boolean result = testLeaveCountry.missingDocuments();
        assertEquals(expResult, result);
    }
    
}
