/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system;

import data.Database;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import ui.text.Interface;
import ui.text.UIUtils;
import ui.text.command.LoginCommand;

/**
 *
 * @author R�GES
 */
public class ElectronicVotingSystem {
    
    private static final String EXIT_CODE = "E";
    
    public static void main(String[] args) {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Database database = new Database();
        Interface textInterface = new Interface(database);
        showUI(database, textInterface);
    }
    
    private static void showUI(Database database, Interface textInterface){
        System.out.println(getMenu());
        String option = UIUtils.INSTANCE.readString("Choose");
        while (!EXIT_CODE.equals(option)){
            if ("L".equals(option)){
                LoginCommand loginCommand = new LoginCommand(database, textInterface);
                loginCommand.execute();
                if (textInterface.isLoggedIn())
                    textInterface.createAndShowUI();
            }
            System.out.println();
            System.out.println(getMenu());
            option = UIUtils.INSTANCE.readString("Option");
        }
    }
    
    private static String getMenu(){
        String menu = "Options: (E to Exit)\nL - Login";
        return menu;
    }
    
}
