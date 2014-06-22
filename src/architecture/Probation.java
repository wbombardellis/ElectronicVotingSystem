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
public class Probation extends Voting {
    
    private final String teacherReport;
    private final String tutorReport;

    public Probation(int id, String author, Date startDate, Date endDate, String teacherReport, String tutorReport) {
        super(id, author, startDate, endDate);
        this.teacherReport = teacherReport;
        this.tutorReport = tutorReport;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Voting id: ").append(this.getId()).append("\n");
        sb.append("Type: Probation\n");
        sb.append("Teacher Report: ").append(teacherReport).append("\n");
        sb.append("Tutor Report: ").append(tutorReport);
        return sb.toString();
    }
    
    @Override
    public boolean missingDocuments() {
        boolean missingDocuments = (teacherReport == null) || (tutorReport == null);
        return missingDocuments;
    }
    
}



