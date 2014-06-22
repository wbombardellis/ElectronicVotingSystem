/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.text.command;

import data.Database;
import operation.GenerateVotingRecordOperation;
import ui.text.Interface;

/**
 *
 * @author regesober
 */
public class GenerateVotingRecordCommand implements Command {
    
    private final Database database;
    private final Interface textInterface;
    
    public GenerateVotingRecordCommand(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
    
    @Override
    public void execute() {
        GenerateVotingRecordOperation generateVotingRecordOperation = new GenerateVotingRecordOperation(database, textInterface);
        generateVotingRecordOperation.execute();
    }
    
    @Override
    public String toString(){
        return "Generate voting record";
    }
    
}
