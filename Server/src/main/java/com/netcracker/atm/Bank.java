package com.netcracker.atm;

import com.netcracker.atm.exceptions.ArgumentException;
import com.netcracker.atm.model.Card;
import com.netcracker.atm.model.Company;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Admin
 */
@WebService(serviceName = "Bank")
public class Bank{
    Server server = new Server();
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Операция веб-службы
     * @param cardCumber
     * @return 
     */
    @WebMethod(operationName = "getCurrentBalance")
    public float getCurrentBalance(@WebParam(name = "cardCumber") String cardCumber) {
        return server.getCurrentBalance(cardCumber);
    }

    /**
     * Операция веб-службы
     * @param cardNumber
     * @param pin
     * @return 
     */
    @WebMethod(operationName = "checkPin")
    public boolean checkPin(@WebParam(name = "cardNumber") String cardNumber, @WebParam(name = "pin") int pin) {
        return server.checkPin(cardNumber, pin);
    }

    /**
     * Операция веб-службы
     * @param cardNumber
     * @return 
     */
    @WebMethod(operationName = "checkDate")
    public boolean checkDate(@WebParam(name = "cardNumber") String cardNumber) throws ArgumentException {
        return server.checkDate(cardNumber);
    }

    /**
     * Операция веб-службы
     * @param cardNumber
     * @param cash
     * @return 
     */
    @WebMethod(operationName = "withdraw")
    public boolean withdraw(@WebParam(name = "cardNumber") String cardNumber, @WebParam(name = "cash") float cash) {
        return server.withdraw(cardNumber, cash);
    }

    /**
     * Операция веб-службы
     * @param cardNumber
     * @param cash
     * @return 
     */
    @WebMethod(operationName = "deposite")
    public boolean deposite(@WebParam(name = "cardNumber") String cardNumber, @WebParam(name = "cash") float cash) {
        return server.deposite(cardNumber, cash);
    }

    /**
     * Операция веб-службы
     * @param cardNumber
     * @return 
     * @throws NullPointerException 
     */
    @WebMethod(operationName = "getCardByCardNumber")
    public Card getCardByCardNumber(@WebParam(name = "cardNumber") String cardNumber) throws ArgumentException {
        
        Card card =  server.getCardByCardNumber(cardNumber);
        return card;
    }


    /**
     * Операция веб-службы
     * @param cardNumber
     * @param service
     * @param cash
     * @return 
     */
    @WebMethod(operationName = "payForService")
    public boolean payForService(@WebParam(name = "cardNumber") String cardNumber, 
            @WebParam(name = "service") String service, @WebParam(name = "cash") float cash) {
        return server.payForService(cardNumber, service, cash);
    }

    /**
     * Операция веб-службы
     * @return 
     */
    @WebMethod(operationName = "getAllCompanies")
    public java.util.ArrayList<Company> getAllCompanies() {
       return server.getAllCompany();  
    }
}
