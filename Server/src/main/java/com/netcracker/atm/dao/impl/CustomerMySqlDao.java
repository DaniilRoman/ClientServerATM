package com.netcracker.atm.dao.impl;

import com.netcracker.atm.dao.CustomerDao;
import com.netcracker.atm.model.Customer;
import com.netcracker.atm.types.Attributes;
import com.netcracker.atm.types.Types;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CustomerMySqlDao extends ObjectMySqlDao implements CustomerDao{
    @Override
    public Customer getByAccountNumber(String accountNumber) throws SQLException{
        Customer customer = new Customer();
            ResultSet resultSet = null;
            resultSet = getResultSet(Types.customer.name(), accountNumber, resultSet);
            resultSet.next();
            customer.setFirstName(resultSet.getString(1));
            resultSet.next();
            customer.setLastName((resultSet.getString(1)));
            resultSet.next();
            customer.setAccountNumber((resultSet.getString(1)));
            ConnectionFabrica.getInstance().closeConnection();
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() throws SQLException {
         List<Customer> customers = null;
        try{
            customers = new ArrayList<Customer>();
        for(String accountNumber: getValuesById(Attributes.first_name.ordinal())){
            customers.add(getByAccountNumber(accountNumber));
        }
        }finally{
            ConnectionFabrica.getInstance().closeConnection();
        }
        return customers;
       } 

    @Override
    public boolean insertCustomer(ArrayList<String> values) throws SQLException {
       try{
        insert(values, Types.customer.ordinal());
        }catch(SQLException ex){
            Logger.getLogger(CustomerMySqlDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    return true;
    }

    @Override
    public boolean deleteCustomer(String accountNumber) throws SQLException {
       try{
        delete(Types.account.ordinal(), accountNumber);
        }catch(SQLException ex){
            Logger.getLogger(CustomerMySqlDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    return true;
    }
}