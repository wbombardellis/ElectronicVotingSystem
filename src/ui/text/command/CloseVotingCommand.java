/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.text.command;

import data.Database;
import operation.CloseVotingOperation;
import ui.text.Interface;

/**
 *
 * @author regesober
 */
public class CloseVotingCommand implements Command {
    
    private final Database database;
    private final Interface textInterface;
    
    public CloseVotingCommand(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
    
    @Override
    public void execute() {
        CloseVotingOperation closeVotingOperation = new CloseVotingOperation(database, textInterface);
        closeVotingOperation.execute();
    }
    
    @Override
    public String toString(){
        return "Close voting";
    }
    
}
