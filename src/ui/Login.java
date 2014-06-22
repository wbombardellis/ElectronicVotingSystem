/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import java.util.Objects;

/**
 *
 * @author regesober
 */
public class Login {
    
    private final Integer accessCode;
    private final String password;
    
    public Login (int acessCode, String password){
        this.accessCode = acessCode;
        this.password = password;
    }

    /**
     * @return the accessCode
     */
    public int getAccessCode() {
        return accessCode;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object otherLogin) {
        if (otherLogin instanceof Login)
            return accessCode.equals(((Login)otherLogin).getAccessCode()) && password.equals(((Login)otherLogin).getPassword());
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.accessCode;
        hash = 97 * hash + Objects.hashCode(this.password);
        return hash;
    }
    
    
    
}
