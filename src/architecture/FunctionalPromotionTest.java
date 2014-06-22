/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package architecture;

import java.util.Date;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Igor
 */
public class FunctionalPromotionTest {
    
    static String testAuthor;
    static Date testStartDate;
    static Date testEndDate;
    static String testDescriptiveMemorandum;
    static String testScoreSheet;
    static String testVouchers;
    static FunctionalPromotion testFunctionalPromotion;
    
    @BeforeClass
    public static void setUpClass() {
        int id = 1;
        testAuthor = new String ();
        testStartDate = new Date();
        testEndDate = new Date();
        testDescriptiveMemorandum = new String();
        testScoreSheet = new String();
        testVouchers = new String();
        testFunctionalPromotion = new FunctionalPromotion(id, testAuthor, testStartDate, testEndDate, testDescriptiveMemorandum, testScoreSheet, testVouchers);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testAuthor = null;
        testStartDate = null;
        testEndDate = null;
        testDescriptiveMemorandum = null;
        testScoreSheet = null;
        testVouchers = null;
    }

    
    @Test
    public void testFunctionalPromotion () {
        assertTrue(testFunctionalPromotion instanceof FunctionalPromotion);     
    }
    
    /**
     * Test of toString method, of class FunctionalPromotion.
     */
    @Test
    public void testToString() {
        String expResult = "Voting id: 1\n" +
                            "Type: Functional Promotion\n" +
                            "Descriptive Memorandum: \n" +
                            "Score Sheet: \n" +
                            "Vouchers: ";
        String result = testFunctionalPromotion.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of missingDocuments method, of class FunctionalPromotion.
     */
    @Test
    public void testMissingDocuments() {
        boolean expResult = false;
        boolean result = testFunctionalPromotion.missingDocuments();
        assertEquals(expResult, result);
        
    }
    
}
