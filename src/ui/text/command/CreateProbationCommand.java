/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.text.command;

import data.Database;
import java.util.Date;
import operation.CreateProbationOperation;
import ui.text.Interface;
import ui.text.UIUtils;

/**
 *
 * @author RÉGES
 */
public class CreateProbationCommand implements Command {
    private final Database database;
    private final Interface textInterface;
    private final Date endDate;
    private final Date startDate;
    
    public CreateProbationCommand(Database database, Interface textInterface, Date startDate, Date endDate){
        this.database = database;
        this.textInterface = textInterface;
        this.endDate = endDate;
        this.startDate = startDate;
    }
    
    @Override
    public void execute() {
        String teacherReport = UIUtils.INSTANCE.readString("Teacher report");
        String tutorReport = UIUtils.INSTANCE.readString("Tutor report");
        CreateProbationOperation createProbationOperation = new CreateProbationOperation(database, textInterface, startDate, endDate, teacherReport, tutorReport);
        createProbationOperation.execute();
    }
}
