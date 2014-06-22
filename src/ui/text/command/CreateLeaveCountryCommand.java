/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.text.command;

import data.Database;
import java.util.Date;
import operation.CreateLeaveCountryOperation;
import ui.text.Interface;
import ui.text.UIUtils;

/**
 *
 * @author RÉGES
 */
public class CreateLeaveCountryCommand implements Command {
    
    private static final int YES = 1;
    
    private final Database database;
    private final Interface textInterface;
    private final Date endDate;
    private final Date startDate;
    
    public CreateLeaveCountryCommand(Database database, Interface textInterface, Date startDate, Date endDate){
        this.database = database;
        this.textInterface = textInterface;
        this.endDate = endDate;
        this.startDate = startDate;
    }
    
    @Override
    public void execute() {
        String ticket = null;
        String invitationLetter = UIUtils.INSTANCE.readString("Initation letter");
        String translatedLetter = UIUtils.INSTANCE.readString("Translated letter");
        addTicket();
        int choice = UIUtils.INSTANCE.readInteger(null,1,2);
        if (choice == YES){
            ticket = UIUtils.INSTANCE.readString("Ticket");
        }
        CreateLeaveCountryOperation createLeaveCountryOperation = new CreateLeaveCountryOperation(database, textInterface, startDate, endDate, invitationLetter, translatedLetter, ticket);
        createLeaveCountryOperation.execute();
    }
    
    private void addTicket(){
        System.out.println("Would you like to add a ticket?");
        System.out.println("1 - Yes");
        System.out.println("2 - No");
    }
}
