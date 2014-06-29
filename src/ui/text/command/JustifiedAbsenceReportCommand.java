package ui.text.command;

import java.util.List;

import architecture.Justification;
import architecture.Voting;
import ui.text.Interface;
import data.Database;

public class JustifiedAbsenceReportCommand implements Command {

	private final Database database;
    private final Interface textInterface;
    
    public JustifiedAbsenceReportCommand(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
    
	@Override
	public void execute() {
		
		List<Voting> votings = database.getAllClosedVotings();
		
		textInterface.showVotings(votings);
        Voting chosenVoting = textInterface.chooseVoting(votings);
		
		if (chosenVoting != null) {
			List<Justification> justifications = chosenVoting.getJustifications();
			
			textInterface.showWarning("There are "+ String.valueOf(justifications.size()) +" justified votes.");
			
			if (justifications.size() > 0) {
				textInterface.showTabular("Author", "Justification");
				for (Justification justification : justifications) {
					textInterface.showTabular(justification.getAuthor().getName(), justification.getJsutification());
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return "Justified Absence Report";
	}

}
