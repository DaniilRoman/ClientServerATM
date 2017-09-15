package com.netcracker.atm.dao.impl;

import com.netcracker.atm.dao.CardDao;
import com.netcracker.atm.model.Card;
import com.netcracker.atm.types.Attributes;
import com.netcracker.atm.types.Types;
import com.netcracker.atm.types.Utils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.netcracker.atm.exceptions.ArgumentException;

/**
 *
 * @author Admin
 */
public class CardMySqlDao extends ObjectMySqlDao implements CardDao{
    @Override
    public Card getByCardNumber(String cardNumber)  throws SQLException, NullPointerException, ArgumentException{
      Card card = new Card();
            ResultSet resultSet = null;
            resultSet = getResultSet(Types.card.name(), cardNumber, resultSet);
            resultSet.next();
            card.setCardNumber(resultSet.getString(1));
            resultSet.next();
            card.setExpirationDate(Utils.StringToDate(resultSet.getString(1)));
            ConnectionFabrica.getInstance().closeConnection();
        return card;
    }

    @Override
    public List<Card> getAllCards() throws SQLException, ArgumentException{
         List<Card> cards = null;
        try{
            cards = new ArrayList<Card>();
        for(String cardNumber: getValuesById(Attributes.card_number.ordinal())){
            cards.add(getByCardNumber(cardNumber));
        }
        }finally{
            ConnectionFabrica.getInstance().closeConnection();
        }
        return cards;
       }
    @Override
      public boolean insertCard(ArrayList<String> values) throws SQLException{
    try{
    insert(values, Types.card.ordinal());
    }catch(SQLException ex){
        return false;
    }return true;
    }

    @Override
    public boolean deleteCard(String cardNumber) throws SQLException {
       try{
        delete(Types.account.ordinal(), cardNumber);
        }catch(SQLException ex){
            Logger.getLogger(CardMySqlDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    return true;
    }
}
