/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operation;

import architecture.ChiefMember;
import architecture.FunctionalPromotion;
import architecture.Member;
import architecture.Voting;
import data.Database;
import java.io.File;
import java.util.Date;
import ui.text.Interface;

/**
 *
 * @author RÉGES
 */
public class CreateFunctionalPromotionOperation implements Operation {
    
    private final Database database;
    private final Interface textInterface;
    private final Date startDate;
    private final Date endDate;
    private final String descriptiveMemorandum;
    private final String scoreSheet;
    private final String vouchers;
    
    public CreateFunctionalPromotionOperation(Database database, Interface textInterface, Date startDate, Date endDate, String descriptiveMemorandum, String scoreSheet, String vouchers){
        this.database = database;
        this.textInterface = textInterface;
        this.startDate = startDate;
        this.endDate = endDate;
        this.descriptiveMemorandum = descriptiveMemorandum;
        this.scoreSheet = scoreSheet;
        this.vouchers = vouchers;
    }
    
    @Override
    public void execute() {
        int id = Database.votingIdCounter++;
        Member currentMember = textInterface.getCurrentMember();
        String author = currentMember.getName();
        Voting voting = new FunctionalPromotion(id,author,startDate,endDate,descriptiveMemorandum,scoreSheet,vouchers);
        if (currentMember instanceof ChiefMember)
            voting.authorize();
        if (documentsOk()){
            voting.release();
        }
        database.addVoting(voting);
    }

    private boolean documentsOk() {
        File descriptiveMemorandumFile = new File(descriptiveMemorandum);
        File scoreSheetFile = new File(scoreSheet);
        File vouchersFile = new File(vouchers);
        boolean descriptiveMemorandumOk = (descriptiveMemorandumFile.exists() && !descriptiveMemorandumFile.isDirectory());
        boolean scoreSheetOk = (scoreSheetFile.exists() && !scoreSheetFile.isDirectory());
        boolean vouchersOk = (vouchersFile.exists() && !vouchersFile.isDirectory());
        return (descriptiveMemorandumOk && scoreSheetOk && vouchersOk);
    }
}
