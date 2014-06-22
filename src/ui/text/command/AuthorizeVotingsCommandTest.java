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
public class AuthorizeVotingsCommandTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static AuthorizeVotingsCommand testAuthorizeVotings;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testAuthorizeVotings = new AuthorizeVotingsCommand(testDatabase, testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testAuthorizeVotings = null;
    }

    /**
     * Test of AuthorizeVotingsCommand method, of class AuthorizeVotingsCommand.
     */
    @Test
    public void testAuthorizeVotingsCommand() {
        assertTrue(testAuthorizeVotings instanceof AuthorizeVotingsCommand);
    }

    /**
     * Test of toString method, of class AuthorizeVotingsCommand.
     */
    @Test
    public void testToString() {
        String expResult = "Authorize votings";
        String result = testAuthorizeVotings.toString();
        assertEquals(expResult, result);
       
    }
    
}
