package architecture;

import java.util.Date;
import ui.text.UIUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author regesober
 */
public class Vote {
    
    private final VoteType type;
    private final VotingMember votingMember;
    private final Date date;
    private String optionalExplanation;
    
    public Vote(VoteType type, VotingMember votingMember, String optionalExplanation){
        this.type = type;
        this.votingMember = votingMember;
        this.date = new Date();
        this.optionalExplanation = optionalExplanation;
    }
    
    public VotingMember getVotingMember(){
        return votingMember;
    }
    
    public VoteType getType(){
        return type;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        switch (type){
            case FAVORABLE:
                sb.append("Vote: FAVORABLE");
                break;
            case NOT_FAVORABLE:
                sb.append("Vote: NOT FAVORABLE");
                break;
            case ABSTENTION:
                sb.append("Vote: ABSTENTION");
                break;
        }
        String author = votingMember.getName();
        sb.append("\n").append("Author: ").append(author);
        sb.append("\n").append("Date: ").append(UIUtils.INSTANCE.formatDate(date));
        if (optionalExplanation != null)
            sb.append("\n").append(optionalExplanation);
        return sb.toString();
    }
    
}
