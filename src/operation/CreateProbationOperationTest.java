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
public class CreateProbationOperationTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static Date testStartDate; 
    static Date testEndDate;
    static String testTeacherReport;
    static String testTutorReport;
    static CreateProbationOperation testProbationCreation;
        
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testStartDate = new Date();
        testEndDate = new Date();
        testTeacherReport = new String();
        testTutorReport = new String();
        testProbationCreation = new CreateProbationOperation(testDatabase, testInterface, testStartDate, testEndDate, testTeacherReport, testTutorReport);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testStartDate = null;
        testEndDate = null;
        testTeacherReport = null;
        testTutorReport = null;
        testProbationCreation = null;
    }

    /**
     * Test of CreateProbationOperation method, of class CreateProbationOperation.
     */
    @Test
    public void testCreateProbationOperation() {
        assertTrue(testProbationCreation instanceof CreateProbationOperation);
    }

    @Test
    public void testDocumentsOk () throws NoSuchMethodException, IllegalAccessException, InvocationTargetException { 
        Class params[] = {};
        
        Method methodDocumentsOk = testProbationCreation.getClass().getDeclaredMethod("documentsOk", params);
        methodDocumentsOk.setAccessible(true);
        assertFalse((boolean) methodDocumentsOk.invoke(testProbationCreation));
        
    }
}
