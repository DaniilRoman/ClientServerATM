/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.atm;

//import com.netcracker.atm.dao.impl.AccountMySqlDao;
//import com.netcracker.atm.model.Account;
//import com.netcracker.atm.model.Card;
import com.netcracker.atm.bank.Card;
import java.sql.SQLException;
import java.util.Date;
/**
 *
 * @author Admin
 */
public class Atm {
    private Dispenser dispenser = null;
    private Acceptor acceptor = null;
    
    public Atm(){
    dispenser = new Dispenser();
    acceptor = new Acceptor();
    }

    public Dispenser getDispenser() {
        return dispenser;
    }

    public Acceptor getAcceptor() {
        return acceptor;
    }
    
    public float getCurrentBalance() throws SQLException{
        //return getByCardNumber(dispenser.getCurdNumber()).getBalance(); 
       return getCurrentBalance_1(dispenser.getCurdNumber());
    }
    
    public boolean cheakPin(int pin) throws SQLException{
//        Account account;
//        account = getByCardNumber(dispenser.getCurdNumber());
//        account.setPin(pin);
//        System.out.println(account.hashCode());
//        System.out.println(getByCardNumber(dispenser.getCurdNumber()).getPin());
//        if(account.hashCode()==getByCardNumber(dispenser.getCurdNumber()).getPin()){
//        return true;
//        }
//        return false;
          return checkPin1(pin, dispenser.getCurdNumber());
    }
    
    public boolean cheakDate(){
//        Date date = new Date();
//       if(date.compareTo(dispenser.getCard().getExpirationDate())>0){
//        return false;
//       }else{
//       return true;
////return date.equals(dispenser.getCard().getExpirationDate());
//       }
//com.netcracker.atm.bank.Card c = new com.netcracker.atm.bank.Card();
 //       com.netcracker.atm.model.Card card = dispenser.getCard();
//c.setCardNumber(card.getCardNumber());
//c.setExpirationDate(card.getExpirationDate());
        return checkDate(dispenser.getCurdNumber());
    }
    
    public void withdraw(int cash) throws SQLException{
        if(acceptor.isGetMoney(cash)){
//            float newBalance = getByCardNumber(dispenser.getCurdNumber()).getBalance()-cash;
//            if(newBalance>=0){
//               // getByCardNumber(dispenser.getCurdNumber()).setBalance(oldBalance-cash);
//                updateBalance(newBalance,dispenser.getCurdNumber());
//                System.out.println("Деньги успешно сняты.");
//            }
            withdraw_1(dispenser.getCurdNumber(), cash);
        }     
    }
    
    public void deposite(int cash) throws SQLException{
        if(acceptor.isSetMoney(cash)){
//            float newBalance = getByCardNumber(dispenser.getCurdNumber()).getBalance()+cash;
//            //getByCardNumber(dispenser.getCurdNumber()).setBalance(cash+newBalance);
//            updateBalance(newBalance,dispenser.getCurdNumber());
//            System.out.println("Деньги внесены на ваш счет.");//использовать Printer.java
        deposite_1(dispenser.getCurdNumber(), cash);
        }
    }

    private static void withdraw_1(int cardNumber, int cash) {
        com.netcracker.atm.bank.Bank_Service service = new com.netcracker.atm.bank.Bank_Service();
        com.netcracker.atm.bank.Bank port = service.getBankPort();
        port.withdraw(cardNumber, cash);
    }

    private static float getCurrentBalance_1(int cardNumber) {
        com.netcracker.atm.bank.Bank_Service service = new com.netcracker.atm.bank.Bank_Service();
        com.netcracker.atm.bank.Bank port = service.getBankPort();
        return port.getCurrentBalance(cardNumber);
    }

    private static boolean checkPin1(int pin, int cardNumber) {
        com.netcracker.atm.bank.Bank_Service service = new com.netcracker.atm.bank.Bank_Service();
        com.netcracker.atm.bank.Bank port = service.getBankPort();
        return port.checkPin(pin, cardNumber);
    }

   

    private static void deposite_1(int cardNumber, int cash) {
        com.netcracker.atm.bank.Bank_Service service = new com.netcracker.atm.bank.Bank_Service();
        com.netcracker.atm.bank.Bank port = service.getBankPort();
        port.deposite(cardNumber, cash);
    }

    private static boolean checkDate(int cardNumber) {
        com.netcracker.atm.bank.Bank_Service service = new com.netcracker.atm.bank.Bank_Service();
        com.netcracker.atm.bank.Bank port = service.getBankPort();
        return port.checkDate(cardNumber);
    }

    
    }
