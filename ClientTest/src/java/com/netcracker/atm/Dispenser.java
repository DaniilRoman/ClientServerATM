package com.netcracker.atm;

import javax.xml.datatype.XMLGregorianCalendar;

public class Dispenser{
   private Card card=null;
   public Dispenser(){
   }
   public boolean cardInstance(String cardNumber) throws ArgumentException_Exception{
       if(card==null){
           card = getCardByCardNumber(cardNumber);
           if(card==null) {return false;} else return true;
       }return false;
   } 
   public String getCurdNumber(){
        return card.getCardNumber();
}

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
    public XMLGregorianCalendar getExpirationDate(){
        return card.getExpirationDate();
    }
    public void cardClear(){
        if (card!=null)         
        card=null;
    }

    private static com.netcracker.atm.Card getCardByCardNumber(String cardNumber) throws ArgumentException_Exception {
        com.netcracker.atm.Bank_Service service = new com.netcracker.atm.Bank_Service();
        com.netcracker.atm.Bank port = service.getBankPort();
        return port.getCardByCardNumber(cardNumber);
    }

  

    
}
