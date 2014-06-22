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
public class LoginOperationTest {
    
    static Database testDatabase;
    static Interface testInterface;    
    static int testAccessCode;
    static String testPassword;
    static LoginOperation testLogin;
    
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testAccessCode = 1;
        testPassword = new String();
        testLogin = new LoginOperation(testDatabase, testInterface, testAccessCode, testPassword);        
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testPassword = null;
        testLogin = null;
    }

    /**
     * Test of LoginOperation method, of class LoginOperation.
     */
    @Test
    public void testLoginOperation() {
       assertTrue(testLogin instanceof LoginOperation);
    }
    
}
