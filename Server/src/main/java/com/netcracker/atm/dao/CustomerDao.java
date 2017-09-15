
package com.netcracker.atm.dao;

import com.netcracker.atm.model.Customer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CustomerDao {
    public Customer getByAccountNumber(String accountNumber) throws SQLException;
    public List<Customer> getAllCustomers() throws SQLException;
    public boolean insertCustomer(ArrayList<String> values) throws SQLException;
    public boolean deleteCustomer(String accountNumber) throws SQLException;
}
