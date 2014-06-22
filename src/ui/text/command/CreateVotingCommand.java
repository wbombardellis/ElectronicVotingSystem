/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.text.command;

import data.Database;
import java.util.Date;
import ui.text.Interface;
import ui.text.UIUtils;

/**
 *
 * @author regesober
 */
public class CreateVotingCommand implements Command {
    
    private static final int FUNCTIONAL_PROMOTION = 1;
    private static final int LEAVE_COUNTRY = 2;
    private static final int PROBATION = 3;
    
    private final Database database;
    private final Interface textInterface;
    
    public CreateVotingCommand(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
    
    @Override
    public void execute() {
        showVotingOptions();
        int votingOption = UIUtils.INSTANCE.readInteger("Choose",1,3);
        Date startDate = UIUtils.INSTANCE.readDate("Start date");
        Date endDate = UIUtils.INSTANCE.readDate("End date");
        switch(votingOption){
            case FUNCTIONAL_PROMOTION:
                CreateFunctionalPromotionCommand createFunctionalPromotionCommand = new CreateFunctionalPromotionCommand(database, textInterface, startDate, endDate);
                createFunctionalPromotionCommand.execute();
                break;
            case LEAVE_COUNTRY:
                CreateLeaveCountryCommand createLeaveCountryCommand = new CreateLeaveCountryCommand(database, textInterface, startDate, endDate);
                createLeaveCountryCommand.execute();
                break;
            case PROBATION:
                CreateProbationCommand createProbationCommand = new CreateProbationCommand(database, textInterface, startDate, endDate);
                createProbationCommand.execute();
                break;
        }
    }
    
    private void showVotingOptions(){
        System.out.println("1 - Functional Promotion");
        System.out.println("2 - Leave Country");
        System.out.println("3 - Probation");
    }
    
    @Override
    public String toString(){
        return "Create voting";
    }
    
}
