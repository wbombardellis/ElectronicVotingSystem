/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operation;

import architecture.Probation;
import data.Database;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import ui.text.Interface;

/**
 *
 * @author Igor
 */
public class AuthorizeVotingOperationTest {
     static AuthorizeVotingOperation testVotingAuthorization;
     static Database testDatabase;
     static Probation testVoting;
     static Interface testInterface;
     
       
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testVotingAuthorization = new AuthorizeVotingOperation(testDatabase,testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testVotingAuthorization = null;
        testDatabase = null;
        testVoting = null;
        testInterface = null;
    }

    /**
     * Test of AuthorizeVotingOperation method, of class AuthorizeVotingOperation.
     */
    @Test
    public void testAuthorizeVotingOperation() {
        assertTrue (testVotingAuthorization instanceof AuthorizeVotingOperation);
        
    }
    
}
