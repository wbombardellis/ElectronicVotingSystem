package operation;


import java.util.List;

import architecture.Vote;
import architecture.Voting;
import ui.text.Interface;
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
		List<Voting> votings = database.getAllClosedVotings();
		Voting chosenVoting = textInterface.chooseVoting(votings);
		
		assert chosenVoting!=null;
		
		// TODO Verifica que não há voto do usuário, pede justificativa de ausência.
	}

}
