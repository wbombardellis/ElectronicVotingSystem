/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.text.command;

import architecture.VoteType;
import architecture.Voting;
import architecture.VotingMember;
import data.Database;
import java.util.Iterator;
import java.util.List;
import operation.VoteOperation;
import ui.text.Interface;
import ui.text.UIUtils;

/**
 *
 * @author regesober
 */
public class VoteCommand implements Command {
    
    private static final int FAVORABLE = 1;
    private static final int NOT_FAVORABLE = 2;
    private static final int ABSTENTION = 3;
    
    private final Database database;
    private final Interface textInterface;
    
    public VoteCommand(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
    
    @Override
    public void execute() {
        List<Voting> votings;
        votings = database.getUnrecordedOpenAuthorizedReleasedVotings();
        Iterator<Voting> it = votings.iterator();
        Voting voting;
        while (it.hasNext()){
            voting = it.next();
            boolean alreadyVotedInThisVoting = voting.getMembersWhoVoted().contains((VotingMember)textInterface.getCurrentMember());
            if (alreadyVotedInThisVoting)
                it.remove();
        }
        textInterface.showVotings(votings);
        
        if (votings.size() > 0)
        {
        	Voting chosenVoting;
            chosenVoting = textInterface.chooseVoting(votings);
            showVoteOptions();
            int choice = UIUtils.INSTANCE.readInteger("Vote option", 1, 3);
            VoteType voteType = null;
            switch(choice){
                case FAVORABLE:
                    voteType = VoteType.FAVORABLE;
                    break;
                case NOT_FAVORABLE:
                    voteType = VoteType.NOT_FAVORABLE;
                    break;
                case ABSTENTION:
                    voteType = VoteType.ABSTENTION;
                    break;
            }
            String explanation = UIUtils.INSTANCE.readString("Explanation(optional)");
            VotingMember votingMember = (VotingMember)textInterface.getCurrentMember();
            VoteOperation voteOperation = new VoteOperation(database,textInterface,chosenVoting,voteType, votingMember, explanation);
            voteOperation.execute();
        }
    }
    
    @Override
    public String toString(){
        return "Vote";
    }

    private void showVoteOptions() {
        System.out.println("1 - Favorable");
        System.out.println("2 - Not Favorable");
        System.out.println("3 - Abstention");
    }
    
}
