/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.atm;

//import com.netcracker.atm.dao.impl.CardMySqlDao;
//import com.netcracker.atm.model.Card;
import com.netcracker.atm.model.Card;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Admin
 */
public class Dispenser{
   private com.netcracker.atm.bank.Card card=null;
   public Dispenser(){
      // card=new Card();
   }
   public void cardInstance(int cardNumber){
       if(card==null){
       try {
         //  card=getCardByCardNumber(cardNumber);
           card = getCardByCardNumber(cardNumber);
           
       } catch (Exception ex) {
           Logger.getLogger(Dispenser.class.getName()).log(Level.SEVERE, null, ex);
       }
       }
   } 
   public int getCurdNumber(){
        return card.getCardNumber();
}

    public com.netcracker.atm.bank.Card getCard() {
        return card;
    }

    public void setCard(com.netcracker.atm.bank.Card card) {
        this.card = card;
    }
   
    public XMLGregorianCalendar getExpirationDate(){
        return card.getExpirationDate();
    }
    public void cardClear(){
        if (card!=null)         
        card=null;
    }

    private static com.netcracker.atm.bank.Card getCardByCardNumber(int cardNumber) {
        com.netcracker.atm.bank.Bank_Service service = new com.netcracker.atm.bank.Bank_Service();
        com.netcracker.atm.bank.Bank port = service.getBankPort();
        return port.getCardByCardNumber(cardNumber);
    }

    
}
