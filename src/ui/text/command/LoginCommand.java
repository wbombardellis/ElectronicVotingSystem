/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.text.command;

import data.Database;
import operation.LoginOperation;
import ui.text.Interface;
import ui.text.UIUtils;

/**
 *
 * @author regesober
 */
public class LoginCommand implements Command {
    
    private final Database database;
    private final Interface textInterface;
    
    public LoginCommand(Database database, Interface textInterface){
        this.database = database;
        this.textInterface = textInterface;
    }
    
    @Override
    public void execute() {
        int accessCode = UIUtils.INSTANCE.readInteger("Access code");
        String password = UIUtils.INSTANCE.readString("Password");
        LoginOperation loginOperation = new LoginOperation(database, textInterface, accessCode, password);
        loginOperation.execute();
    }
    
}
