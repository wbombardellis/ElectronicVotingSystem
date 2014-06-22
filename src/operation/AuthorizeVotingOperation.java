/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operation;

import architecture.Voting;
import data.Database;
import java.util.List;
import ui.text.Interface;

/**
 *
 * @author regesober
 */
public class AuthorizeVotingOperation implements Operation{

    private final Database database;
    private final Interface textInterface;
    
    public AuthorizeVotingOperation(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
    
    @Override
    public void execute() {
        List<Voting> unauthorizedVotings = database.getUnauthorizedVotings();
        Voting chosenVoting;
        textInterface.showVotings(unauthorizedVotings);
        chosenVoting = textInterface.chooseVoting(unauthorizedVotings);
        if (chosenVoting != null)
            chosenVoting.authorize();
    }
    
}
