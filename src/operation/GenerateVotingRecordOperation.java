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
import architecture.VotingRecord;
import data.Database;
import java.util.ArrayList;
import java.util.List;
import ui.text.Interface;

/**
 *
 * @author regesober
 */
public class GenerateVotingRecordOperation implements Operation {
    
    private final Database database;
    private final Interface textInterface;
    
    public GenerateVotingRecordOperation(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
    
    @Override
    public void execute() {
        Voting chosenVoting = chooseVoting();
        if (chosenVoting != null){
            database.recordVoting(chosenVoting);
            int votingRecordId = Database.votingRecordIdCounter++;
            List<Vote> votes = chosenVoting.getVotes();
            List<VotingMember> membersWhoVoted = new ArrayList<>();
            List<VotingMember> abstentions = new ArrayList<>();
            for (Vote vote : votes){
                VotingMember votingMember = vote.getVotingMember();
                membersWhoVoted.add(votingMember);
                VoteType voteType = vote.getType();
                if (voteType == VoteType.ABSTENTION)
                    abstentions.add(votingMember);
            }
            List<VotingMember> votingMembers = database.getVotingMembers();
            List<VotingMember> membersWhoDidNotVote = new ArrayList<>(votingMembers);
            membersWhoDidNotVote.removeAll(membersWhoVoted);
            VotingRecord votingRecord = new VotingRecord(votingRecordId, chosenVoting, membersWhoVoted, membersWhoDidNotVote, abstentions);
            database.addVotingRecord(votingRecord);
            System.out.println(votingRecord);
        }
    }
    
    private Voting chooseVoting(){
        List<Voting> unrecordedClosedVotings = database.getUnrecordedClosedVotings();
        textInterface.showVotings(unrecordedClosedVotings);
        Voting chosenVoting;
        chosenVoting = textInterface.chooseVoting(unrecordedClosedVotings);
        return chosenVoting;
    }
}
