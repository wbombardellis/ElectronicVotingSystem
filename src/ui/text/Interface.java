/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.text;

import architecture.ChiefMember;
import architecture.Member;
import architecture.Vote;
import architecture.Voting;
import architecture.VotingMember;
import data.Database;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ui.Login;
import ui.text.command.AuthorizeVotingsCommand;
import ui.text.command.CloseVotingCommand;
import ui.text.command.Command;
import ui.text.command.CreateVotingCommand;
import ui.text.command.DeleteVotingCommand;
import ui.text.command.GenerateVotingRecordCommand;
import ui.text.command.OpenVotingCommand;
import ui.text.command.VisualizeVotingCommand;
import ui.text.command.VisualizeVotingsCommand;
import ui.text.command.VoteCommand;

/**
 *
 * @author regesober
 */
public class Interface {
    
    private final static String EXIT_CODE = "E";
    
    private Member currentMember;
    private final Database database;
    private final Map<String,Command> commands;
    
    public Interface (Database database){
        this.database = database;
        this.commands = new HashMap<>();
    }
    
    public boolean login (Login login){
        Map<Login,Member> memberMap = database.getMemberMap();
        Member member = memberMap.get(login);
        if (member == null)
            return false;
        currentMember = member;
        if (currentMember instanceof VotingMember){
            if (currentMember instanceof ChiefMember){
                addAllChiefCommands();
            }
            else{
                addAllVotingMemberCommands();
            }
        }
        else{
            addAllSecretariatCommands();
        }
        return true;
    }
    
    public void logout(){
        currentMember = null;
        removeAllCommands();
    }
    
    public void addCommand(String code, Command command){
        commands.put(code, command);
    }
    
    public void addAllVotingMemberCommands(){
        addCommand("VALL", new VisualizeVotingsCommand(database, this));
        addCommand("VONE", new VisualizeVotingCommand(database, this));
        addCommand("VOTE", new VoteCommand(database, this));
    }
    
    public void addAllChiefCommands(){
        addCommand("CR", new CreateVotingCommand(database, this));
        addCommand("A", new AuthorizeVotingsCommand(database, this));
        addCommand("VALL", new VisualizeVotingsCommand(database, this));
        addCommand("VONE", new VisualizeVotingCommand(database, this));
        addCommand("VOTE", new VoteCommand(database, this));
        addCommand("D", new DeleteVotingCommand(database, this));
        addCommand("O", new OpenVotingCommand(database, this));
        addCommand("CL", new CloseVotingCommand(database, this));
        addCommand("G", new GenerateVotingRecordCommand(database, this));
    }
    
    public void addAllSecretariatCommands(){
        addCommand("CR", new CreateVotingCommand(database, this));
        addCommand("VALL", new VisualizeVotingsCommand(database, this));
        addCommand("VONE", new VisualizeVotingCommand(database, this));
        addCommand("D", new DeleteVotingCommand(database, this));
        addCommand("O", new OpenVotingCommand(database, this));
        addCommand("CL", new CloseVotingCommand(database, this));
        addCommand("G", new GenerateVotingRecordCommand(database, this));
    }
    
    public void removeAllCommands(){
        commands.clear();
    }
    
    public Member getCurrentMember(){
        return currentMember;
    }
    
    public void showVotings(List<Voting> votings){
        if (votings.isEmpty()){
            System.out.println("There are no votings available for that operation\n");
        }
        else{
            int votingCounter = 0;
            for (Voting voting : votings){
                System.out.println(++votingCounter+" - "+voting);
            }
        }
    }
    
    public Voting chooseVoting(List<Voting> votings){
        if (!votings.isEmpty()){
            int choice = UIUtils.INSTANCE.readInteger("Choose a Voting",0,votings.size());
            return votings.get(choice-1);
        }
        return null;
    }

    public void showWarning(String message) {
        System.out.println(message);
    }
    
    public boolean confirmDelete(){
        String option;
        option = UIUtils.INSTANCE.readString("Are you sure you would like to delete the voting?(y/n)");
        return !option.equals("n");
    }

    public void showVoting(Voting voting) {
        List<Vote> votes = voting.getVotes();
        System.out.println(voting);
        if (votes != null){
            int voteCounter = 0;
            System.out.println("List of votes: ");
            for (Vote vote : votes){
                System.out.println(++voteCounter+" - "+vote);
            }
        }
        else{
            System.out.println("There are no computed votes in this voting");
        }
    }
    
    public boolean isLoggedIn(){
        return (currentMember != null);
    }

    public void createAndShowUI() {
        String commandKey = null;
        do {
            System.out.println();
            System.out.println(getMenu());
            commandKey = UIUtils.INSTANCE.readString("Option");
            Command command = commands.get(commandKey);
            if (command != null){
                command.execute();
            }
        } while (!EXIT_CODE.equals(commandKey));
        if (isLoggedIn())
            logout();
    }

    private String getMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Options: (E to Exit)");
        for (String key : commands.keySet()){
            Command command = commands.get(key);
            sb.append("\n").append(key).append(" - ").append(command);
        }
        return sb.toString();
    }
    
}
