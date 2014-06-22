/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package architecture;

import java.util.List;
import ui.text.UIUtils;

/**
 *
 * @author regesober
 */
public class VotingRecord {
    
    private final int id;
    private final Voting voting;
    private final List<VotingMember> membersWhoVoted;
    private final List<VotingMember> membersWhoDidNotVote;
    private final List<VotingMember> abstentions;
    
    public VotingRecord(int id, Voting voting, List<VotingMember> membersWhoVoted, List<VotingMember> membersWhoDidNotVote, List<VotingMember> abstentions){
        this.id = id;
        this.voting = voting;
        this.membersWhoVoted = membersWhoVoted;
        this.membersWhoDidNotVote = membersWhoDidNotVote;
        this.abstentions = abstentions;
    }
    
    public boolean getResult(){
        int favorableVotes = 0;
        int numberOfAbstentions = this.abstentions.size();
        List<Vote> votes = voting.getVotes();
        for (Vote vote : votes){
            VoteType voteType = vote.getType();
            if (voteType.equals(VoteType.FAVORABLE))
                favorableVotes++;
        }
        boolean votingClosedManually = voting.wasClosedManually();
        boolean votingResult;
        int numberOfVotingMembers;
        if (votingClosedManually){
            numberOfVotingMembers = membersWhoVoted.size();
            votingResult = (favorableVotes > (numberOfVotingMembers-numberOfAbstentions));
        }
        else{
            numberOfVotingMembers = membersWhoVoted.size() + membersWhoDidNotVote.size();
            votingResult = (favorableVotes > (numberOfVotingMembers-numberOfAbstentions));
        }
        return votingResult;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(id).append("\n");
        sb.append("End date: ").append(UIUtils.INSTANCE.formatDate(voting.getEndDate())).append("\n");
        sb.append("Voting description:\n").append(voting).append("\n");
        sb.append("Members who voted:");
        for (VotingMember memberWhoVoted : membersWhoVoted){
            sb.append("\n").append(memberWhoVoted.getName());
        }
        sb.append("\n").append("Members who did not vote:");
        for (VotingMember memberWhoDidNotVote : membersWhoDidNotVote){
            sb.append("\n").append(memberWhoDidNotVote.getName());
        }
        sb.append("\n").append("Result: ");
        boolean result = getResult();
        if (result == true)
            sb.append("Approved");
        else
            sb.append("Not approved");
        sb.append("\n").append("Abstentions:");
        for (VotingMember abstention : abstentions){
            sb.append("\n").append(abstention.getName());
        }
        return sb.toString();
    }
    
}
