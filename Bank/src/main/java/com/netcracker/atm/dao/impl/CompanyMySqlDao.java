/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.atm.dao.impl;

import com.netcracker.atm.dao.CompanyDao;
import com.netcracker.atm.model.Company;
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
public class CompanyMySqlDao extends ConnectionFabrica implements CompanyDao{
Connection connection = null;
    @Override
    public Company getByName(String name) throws SQLException{
        //if(connection.isClosed() || connection==null){
        connection = getConnection();
        //}
        Statement statement = null;
        String query = "SELECT account_number, name FROM bank.company WHERE name='"+name+"'";
        Company company = new Company();
        try {
            //connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            
            resultSet.next();
            
            company.setAccountNumber(resultSet.getInt(1));
            company.setName(resultSet.getString(2));
               
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
        return company;
    }
    
}
