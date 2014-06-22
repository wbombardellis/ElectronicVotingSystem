/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package architecture;

import java.util.Date;

/**
 *
 * @author regesober
 */
public class FunctionalPromotion extends Voting {
    
    private final String descriptiveMemorandum;
    private final String scoreSheet;
    private final String vouchers;

    public FunctionalPromotion(int id, String author, Date startDate, Date endDate, String descriptiveMemorandum, String scoreSheet, String vouchers) {
        super(id, author, startDate, endDate);
        this.descriptiveMemorandum = descriptiveMemorandum;
        this.scoreSheet = scoreSheet;
        this.vouchers = vouchers;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Voting id: ").append(this.getId()).append("\n");
        sb.append("Type: Functional Promotion\n");
        sb.append("Descriptive Memorandum: ").append(descriptiveMemorandum).append("\n");
        sb.append("Score Sheet: ").append(scoreSheet).append("\n");
        sb.append("Vouchers: ").append(vouchers);
        return sb.toString();
    }

    @Override
    public boolean missingDocuments() {
        boolean missingDocuments = (descriptiveMemorandum == null) || (scoreSheet == null) || (vouchers == null);
        return missingDocuments;
    }
    
}
