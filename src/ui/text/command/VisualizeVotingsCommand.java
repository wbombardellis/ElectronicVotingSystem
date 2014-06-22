/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.text.command;

import data.Database;
import operation.VisualizeVotingsOperation;
import ui.text.Interface;

/**
 *
 * @author regesober
 */
public class VisualizeVotingsCommand implements Command {
    
    private final Database database;
    private final Interface textInterface;
    
    public VisualizeVotingsCommand(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
    
    @Override
    public void execute() {
        VisualizeVotingsOperation visualizeVotingsOperation = new VisualizeVotingsOperation(database, textInterface);
        visualizeVotingsOperation.execute();
    }
    
    @Override
    public String toString(){
        return "Visualize all votings";
    }
    
}
