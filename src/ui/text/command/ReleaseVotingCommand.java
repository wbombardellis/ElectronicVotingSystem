/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.text.command;

import data.Database;
import operation.ReleaseVotingOperation;
import ui.text.Interface;

/**
 *
 * @author regesober
 */
public class ReleaseVotingCommand implements Command {
    
    private final Database database;
    private final Interface textInterface;
    
    public ReleaseVotingCommand(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
    
    @Override
    public void execute() {
        ReleaseVotingOperation releaseVotingOperation = new ReleaseVotingOperation(database, textInterface);
        releaseVotingOperation.execute();
    }
    
    @Override
    public String toString(){
        return "Release voting";
    }
    
}
