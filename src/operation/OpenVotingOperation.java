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
public class OpenVotingOperation implements Operation {
    
    private final Database database;
    private final Interface textInterface;
    
    public OpenVotingOperation(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
    
    @Override
    public void execute() {
        List<Voting> unrecordedUnopenVotings = database.getUnrecordedUnopenVotings();
        Voting chosenVoting;
        textInterface.showVotings(unrecordedUnopenVotings);
        chosenVoting = textInterface.chooseVoting(unrecordedUnopenVotings);
        if (chosenVoting != null){
            chosenVoting.open();
            boolean everyVotingMemberVoted = chosenVoting.getVotes().size() == database.getVotingMembers().size();
            if (!everyVotingMemberVoted)
                textInterface.showWarning("Some voting members did not vote.");
        }
    }
    
}
