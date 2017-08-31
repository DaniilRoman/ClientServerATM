/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.atm.dao.impl;

import com.netcracker.atm.dao.BillsDao;
import com.netcracker.atm.model.Bills;
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
public class BillsMySqlDao extends ConnectionFabrica implements BillsDao{
Connection connection = null;
    @Override
    public Bills getByValue(int value)  throws SQLException{
        connection=getConnection();
        Statement statement = null;
        String query = "SELECT value, count FROM bank.bills WHERE value="+value;
        Bills bills = new Bills();
        try {
            //connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            
            resultSet.next();
            
            bills.setValue(resultSet.getInt(1));
            bills.setCount(resultSet.getInt(2));
            
            //preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillsMySqlDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        if(statement!=null){     
            statement.close();
        }
        if(connection!=null){
        connection.close();
        System.out.println("Connection close");
        }
        }
        return bills;
    }

    @Override
    public void update(int value, int count) throws SQLException{
        //if(connection.isClosed() || connection==null){
        connection=getConnection();
        //}
        Statement statement = null;
        String query = "UPDATE bank.bills SET count="+count+" WHERE value="+value;

         try {
            //connection.setAutoCommit(false);
            
            statement = connection.createStatement();           
            int i = statement.executeUpdate(query); 
            //if(i!=1){
            //    SQLException sqlException = new SQLException();
            //} 
            //preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillsMySqlDao.class.getName()).log(Level.SEVERE, null, ex);
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
