/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.text.command;

import data.Database;
import operation.VisualizeVotingOperation;
import ui.text.Interface;

/**
 *
 * @author regesober
 */
public class VisualizeVotingCommand implements Command {
    
    private final Database database;
    private final Interface textInterface;
    
    public VisualizeVotingCommand(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
    
    @Override
    public void execute() {
        VisualizeVotingOperation visualizeVotingOperation = new VisualizeVotingOperation(database, textInterface);
        visualizeVotingOperation.execute();
    }
    
    @Override
    public String toString(){
        return "Visualize voting";
    }
    
}
