/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operation;

import data.Database;
import ui.Login;
import ui.text.Interface;

/**
 *
 * @author regesober
 */
public class LoginOperation implements Operation {

    private final Database database;
    private final Interface textInterface;
    private final int accessCode;
    private final String password;
    
    public LoginOperation(Database database, Interface textInterface, int accessCode, String password){
        this.database = database;
        this.textInterface = textInterface;
        this.accessCode = accessCode;
        this.password = password;
    }
    
    @Override
    public void execute() {
        Login login = new Login(accessCode,password);
        textInterface.login(login);
    }
    
}
