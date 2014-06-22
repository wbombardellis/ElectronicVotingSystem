/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operation;

import data.Database;
import ui.text.Interface;

/**
 *
 * @author regesober
 */
public class LogoutOperation implements Operation {

    private final Database database;
    private final Interface textInterface;
    
    public LogoutOperation(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
    
    @Override
    public void execute() {
        textInterface.logout();
    }
    
}
