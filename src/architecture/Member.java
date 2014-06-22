/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package architecture;

import java.util.Date;

/**
 *
 * @author RÉGES
 */
public abstract class Member {
    
    private final String name;
    private final Date startMandate;
    private final Date endMandate;
    
    public Member (String name){
        this.name = name;
        this.startMandate = new Date();
        this.endMandate = new Date(Long.MAX_VALUE);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

}
