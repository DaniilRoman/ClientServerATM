
package com.netcracker.atm.dao;

import com.netcracker.atm.exceptions.ArgumentException;
import com.netcracker.atm.model.Card;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CardDao{
    public Card getByCardNumber(String cardNumber) throws SQLException, NullPointerException, ArgumentException;
    public List<Card> getAllCards() throws SQLException, ArgumentException;
    public boolean insertCard(ArrayList<String> values) throws SQLException;
    public boolean deleteCard(String cardNumber) throws SQLException;
}
