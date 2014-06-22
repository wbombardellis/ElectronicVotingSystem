/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operation;

import data.Database;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ui.text.Interface;

/**
 *
 * @author Igor
 */
public class CreateLeaveCountryOperationTest {
    static Database testDatabase;
    static Interface testInterface;
    static Date testStartDate; 
    static Date testEndDate;
    static String testInvitationLetter;
    static String testTranslatedLetter;
    static String testTicket;
    static CreateLeaveCountryOperation testLeaveCountryCreation;
    
   
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testStartDate = new Date();
        testEndDate = new Date();
        testInvitationLetter = new String();
        testTranslatedLetter = new String();
        testTicket = new String();
        testLeaveCountryCreation = new CreateLeaveCountryOperation(testDatabase, testInterface, testStartDate, testEndDate, testInvitationLetter, testTranslatedLetter, testTicket);
           
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testStartDate = null;
        testEndDate = null;
        testInvitationLetter = null;
        testTranslatedLetter = null;
        testTicket = null;
        testLeaveCountryCreation = null;
    }

    /**
     * Test of CreateLeaveCountryOperation method, of class CreateLeaveCountryOperation.
     */
    @Test
    public void testCreateLeaveCountryOperation() {
       assertTrue(testLeaveCountryCreation instanceof CreateLeaveCountryOperation);
    }
    
    @Test
    public void testDocumentsOk () throws NoSuchMethodException, IllegalAccessException, InvocationTargetException { 
        Class params[] = {};
        
        Method methodDocumentsOk = testLeaveCountryCreation.getClass().getDeclaredMethod("documentsOk", params);
        methodDocumentsOk.setAccessible(true);
        assertFalse((boolean) methodDocumentsOk.invoke(testLeaveCountryCreation));
        
    }
    
}
