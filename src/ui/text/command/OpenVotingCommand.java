/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.text.command;

import data.Database;
import operation.OpenVotingOperation;
import ui.text.Interface;

/**
 *
 * @author regesober
 */
public class OpenVotingCommand implements Command {
    
    private final Database database;
    private final Interface textInterface;
    
    public OpenVotingCommand(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
    
    @Override
    public void execute() {
        OpenVotingOperation openVotingOperation = new OpenVotingOperation(database, textInterface);
        openVotingOperation.execute();
    }
    
    @Override
    public String toString(){
        return "Open voting";
    }
    
}
