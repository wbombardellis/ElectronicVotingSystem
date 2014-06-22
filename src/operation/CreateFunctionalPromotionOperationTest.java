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
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import ui.text.Interface;

/**
 *
 * @author Igor
 */
public class CreateFunctionalPromotionOperationTest {
    static Database testDatabase;
    static Interface testInterface;
    static Date testStartDate; 
    static Date testEndDate;
    static String testDescriptiveMemorandum;
    static String testScoreSheet;
    static String testVouchers;
    static CreateFunctionalPromotionOperation testFunctionalPromotionCreation;
    
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testStartDate = new Date();
        testEndDate = new Date();
        testDescriptiveMemorandum = new String();
        testScoreSheet = new String();
        testVouchers = new String();
        testFunctionalPromotionCreation = new CreateFunctionalPromotionOperation (testDatabase, testInterface, testStartDate, testEndDate, testDescriptiveMemorandum, testScoreSheet, testVouchers);       
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testStartDate = null;
        testEndDate = null;
        testDescriptiveMemorandum = null;
        testScoreSheet = null;
        testVouchers = null;
        testFunctionalPromotionCreation = null;
    }

    /**
     * Test of CreateFunctionalPromotionOperation method, of class CreateFunctionalPromotionOperation.
     */
    @Test
    public void testCreateFunctionalPromotionOperation() {
        assertTrue (testFunctionalPromotionCreation instanceof CreateFunctionalPromotionOperation);
    }
    
    @Test
    public void testDocumentsOk () throws NoSuchMethodException, IllegalAccessException, InvocationTargetException { 
        Class params[] = {};
        
        Method methodDocumentsOk = testFunctionalPromotionCreation.getClass().getDeclaredMethod("documentsOk", params);
        methodDocumentsOk.setAccessible(true);
        assertFalse((boolean) methodDocumentsOk.invoke(testFunctionalPromotionCreation));
        
    }
    
    
}
