/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.atm.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ConnectionFabrica {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/bank";
    private static final String UDER = "root";
    private static final String PASSWORD = "den25052016";
    
    public Connection getConnection(){
    Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, UDER, PASSWORD);
            System.out.println("Connection OK");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Connection ERROR");
            Logger.getLogger(ConnectionFabrica.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return connection;
    }
}
