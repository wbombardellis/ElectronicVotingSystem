/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operation;

import architecture.ChiefMember;
import architecture.LeaveCountry;
import architecture.Member;
import architecture.Voting;
import data.Database;
import java.io.File;
import java.util.Date;
import ui.text.Interface;

/**
 *
 * @author RÉGES
 */
public class CreateLeaveCountryOperation implements Operation {
    private final Database database;
    private final Interface textInterface;
    private final Date startDate;
    private final Date endDate;
    private final String invitationLetter;
    private final String translatedLetter;
    private final String ticket;
    
    public CreateLeaveCountryOperation(Database database, Interface textInterface, Date startDate, Date endDate, String invitationLetter, String translatedLetter, String ticket){
        this.database = database;
        this.textInterface = textInterface;
        this.startDate = startDate;
        this.endDate = endDate;
        this.invitationLetter = invitationLetter;
        this.translatedLetter = translatedLetter;
        this.ticket = ticket;
    }
    
    @Override
    public void execute() {
        int id = Database.votingIdCounter++;
        Member currentMember = textInterface.getCurrentMember();
        String author = currentMember.getName();
        Voting voting = new LeaveCountry(id,author,startDate,endDate,invitationLetter,translatedLetter,ticket);
        if (currentMember instanceof ChiefMember)
            voting.authorize();
        if (documentsOk())
            voting.release();
        database.addVoting(voting);
    }

    private boolean documentsOk() {
        File invitationLetterFile = new File(invitationLetter);
        File translatedLetterFile = new File(translatedLetter);
        boolean invitationLetterOk = (invitationLetterFile.exists() && !invitationLetterFile.isDirectory());
        boolean translatedLetterOk = (translatedLetterFile.exists() && !translatedLetterFile.isDirectory());
        return (invitationLetterOk && translatedLetterOk);
    }
}
