
package com.netcracker.atm.types;

import com.netcracker.atm.dao.impl.CardMySqlDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.netcracker.atm.exceptions.ArgumentException;

/**
 *
 * @author Admin
 */
public class Utils {
    public static Date StringToDate(String str) throws ArgumentException{
     Date date = new Date();
     SimpleDateFormat format = new SimpleDateFormat("y-M-d");
        try {  
            date = (format.parse(str));
        } catch (ParseException ex) {
            Logger.getLogger(CardMySqlDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new ArgumentException("Failed to cast string to date.");
        }
        return date;
    }
}
