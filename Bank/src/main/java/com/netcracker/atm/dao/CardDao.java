/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.atm.dao;

import com.netcracker.atm.model.Card;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public interface CardDao{
    public Card getByCardNumber(int cardNumber) throws SQLException;
}
