/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFormattedTextField.AbstractFormatter;
/**
 *
 * @author lenovo
 */
public class DateFormat extends AbstractFormatter {
    
    private String date = "yyyy-MM-dd";
    private SimpleDateFormat dateFormat = new SimpleDateFormat(date);
    
    @Override
    public Object stringToValue(String text)throws ParseException{
        return dateFormat.parseObject(text);
    }
    
    @Override
    public String valueToString(Object nilai) throws ParseException{
    
        if(nilai != null){
            Calendar cdr = (Calendar) nilai;
            return dateFormat.format(cdr.getTime());
        }
        return "";
    }
    
    
}
