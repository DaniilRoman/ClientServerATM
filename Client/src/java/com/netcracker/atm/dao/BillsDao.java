package com.netcracker.atm.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.netcracker.atm.model.Bills;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public interface BillsDao {
 public Bills getByValue(int value) throws SQLException;
 public void update(int value, int count) throws SQLException;
}
