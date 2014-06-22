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
public class MemberTest {
    
    static String testName;
    static Date testStartMandate;
    static Date testEndMandate;
    static Member testMember;
    
    @BeforeClass
    public static void setUpClass() {
        testName = "Joao";
        testStartMandate = new Date();
        testEndMandate = new Date();
        testMember = new VotingMember(testName);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testName = null;
        testStartMandate = null;
        testEndMandate = null;
        testMember = null;
    }

    @Test
    public void testMember() {
        assertTrue(testMember instanceof Member);
    }
    
    /**
     * Test of getName method, of class Member.
     */
    @Test
    public void testGetName() {
        String expResult = "Joao";
        String result = testMember.getName();
        assertEquals(expResult, result);
    }

    
    
}
