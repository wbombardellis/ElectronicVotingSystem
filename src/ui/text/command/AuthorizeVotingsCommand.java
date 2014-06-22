/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.text.command;

import data.Database;
import operation.AuthorizeVotingOperation;
import ui.text.Interface;

/**
 *
 * @author regesober
 */
public class AuthorizeVotingsCommand implements Command {
    
    private final Database database;
    private final Interface textInterface;
    
    public AuthorizeVotingsCommand(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
    
    @Override
    public void execute() {
        AuthorizeVotingOperation authorizeVotingOperation = new AuthorizeVotingOperation(database, textInterface);
        authorizeVotingOperation.execute();
    }
    
    @Override
    public String toString(){
        return "Authorize votings";
    }
    
}
