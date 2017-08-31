/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.atm.dao;

import com.netcracker.atm.model.Account;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public interface AccountDao{
    public Account getByCardNumber(int cardNumber) throws SQLException;
    public Account getByAccountNumber(int accountNumber) throws SQLException;
    public void updateBalance(float balance, int accountNumber) throws SQLException;
}
