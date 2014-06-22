/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operation;

import data.Database;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ui.text.Interface;

/**
 *
 * @author Igor
 */
public class LogoutOperationTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static LogoutOperation testLogout;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testLogout = new LogoutOperation(testDatabase, testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testLogout = null;
    }

    /**
     * Test of LogoutOperation method, of class LogoutOperation.
     */
    @Test
    public void testLogoutOperation() {
        assertTrue(testLogout instanceof LogoutOperation);
    }
    
}
