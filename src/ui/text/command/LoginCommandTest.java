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
public class LoginCommandTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static LoginCommand testLogin;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testLogin = new LoginCommand(testDatabase, testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testLogin = null;
    }

    /**
     * Test of LoginCommand method, of class LoginCommand.
     */
    @Test
    public void testLoginCommand() {
      assertTrue(testLogin instanceof LoginCommand);
    }
    
}
