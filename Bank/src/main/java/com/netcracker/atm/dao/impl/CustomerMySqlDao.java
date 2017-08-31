/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.atm.dao.impl;

import com.netcracker.atm.dao.CustomerDao;
import com.netcracker.atm.model.Customer;
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
public class CustomerMySqlDao extends ConnectionFabrica implements CustomerDao{
private Connection connection=null;
    @Override
    public Customer getByAccountNumber(int accountNumber) throws SQLException{
        //if(connection.isClosed() || connection==null){
        connection=getConnection();
        //}
        Statement statement = null;
        String query = "SELECT account_number, last_name, first_name FROM bank.customer WHERE account_number="+accountNumber;
        Customer customer = new Customer();
        try {
            //connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            
            resultSet.next();
            
            customer.setAccountNumber(resultSet.getInt(1));
            customer.setLastName(resultSet.getString(2));
            customer.setFirstName(resultSet.getString(3));
            
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
        return customer;
    }
    
}
