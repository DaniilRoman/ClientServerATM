/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.atm.dao.impl;

import com.netcracker.atm.dao.CardDao;
import com.netcracker.atm.model.Card;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CardMySqlDao extends ConnectionFabrica implements CardDao{
private Connection connection=null;
    @Override
    public Card getByCardNumber(int cardNumber)  throws SQLException{
        //if(connection.isClosed() || connection==null){
        connection = getConnection();
        //}
        Statement statement = null;
        String query = "SELECT card_number, expiration_date FROM bank.card WHERE card_number="+cardNumber;
        Card card = new Card();
        try {
            //connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            
            resultSet.next();
            
            card.setCardNumber(resultSet.getInt(1));
            card.setExpirationDate(resultSet.getDate(2));
           
            
            //preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CardMySqlDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        if(statement!=null){     
            statement.close();
        }
        if(connection!=null){
        connection.close();
        System.out.println("Connection close");
        }
        }
        return card;
    }
    
}
