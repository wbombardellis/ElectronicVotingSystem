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
public class CloseVotingOperation implements Operation {

    private final Database database;
    private final Interface textInterface;
    
    public CloseVotingOperation(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
    
    @Override
    public void execute() {
        List<Voting> unclosedVotings = database.getUnrecordedUnclosedVotings();
        Voting chosenVoting;
        textInterface.showVotings(unclosedVotings);
        chosenVoting = textInterface.chooseVoting(unclosedVotings);
        if (chosenVoting != null)
        {
        	if (chosenVoting.getVotes().size() >= 8)
        	{
        		chosenVoting.close();
        		textInterface.showWarning("The voting has been closed.");
        	}
        	else
        	{
        		textInterface.showWarning("The voting cannot be closed because there are not enough votes!");
        		textInterface.showWarning("Current votes = " + chosenVoting.getVotes().size() + ". Minimum: 8.s");
        	}
        }
    }
    
}
