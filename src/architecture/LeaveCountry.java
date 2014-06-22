/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package architecture;

import java.util.Date;

/**
 *
 * @author regesober
 */
public class LeaveCountry extends Voting {
    
    private final String invitationLetter;
    private final String translatedLetter;
    private String ticket;

    public LeaveCountry(int id, String author, Date startDate, Date endDate, String invitationLetter, String translatedLetter, String ticket) {
        super(id, author, startDate, endDate);
        this.invitationLetter = invitationLetter;
        this.translatedLetter = translatedLetter;
        this.ticket = ticket;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Voting id: ").append(this.getId()).append("\n");
        sb.append("Type: Leave Country\n");
        sb.append("Invitation Letter: ").append(invitationLetter).append("\n");
        sb.append("Translated Letter: ").append(translatedLetter);
        if (ticket != null)
            sb.append("\n").append("Ticket: ").append(ticket);
        return sb.toString();
    }

    @Override
    public boolean missingDocuments() {
        boolean missingDocuments = (invitationLetter == null) || (translatedLetter == null);
        return missingDocuments;
    }
    
}
