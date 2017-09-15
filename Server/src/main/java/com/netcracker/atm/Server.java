
package com.netcracker.atm;

import com.netcracker.atm.dao.impl.AccountMySqlDao;
import com.netcracker.atm.dao.impl.CardMySqlDao;
import com.netcracker.atm.dao.impl.CompanyMySqlDao;
import com.netcracker.atm.exceptions.ArgumentException;
import com.netcracker.atm.model.Account;
import com.netcracker.atm.model.Card;
import com.netcracker.atm.model.Company;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Server {
    AccountMySqlDao acc = new AccountMySqlDao();
    CardMySqlDao card = new CardMySqlDao();
    CompanyMySqlDao comp = new CompanyMySqlDao();
    public float getCurrentBalance(String cardNumber){
        try {
            return acc.getAccount(cardNumber).getBalance();
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    public boolean checkPin(String cardNumber, int pin){
        try {
            Account account;
            account = acc.getAccount(cardNumber);
            account.setPin(pin);
            if(account.hashCode()==acc.getAccount(cardNumber).getPin()){
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean checkDate(String cardNumber) throws ArgumentException{
    try {
        Date date = new Date();
        if(date.compareTo(card.getByCardNumber(cardNumber).getExpirationDate())>0){
            return false;
        }else{
            return true;
        }
    } catch (SQLException ex) {
        Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
    }
    public boolean withdraw(String cardNumber, float cash){
        try {
            float newBalance = acc.getAccount(cardNumber).getBalance()-cash;
            if(newBalance>=0){
               return acc.updateBalance(newBalance,cardNumber);
            }  
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean deposite(String cardNumber, float cash){
        try {
            float newBalance = acc.getAccount(cardNumber).getBalance()+cash;
            return acc.updateBalance(newBalance,cardNumber);
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Card getCardByCardNumber(String cardNumber) throws ArgumentException {
        try {
        return card.getByCardNumber(cardNumber);
    } catch (NullPointerException ex ) {
        Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        throw new ArgumentException("This card does not exist");
    } catch (SQLException ex ) {
        Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        throw new ArgumentException("Problems with connecting to the database");
    } 
    }
        
        
    public ArrayList<Company> getAllCompany(){
        try {
            return comp.getAllCompany();
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public boolean payForService(String cardNumber, String service, float cash){
        try {
            if(withdraw(cardNumber, cash)){
            deposite(acc.getAccount(comp.getByTitle(service).getAccountNumber()).getCardNumber(), cash);
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
