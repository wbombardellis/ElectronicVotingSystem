package ui.text.command;

import java.text.SimpleDateFormat;
import java.util.List;

import architecture.Voting;
import ui.text.Interface;
import data.Database;

public class OpenVotingsReportCommand implements Command {

	private final Database database;
    private final Interface textInterface;
    
    public OpenVotingsReportCommand(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
	
	@Override
	public void execute() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Voting> votings = database.getUnrecordedOpenAuthorizedReleasedVotings();
		
		textInterface.showWarning("There are "+ String.valueOf(votings.size()) +" open votings.");
		
		if (votings.size() > 0) {
			textInterface.showTabular("Id", "End Date");
			for (Voting voting : votings) {
				textInterface.showTabular(String.valueOf(voting.getId()), formatter.format(voting.getEndDate()));
			}
		}
	}

	@Override
	public String toString() {
		return "Open Votings Report";
	}

}
