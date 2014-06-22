/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operation;

import architecture.Voting;
import data.Database;
import java.util.List;
import ui.text.Interface;

/**
 *
 * @author regesober
 */
public class VisualizeVotingOperation implements Operation {
    
    private final Database database;
    private final Interface textInterface;
    
    public VisualizeVotingOperation(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
    
    @Override
    public void execute() {
        List<Voting> votings = database.getVotings();
        Voting chosenVoting;
        textInterface.showVotings(votings);
        chosenVoting = textInterface.chooseVoting(votings);
        if (chosenVoting != null)
            textInterface.showVoting(chosenVoting);
    }
    
}
