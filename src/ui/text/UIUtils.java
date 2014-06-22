/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author RÉGES
 */
public class UIUtils {
    
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final UIUtils INSTANCE = new UIUtils();
    
    private final BufferedReader reader;
    private final SimpleDateFormat sdf;
    
    public UIUtils(){
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.sdf = new SimpleDateFormat(DATE_FORMAT);
    }
    
    public String readString(String message){
        String value = null;
        while (value == null){
            if (message != null)
                System.out.println(message+": ");
            try {
                value = reader.readLine();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return value;
    }
    
    public Integer readInteger(String message){
        Integer value = null;
        while (value == null){
            if (message != null)
                System.out.println(message+": ");
            try {
                value = Integer.parseInt(reader.readLine());
            } catch (IOException | NumberFormatException ex) {
                System.out.println(ex);
            }
        }
        return value;
    }
    
    public Integer readInteger(String message, int min, int max){
        Integer value = null;
        while (value == null){
            if (message != null)
                System.out.println(message+": ");
            try {
                int inputValue = Integer.parseInt(reader.readLine());
                if (inputValue < min || inputValue > max)
                    System.out.println("Input value out of range");
                else
                    value = inputValue;
            } catch (IOException | NumberFormatException ex) {
                System.out.println(ex);
            }
        }
        return value;
    }
    
    public Date readDate(String message){
        Date value = null;
        while (value == null){
            if (message != null)
                System.out.println(message+": ");
            try {
                String str = reader.readLine();
                value = sdf.parse(str);
            } catch (IOException | ParseException ex) {
                System.out.println(ex);
            }
        }
        return value;
    }
    
    public String formatDate(Date value) {
	return sdf.format(value);
    }
    
}
