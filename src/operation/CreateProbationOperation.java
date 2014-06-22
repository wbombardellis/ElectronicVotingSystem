/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operation;

import architecture.ChiefMember;
import architecture.Member;
import architecture.Probation;
import architecture.Voting;
import data.Database;
import java.io.File;
import java.util.Date;
import ui.text.Interface;

/**
 *
 * @author RÉGES
 */
public class CreateProbationOperation implements Operation {
    private final Database database;
    private final Interface textInterface;
    private final Date startDate;
    private final Date endDate;
    private final String teacherReport;
    private final String tutorReport;
    
    public CreateProbationOperation(Database database, Interface textInterface, Date startDate, Date endDate, String teacherReport, String tutorReport){
        this.database = database;
        this.textInterface = textInterface;
        this.startDate = startDate;
        this.endDate = endDate;
        this.teacherReport = teacherReport;
        this.tutorReport = tutorReport;
    }
    
    @Override
    public void execute() {
        int id = Database.votingIdCounter++;
        Member currentMember = textInterface.getCurrentMember();
        String author = currentMember.getName();
        Voting voting = new Probation(id,author,startDate,endDate,teacherReport,tutorReport);
        if (currentMember instanceof ChiefMember)
            voting.authorize();
        if (documentsOk())
            voting.release();
        database.addVoting(voting);
    }

    private boolean documentsOk() {
        File teacherReportFile = new File(teacherReport);
        File tutorReportFile = new File(tutorReport);
        boolean teacherReportOk = (teacherReportFile.exists() && !teacherReportFile.isDirectory());
        boolean tutorReportOk = (tutorReportFile.exists() && !tutorReportFile.isDirectory());
        return (teacherReportOk && tutorReportOk);
    }
}
