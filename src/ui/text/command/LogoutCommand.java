/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.text.command;

import data.Database;
import operation.LogoutOperation;
import ui.text.Interface;

/**
 *
 * @author regesober
 */
public class LogoutCommand implements Command {
    
    private final Database database;
    private final Interface textInterface;
    
    public LogoutCommand(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
    
    @Override
    public void execute() {
        LogoutOperation logoutOperation = new LogoutOperation(database, textInterface);
        logoutOperation.execute();
    }
    
    @Override
    public String toString(){
        return "Logout";
    }
    
}
