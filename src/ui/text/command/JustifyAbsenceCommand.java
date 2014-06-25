package ui.text.command;

import operation.JustifyAbsenceOperation;
import ui.text.Interface;
import data.Database;

public class JustifyAbsenceCommand implements Command 
{
	private final Database database;
	private final Interface textInterface;
	
	public JustifyAbsenceCommand(Database database, Interface textInterface)
	{
		this.database = database;
		this.textInterface = textInterface;
	}
	
	@Override
	public void execute()
	{
		JustifyAbsenceOperation justifyAbsenceOperation = new JustifyAbsenceOperation(database, textInterface);
		justifyAbsenceOperation.execute();
		
	}
	
	public String toString()
	{
		return "Justify absence";
	}
	
}
