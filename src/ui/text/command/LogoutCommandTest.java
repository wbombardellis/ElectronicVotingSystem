/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.text.command;

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
public class LogoutCommandTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static LogoutCommand testLogout;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testLogout = new LogoutCommand(testDatabase, testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testLogout = null;
    }

    /**
     * Test of LogoutCommand method, of class LogoutCommand.
     */
    @Test
    public void testLogoutCommand() {
        assertTrue(testLogout instanceof LogoutCommand);
    }

    /**
     * Test of toString method, of class LogoutCommand.
     */
    @Test
    public void testToString() {
        String expResult = "Logout";
        String result = testLogout.toString();
        assertEquals(expResult, result);
        
    }
    
}
