package operation;


import java.util.List;

import architecture.Justification;
import architecture.Voting;
import ui.text.Interface;
import ui.text.UIUtils;
import data.Database;

public class JustifyAbsenceOperation implements Operation
{
	private final Database database;
	private final Interface textInterface;
	
	public JustifyAbsenceOperation(Database database, Interface textInterface)
	{
		this.database = database;
		this.textInterface = textInterface;
	}
	
	@Override
	public void execute()
	{
		List<Voting> votings = database.getUnvotedClosedVotings(textInterface.getCurrentMember());
		if (votings.isEmpty())
		{
			textInterface.showWarning("You have no absence in votings!");
		}
		else
		{
			textInterface.showVotings(votings);
			Voting chosenVoting = textInterface.chooseVoting(votings);
			assert chosenVoting != null;
			
			String justification = UIUtils.INSTANCE.readString("Please enter your justification here");
			Justification absenceJustification = new Justification(justification, textInterface.getCurrentMember());
			chosenVoting.addJustification(absenceJustification);
		}
		
	}

}
