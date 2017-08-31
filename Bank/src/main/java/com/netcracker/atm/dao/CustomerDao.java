/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.atm.dao;

import com.netcracker.atm.model.Customer;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public interface CustomerDao {
    public Customer getByAccountNumber(int accountNumber) throws SQLException;
}
