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
public class GenerateVotingRecordCommandTest {
    
   static Database testDatabase;
    static Interface testInterface;
    static GenerateVotingRecordCommand testGenerate;
    
    @BeforeClass
    public static void setUpClass() {
        testDatabase = new Database();
        testInterface = new Interface(testDatabase);
        testGenerate = new GenerateVotingRecordCommand(testDatabase, testInterface);
    }
    
    @AfterClass
    public static void tearDownClass() {
        testDatabase = null;
        testInterface = null;
        testGenerate = null;
    }

    /**
     * Test of GenerateVotingRecordCommand method, of class GenerateVotingRecordCommand.
     */
    @Test
    public void testGenerateVotingRecordCommand() {
       
        assertTrue(testGenerate instanceof GenerateVotingRecordCommand);
    }

    /**
     * Test of toString method, of class GenerateVotingRecordCommand.
     */
    @Test
    public void testToString() {
        
        String expResult = "Generate voting record";
        String result = testGenerate.toString();
        assertEquals(expResult, result);
        
    }
    
}
