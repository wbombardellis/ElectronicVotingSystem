/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operation;

import architecture.Vote;
import architecture.Voting;
import data.Database;
import java.util.List;
import ui.text.Interface;

/**
 *
 * @author regesober
 */
public class DeleteVotingOperation implements Operation {
    
    private final Database database;
    private final Interface textInterface;
    
    public DeleteVotingOperation(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
    
    @Override
    public void execute() {
        List<Voting> votings = database.getVotings();
        Voting chosenVoting;
        textInterface.showVotings(votings);
        chosenVoting = textInterface.chooseVoting(votings);
        if (chosenVoting != null){
            List<Vote> voteList = chosenVoting.getVotes();
            boolean noComputedVotes = voteList.isEmpty();
            if (!noComputedVotes){
                boolean delete = textInterface.confirmDelete();
                if (delete)
                    database.deleteVoting(chosenVoting);
            }
            else
                database.deleteVoting(chosenVoting);
        }
    }
    
}
