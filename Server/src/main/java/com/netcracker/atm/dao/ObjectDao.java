
package com.netcracker.atm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
    public interface ObjectDao {
    ResultSet getResultSet(String type, String attribute, ResultSet resultSet) throws SQLException;
    List<String> getValuesById(int id) throws SQLException;
    boolean insert(ArrayList<String> values, int typeId) throws SQLException;
    boolean delete(int typeId, String value) throws SQLException;
}
