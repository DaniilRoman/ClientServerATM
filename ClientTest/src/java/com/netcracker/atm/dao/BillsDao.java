package com.netcracker.atm.dao;

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
