/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.text.command;

import data.Database;
import java.util.Date;
import operation.CreateFunctionalPromotionOperation;
import ui.text.Interface;
import ui.text.UIUtils;

/**
 *
 * @author RÉGES
 */
public class CreateFunctionalPromotionCommand implements Command {
    private final Database database;
    private final Interface textInterface;
    private final Date endDate;
    private final Date startDate;
    
    public CreateFunctionalPromotionCommand(Database database, Interface textInterface, Date startDate, Date endDate){
        this.database = database;
        this.textInterface = textInterface;
        this.endDate = endDate;
        this.startDate = startDate;
    }
    
    @Override
    public void execute() {
        String descriptiveMemorandum = UIUtils.INSTANCE.readString("Descriptive memorandum");
        String scoreSheet = UIUtils.INSTANCE.readString("Score sheet");
        String vouchers = UIUtils.INSTANCE.readString("Vouchers");
        CreateFunctionalPromotionOperation createFunctionalPromotionOperation = new CreateFunctionalPromotionOperation(database,textInterface,startDate,endDate,descriptiveMemorandum,scoreSheet,vouchers);
        createFunctionalPromotionOperation.execute();
    }
    
}
