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
public class DeleteVotingCommandTest {
    
    static Database testDatabase;
    static Interface testInterface;
    static DeleteVotingCommand testDelete;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testDelete = new DeleteVotingCommand(testDatabase, testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testDelete = null;
    }

    /**
     * Test of DeleteVotingCommand method, of class DeleteVotingCommand.
     */
    @Test
    public void testDeleteVotingCommand() {
       assertTrue(testDelete instanceof DeleteVotingCommand );
    }

    /**
     * Test of toString method, of class DeleteVotingCommand.
     */
    @Test
    public void testToString() {
        String expResult = "Delete voting";
        String result = testDelete.toString();
        assertEquals(expResult, result);
        
    }
    
}
