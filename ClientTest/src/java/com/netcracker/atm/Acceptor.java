package com.netcracker.atm;

import com.netcracker.atm.dao.impl.BillsMySqlDao;
import com.netcracker.atm.exceptions.ArgumentException;
import java.sql.SQLException;

public class Acceptor {
    private BillsMySqlDao billsMySqlDao = new BillsMySqlDao();
    private static final int Thousand = 1000;
    private static final int Hundred = 100;
    private static final int FiveHundred = 500;
    private static final int FiveThousand = 5000;
 
 
 
    public boolean isSetMoney(int value) throws ArgumentException{
        if(value==Hundred || value == FiveHundred || value == Thousand || value == FiveThousand){                //+
            try {
                billsMySqlDao.update(value, billsMySqlDao.getByValue(value).getCount()+1);
            } catch (SQLException ex) {
                throw new ArgumentException("Could not deposit money to the account.");
            }
        return true;
        }else{
            throw new ArgumentException("This bill is not accepted.");
        }
    }
    
    
    
    public boolean isGetMoney(int cash) throws ArgumentException{
        int countThousand = (int)Math.floor(cash/Thousand);
        int countFiveThousand = (int)Math.floor(countThousand/5);
        countThousand = countThousand-countFiveThousand;
        int countHundred = (int)((cash-countThousand*Thousand)/Hundred);
        int countFiveHundred = (int)Math.floor(countHundred/5);
        countHundred = countHundred - countFiveHundred;
        try {        
        if(cash%Hundred==0 && (countFiveThousand+countThousand+countFiveHundred+countHundred)<=40){
        
            countFiveThousand = billsMySqlDao.getByValue(FiveThousand).getCount() - countFiveThousand;
            countThousand = billsMySqlDao.getByValue(Thousand).getCount() - countThousand;
            countFiveHundred = billsMySqlDao.getByValue(FiveHundred).getCount() - countFiveHundred;
            countHundred = billsMySqlDao.getByValue(Hundred).getCount() - countHundred;
       
            if(countFiveThousand>=0 && countThousand>=0 &&
                countFiveHundred>=0 && countHundred >=0){
                billsMySqlDao.update(FiveThousand, countFiveThousand);
                billsMySqlDao.update(Thousand, countThousand);
                billsMySqlDao.update(FiveHundred, countFiveHundred);
                billsMySqlDao.update(Hundred, countHundred);
            
        return true;
        }else{
            throw new ArgumentException("There are not enough bills in the ATM.");
        }
    }else{
        if(cash%Hundred!=0){
        throw new ArgumentException("The amount must be a multiple 100.");
        }else{
        throw new ArgumentException("Exceeded number of bills.");
        }
    }
        } catch (SQLException ex) {
                throw new ArgumentException("It was not possible to withdraw money.");
            }
}
}
