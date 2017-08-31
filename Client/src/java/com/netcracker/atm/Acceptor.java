/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.atm;


import com.netcracker.atm.dao.impl.BillsMySqlDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Acceptor extends BillsMySqlDao{
 private static final int Thousand = 1000;
 private static final int Hundred = 100;
 
    public boolean isSetMoney(int value){
        if(value%Hundred==0){
            try {
                update(value, getByValue(value).getCount()+1);
            } catch (SQLException ex) {
                Logger.getLogger(Acceptor.class.getName()).log(Level.SEVERE, null, ex);
            }
        return true;
        }else{
            System.out.println("Число должно быть кратным 100.");
            return false;
        }
    }
    public boolean isGetMoney(int cash){
        int countThousand = (int)Math.floor(cash/Thousand);
        int c = cash-countThousand*Thousand;
        int countHundred = (int)(c/Hundred);
        int subtractionTthousand=0;
        int subtractionHundred=0;
        try {
            subtractionTthousand = getByValue(Thousand).getCount() - countThousand;
            subtractionHundred = getByValue(Hundred).getCount() - countHundred;
        } catch (SQLException ex) {
            Logger.getLogger(Acceptor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

    if(cash%100==0 && (countThousand+countHundred)<=40){
        if((subtractionTthousand)>=0 && 
                ((subtractionHundred)>=0))
        {
            try {
                update(Thousand, subtractionTthousand);
                update(Hundred, subtractionHundred);
            } catch (SQLException ex) {
                Logger.getLogger(Acceptor.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return true;
        }else{
            System.out.println("В банкомате не достаточно купюр.");
            return false;
        }
    }else{
        if(cash%Hundred==0){
        System.out.println("Число должно быть кратным 100.");
        }else{
        System.out.println("Число купюр привысело границу.");
        }
        return false;
    }
}
}
