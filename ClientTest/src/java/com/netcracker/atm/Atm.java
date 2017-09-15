package com.netcracker.atm;

import com.netcracker.atm.exceptions.ArgumentException;
import java.util.ArrayList;

public class Atm implements TellerInterface{                                 //+
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
    
    public float getCurrentBalance(){
       return getCurrentBalance_1(dispenser.getCurdNumber());
    }
    
    public boolean checkPin(int pin){
          return checkPin_1(dispenser.getCurdNumber(), pin);
    }
    
    public boolean checkDate() throws ArgumentException_Exception{
        return checkDate_1(dispenser.getCurdNumber());
    }
    
    public boolean withdraw(int cash) throws ArgumentException{
        if(acceptor.isGetMoney(cash)){
           return withdraw_1(dispenser.getCurdNumber(), cash);
        }else return false;     
    }
    
    public boolean deposite(int cash) throws ArgumentException{
        if(acceptor.isSetMoney(cash)){
        return deposite_1(dispenser.getCurdNumber(), cash);
        }else return false;
    }
    public ArrayList<Company> getAllCompanies(){
    return (ArrayList<Company>) getAllCompanies_1();
    }
    
    public boolean payForService(String cardNumber, String sevice, float cash){
    return payForService_1(cardNumber, sevice, cash);
    }

    
    
    
    
    
    private static float getCurrentBalance_1(java.lang.String cardCumber) {
        com.netcracker.atm.Bank_Service service = new com.netcracker.atm.Bank_Service();
        com.netcracker.atm.Bank port = service.getBankPort();
        return port.getCurrentBalance(cardCumber);
    }

    private static boolean checkPin_1(java.lang.String cardNumber, int pin) {
        com.netcracker.atm.Bank_Service service = new com.netcracker.atm.Bank_Service();
        com.netcracker.atm.Bank port = service.getBankPort();
        return port.checkPin(cardNumber, pin);
    }

    private static boolean checkDate_1(java.lang.String cardNumber) throws ArgumentException_Exception {
        com.netcracker.atm.Bank_Service service = new com.netcracker.atm.Bank_Service();
        com.netcracker.atm.Bank port = service.getBankPort();
        return port.checkDate(cardNumber);
    }

    private static boolean deposite_1(java.lang.String cardNumber, float cash) {
        com.netcracker.atm.Bank_Service service = new com.netcracker.atm.Bank_Service();
        com.netcracker.atm.Bank port = service.getBankPort();
        return port.deposite(cardNumber, cash);
    }

    private static boolean withdraw_1(java.lang.String cardNumber, float cash) {
        com.netcracker.atm.Bank_Service service = new com.netcracker.atm.Bank_Service();
        com.netcracker.atm.Bank port = service.getBankPort();
        return port.withdraw(cardNumber, cash);
    }

   

    private static boolean payForService_1(java.lang.String cardNumber, java.lang.String serv, float cash) {
        com.netcracker.atm.Bank_Service service = new com.netcracker.atm.Bank_Service();
        com.netcracker.atm.Bank port = service.getBankPort();
        return port.payForService(cardNumber, serv, cash);
    }

    private static java.util.List<com.netcracker.atm.Company> getAllCompanies_1() {
        com.netcracker.atm.Bank_Service service = new com.netcracker.atm.Bank_Service();
        com.netcracker.atm.Bank port = service.getBankPort();
        return port.getAllCompanies();
    }

    

    

    
    }
