/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.atm.dao.impl;

import com.netcracker.atm.dao.AccountDao;
import com.netcracker.atm.model.Account;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class AccountMySqlDao extends ConnectionFabrica implements AccountDao{

    private Connection connection = null;
    public AccountMySqlDao(){}

    /**
     *
     * @param cardNumber
     * @return 
     * @throws SQLException
     */
    @Override
    public Account getByCardNumber(int cardNumber) throws SQLException{
        connection=getConnection();
        Statement statement = null;
        String query = "SELECT account_number, card_number, pin, account_type, balance FROM bank.account WHERE card_number="+cardNumber;
        Account account = new Account();
        try {
            //connection.setAutoCommit(false);
            
            statement = connection.createStatement();      
            ResultSet resultSet = statement.executeQuery(query);            
            resultSet.next();
            
            account.setAccountNumber(resultSet.getInt(1));
            account.setCardNumber(resultSet.getInt(2));
            account.setPin(resultSet.getInt(3));
            account.setAccountType(resultSet.getString(4));
            account.setBalance(resultSet.getFloat(5));    
            
            //preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountMySqlDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        if(statement!=null){     
            statement.close();
        }
        if(connection!=null){
        connection.close();
            System.out.println("Connection close");
        }
        }
        return account;
    }

    @Override
    public Account getByAccountNumber(int accountNumber) throws SQLException{
        connection=getConnection();
        Statement statement = null;
        String query = "SELECT account_number, card_number, pin, account_type, balance FROM bank.account WHERE account_number="+accountNumber;
        Account account = new Account();
        try {
            //connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            
            resultSet.next();
            
            account.setAccountNumber(resultSet.getInt(1));
            account.setCardNumber(resultSet.getInt(2));
            account.setPin(resultSet.getInt(3));
            account.setAccountType(resultSet.getString(4));
            account.setBalance(resultSet.getFloat(5));    
            
            //preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountMySqlDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        if(statement!=null){     
            statement.close();
        }
        if(connection!=null){
        connection.close();
        System.out.println("Connection close");
        }
        }
        return account;
    }

    @Override
    public void updateBalance(float balance, int cardNumber) throws SQLException{
        //if(connection.isClosed() || connection==null){
        connection=getConnection();
        //}
        Statement statement = null;
        //Account account = getByAccountNumber(accountNumber);
        String query = "UPDATE bank.account SET balance="+balance+" WHERE card_number="+cardNumber;

         try {
            //connection.setAutoCommit(false);
            
            statement = connection.createStatement();           
            int i = statement.executeUpdate(query); 
            //if(i!=1){
            //    SQLException sqlException = new SQLException();
            //} 
            //preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountMySqlDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        if(statement!=null){     
            statement.close();
        }
        if(connection!=null){
        connection.close();
        System.out.println("Connection close");
        }
        }
    }
    
}
