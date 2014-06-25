/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import architecture.ChiefMember;
import architecture.Member;
import architecture.SecretariatMember;
import architecture.Voting;
import architecture.VotingMember;
import architecture.VotingRecord;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ui.Login;

/**
 *
 * @author regesober
 */
public class Database {
    
    public static int votingIdCounter = 0;
    public static int votingRecordIdCounter = 0;
    
    private final List<Voting> recordedVotings;
    private final List<Voting> unrecordedVotings;
    private final Map<Login,Member> members;
    private final List<Voting> votings;
    private final List<VotingRecord> votingRecords;
    
    public Database(){
        Map<Login,Member> memberMap = loadHardCodedMembers();
        this.members = memberMap;
        this.recordedVotings = new ArrayList<>();
        this.unrecordedVotings = new ArrayList<>();
        this.votings = new ArrayList<>();
        this.votingRecords = new ArrayList<>();
    }
    
    private Map<Login,Member> loadHardCodedMembers(){
        Map<Login,Member> memberMap = new HashMap<>();
        memberMap.put(new Login(1,"TheFirst"), new ChiefMember("AlanTuring"));
        memberMap.put(new Login(2,"Path"), new ChiefMember("Dijkstra"));
        memberMap.put(new Login(3,"Parallel"), new SecretariatMember("C.A.R. Hoare"));
        memberMap.put(new Login(4,"Lambda"), new VotingMember("Alonzo Church"));
        memberMap.put(new Login(5,"fetch"), new VotingMember("John Von Neumann"));
        memberMap.put(new Login(6,"programming"), new VotingMember("Ada Lovelace"));
        memberMap.put(new Login(7,"Art7"), new VotingMember("Donals Knuth"));
        memberMap.put(new Login(8,"Eiffel"), new VotingMember("Bertrand Meyer"));
        memberMap.put(new Login(9,"Linux"), new VotingMember("Linus Torvals"));
        memberMap.put(new Login(10,"Mouse"), new VotingMember("Douglas Engelbart"));
        memberMap.put(new Login(11,"raM"), new VotingMember("Robert Dennard"));
        memberMap.put(new Login(12,"theCode!"), new VotingMember("Richard W. Hamming"));
        memberMap.put(new Login(13,"safety"), new VotingMember("Leslie Lamport"));
        return memberMap;
    }
    
    public Map<Login,Member> getMemberMap(){
        return members;
    }
    
    public Collection<Member> getMemberCollection(){
        return members.values();
    }
    
    public List<VotingMember> getVotingMembers(){
        List<VotingMember> votingMemberList = new ArrayList<>();
        for (Member member : getMemberCollection())
            if (member instanceof VotingMember)
                votingMemberList.add((VotingMember)member);
        return votingMemberList;
    }
    
    public List<Voting> getVotings(){
        return votings;
    }
    
    public List<Voting> getUnrecordedClosedVotings(){
        List<Voting> unrecordedClosedVotings = new ArrayList<>();
        for (Voting voting : unrecordedVotings)
            if (voting.isClosed())
                unrecordedClosedVotings.add(voting);
        return unrecordedClosedVotings;
    }
    
    public List<Voting> getUnrecordedUnclosedVotings(){
        List<Voting> unrecordedUnclosedVotings = new ArrayList<>();
        for (Voting voting : unrecordedVotings)
            if (!voting.isClosed())
                unrecordedUnclosedVotings.add(voting);
        return unrecordedUnclosedVotings;
    }
    
    public List<Voting> getUnauthorizedVotings(){
        List<Voting> unauthorizedVotings = new ArrayList<>();
        for (Voting voting : unrecordedVotings)
            if (!voting.isAuthorized())
                unauthorizedVotings.add(voting);
        return unauthorizedVotings;
    }
    
    public List<Voting> getUnrecordedUnopenVotings(){
        List<Voting> unrecordedUnopenVotings = new ArrayList<>();
        for (Voting voting : unrecordedVotings)
            if (!voting.hasStarted())
                unrecordedUnopenVotings.add(voting);
        return unrecordedUnopenVotings;
    }
    
    public List<Voting> getUnrecordedUnreleasedVotings(){
        List<Voting> unrecordedUnreleasedVotings = new ArrayList<>();
        for (Voting voting : unrecordedVotings)
            if (!voting.isReleased())
                unrecordedUnreleasedVotings.add(voting);
        return unrecordedUnreleasedVotings;
    }
    
    public List<Voting> getUnrecordedOpenAuthorizedReleasedVotings(){
        List<Voting> unrecordedOpenVotings = new ArrayList<>();
        for (Voting voting : unrecordedVotings)
            if (voting.hasStarted() && voting.isAuthorized() && voting.isReleased())
                unrecordedOpenVotings.add(voting);
        return unrecordedOpenVotings;
    }
    
    public List<Voting> getAllClosedVotings()
    {
    	List<Voting> closedVotings = new ArrayList<Voting>();
    	
    	for (Voting voting : unrecordedVotings)
    	{
			if (voting.isClosed())
			{
				closedVotings.add(voting);
			}
		}
    	for (Voting voting : recordedVotings)
    	{
			if (voting.isClosed())
			{
				closedVotings.add(voting);
			}
		}
    	
    	return closedVotings;
    }
    
    public void recordVoting(Voting voting){
        voting.record();
        recordedVotings.add(voting);
        unrecordedVotings.remove(voting);
    }
    
    public void addVoting(Voting voting){
        votings.add(voting);
        unrecordedVotings.add(voting);
    }
    
    public void deleteVoting(Voting voting){
        votings.remove(voting);
        if (voting.isRecorded())
            recordedVotings.remove(voting);
        else
            unrecordedVotings.remove(voting);
    }
    
    public void addVotingRecord(VotingRecord votingRecord){
        votingRecords.add(votingRecord);
    }
    
}
