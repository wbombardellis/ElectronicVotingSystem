/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operation;

import architecture.Vote;
import architecture.VoteType;
import architecture.Voting;
import architecture.VotingMember;
import data.Database;
import ui.text.Interface;

/**
 *
 * @author regesober
 */
public class VoteOperation implements Operation {
    
    private final Database database;
    private final Interface textInterface;
    private final String explanation;
    private final VoteType voteType;
    private final VotingMember votingMember;
    private final Voting voting;
    
    public VoteOperation(Database database, Interface textInterface, Voting voting, VoteType voteType, VotingMember votingMember, String explanation){
        this.database = database;
        this.textInterface = textInterface;
        this.explanation = explanation;
        this.voteType = voteType;
        this.votingMember = votingMember;
        this.voting = voting;
    }
    
    @Override
    public void execute() {
        Vote vote = new Vote(voteType,votingMember,explanation);
        voting.addVote(vote);
    }
    
}
