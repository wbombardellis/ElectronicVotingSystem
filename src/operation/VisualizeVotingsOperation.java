/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operation;

import architecture.ChiefMember;
import architecture.Member;
import architecture.SecretariatMember;
import architecture.Voting;
import data.Database;
import java.util.List;
import ui.text.Interface;

/**
 *
 * @author regesober
 */
public class VisualizeVotingsOperation implements Operation {
    
    private final Database database;
    private final Interface textInterface;
    
    public VisualizeVotingsOperation(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
    
    @Override
    public void execute() {
        List<Voting> votings;
        Member currentMember = textInterface.getCurrentMember();
        boolean isAdministrativeMember = (currentMember instanceof ChiefMember) || (currentMember instanceof SecretariatMember);
        if (isAdministrativeMember)
            votings = database.getUnrecordedUnclosedVotings();
        else
            votings = database.getUnrecordedOpenAuthorizedReleasedVotings();
        textInterface.showVotings(votings);
    }
    
}
