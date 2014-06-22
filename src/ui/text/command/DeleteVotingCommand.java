/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.text.command;

import data.Database;
import operation.DeleteVotingOperation;
import ui.text.Interface;

/**
 *
 * @author regesober
 */
public class DeleteVotingCommand implements Command {
    
    private final Database database;
    private final Interface textInterface;
    
    public DeleteVotingCommand(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
    
    @Override
    public void execute() {
        DeleteVotingOperation deleteVotingOperation = new DeleteVotingOperation(database, textInterface);
        deleteVotingOperation.execute();
    }
    
    @Override
    public String toString(){
        return "Delete voting";
    }
    
}
