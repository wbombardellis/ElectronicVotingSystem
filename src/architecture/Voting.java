package architecture;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author regesober
 */

public abstract class Voting {
    
    private final int id;
    private final String author;
    private Date startDate;
    private Date endDate;
    private boolean authorized;
    private boolean recorded;
    private boolean released;
    private final List<Vote> votes;
    private boolean closed = false;
    private boolean closedManually = false;
    private final List<VotingMember> membersWhoVoted;
    
    public Voting(int id, String author, Date startDate, Date endDate){
        this.id = id;
        this.author = author;
        this.endDate = endDate;
        this.startDate = startDate;
        this.authorized = false;
        this.recorded = false;
        this.released = false;
        this.votes = new ArrayList<>();
        this.membersWhoVoted = new ArrayList<>();
    }
    
    public int getId(){
        return id;
    }
    
    public List<VotingMember> getMembersWhoVoted(){
        return membersWhoVoted;
    }
    
    public boolean isClosed(){
        Date currentDate = new Date();
        this.closed = currentDate.after(endDate) || this.closedManually;
        return this.closed;
    }
    
    public void close(){
        Date currentDate = new Date();
        this.endDate = currentDate;
        this.closedManually = true;
        this.closed = true;
    }
    
    public boolean isAuthorized(){
        return authorized;
    }
    
    public void authorize(){
        this.authorized = true;
    }
    
    public boolean isRecorded(){
        return recorded;
    }
    
    public void record(){
    	this.closed = true;
        this.recorded = true;
    }
    
    public boolean isReleased(){
        return released;
    }
    
    public void release(){
        this.released = true;
    }
    
    public void addVote(Vote vote){
        this.votes.add(vote);
        this.membersWhoVoted.add(vote.getVotingMember());
    }
    
    public Date getStartDate(){
        return startDate;
    }
    
    public Date getEndDate(){
        return endDate;
    }
    
    public boolean hasStarted(){
        return startDate.before(new Date());
    }
    
    public boolean wasClosedManually(){
        return closedManually;
    }
    
    public void open(){
        this.startDate = new Date();
    }
    
    public List<Vote> getVotes(){
        return votes;
    }
    
    public abstract boolean missingDocuments();

}
