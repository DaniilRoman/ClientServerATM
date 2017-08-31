/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.atm.bank;

import com.netcracker.atm.dao.impl.AccountMySqlDao;
import com.netcracker.atm.dao.impl.CardMySqlDao;
import com.netcracker.atm.model.Account;
import com.netcracker.atm.model.Card;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Admin
 */
@WebService(serviceName = "Bank")
public class Bank{
AccountMySqlDao acc = new AccountMySqlDao();
CardMySqlDao card = new CardMySqlDao();
    @WebMethod(operationName = "getCurrentBalance")
    public float getCurrentBalance(@WebParam(name = "cardNumber") int cardNumber) {
        try {
            return acc.getByCardNumber(cardNumber).getBalance();
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @WebMethod(operationName = "checkPin")
    public boolean checkPin(@WebParam(name = "pin") int pin, @WebParam(name = "cardNumber") int cardNumber) {
        try {
            Account account;
            account = acc.getByCardNumber(cardNumber);
            account.setPin(pin);
            //System.out.println(account.hashCode());
            //System.out.println(acc.getByCardNumber(cardNumber).getPin());
            if(account.hashCode()==acc.getByCardNumber(cardNumber).getPin()){
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("checkPin EXCEPTION!!!!!!!!!!!!!!!!!!");
            return false;
        }
    }

    @WebMethod(operationName = "checkDate")
    public boolean checkDate(@WebParam(name = "cardNumber") int cardNumber) {
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

    /**
     * Операция веб-службы
     */
    @WebMethod(operationName = "withdraw")
    public void withdraw(@WebParam(name = "cardNumber") int cardNumber, @WebParam(name = "cash") int cash) {
        try {
            float newBalance = acc.getByCardNumber(cardNumber).getBalance()-cash;
            if(newBalance>=0){
                // getByCardNumber(dispenser.getCurdNumber()).setBalance(oldBalance-cash);
                acc.updateBalance(newBalance,cardNumber);
                System.out.println("Деньги успешно сняты.");
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Операция веб-службы
     */
    @WebMethod(operationName = "deposite")
    public void deposite(@WebParam(name = "cardNumber") int cardNumber, @WebParam(name = "cash") int cash) {
        try {
            float newBalance = acc.getByCardNumber(cardNumber).getBalance()+cash;
            //getByCardNumber(dispenser.getCurdNumber()).setBalance(cash+newBalance);
            acc.updateBalance(newBalance,cardNumber);
            System.out.println("Деньги внесены на ваш счет.");
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Операция веб-службы
     */
    @WebMethod(operationName = "getCardByCardNumber")
    public Card getCardByCardNumber(@WebParam(name = "cardNumber") int cardNumber) {
    try {
        return card.getByCardNumber(cardNumber);
    } catch (SQLException ex) {
        Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        return null;}
    }
}
