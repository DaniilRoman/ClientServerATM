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
    private static Connection conn;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/project";
    private static final String UDER = "root";
    private static final String PASSWORD = "root";
    private ConnectionFabrica() {
    }
    private static ConnectionFabrica instance;
    public static ConnectionFabrica getInstance() {
        if (instance == null) {
            instance = new ConnectionFabrica();
        }

        return instance;
    }
    
    public Connection getConnection(){
        try {
            if (conn == null || conn.isClosed()) {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, UDER, PASSWORD);
            System.out.println("Connection OK");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Connection ERROR");
            Logger.getLogger(ConnectionFabrica.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return conn;
    }
    
    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            System.out.println("Connection CLOSE");
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFabrica.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
