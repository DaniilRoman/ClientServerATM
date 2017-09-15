
package com.netcracker.atm.dao;

import com.netcracker.atm.model.Account;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface AccountDao{
    public Account getAccount(String cardNumber) throws SQLException;
    public boolean updateBalance(float balance, String accountNumber) throws SQLException;
    public List<Account> getAllAccounts() throws SQLException;
    public boolean insertAccount(ArrayList<String> values) throws SQLException;
    public boolean deleteAccount(String cardNumber) throws SQLException;
    
}
