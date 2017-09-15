package com.netcracker.atm.dao.impl;

import com.netcracker.atm.dao.AccountDao;
import com.netcracker.atm.model.Account;
import com.netcracker.atm.types.Attributes;
import com.netcracker.atm.types.Types;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class AccountMySqlDao extends ObjectMySqlDao implements AccountDao{
Connection connection = null;
    public AccountMySqlDao(){}
    private static AccountMySqlDao instance;
    public static AccountMySqlDao getInstance() {
        if (instance == null) {
            instance = new AccountMySqlDao();
        }
        return instance;
    }
    
    @Override
    public Account getAccount(String cardNumber) throws SQLException{
            Account account = new Account();         
            ResultSet resultSet = null;
            resultSet = getResultSet(Types.account.name(), cardNumber, resultSet);
            resultSet.next();
            account.setAccountNumber(resultSet.getString(1));
            resultSet.next();
            account.setCardNumber(resultSet.getString(1));
            resultSet.next();
            account.setPin(Integer.parseInt(resultSet.getString(1)));
            resultSet.next();
            account.setBalance(Float.parseFloat(resultSet.getString(1)));
        return account;
    }

    @Override
    public boolean updateBalance(float balance, String cardNumber) throws SQLException{
        Statement statement = null;
        ResultSet resultSet = null;
        String balanceStr;
    String obj_id = "select p.obj_id from object_types as t,params as p, objects as o, attributes as a "+
"where o.obj_id=p.obj_id and a.attr_id=p.attr_id  and t.type_id = o.type_id "+
"and t.type_id = 2 and p.value like '"+cardNumber+"';";
        String query;
         try {
            balanceStr = String.valueOf(balance);
            connection = ConnectionFabrica.getInstance().getConnection();
            statement = connection.createStatement();
            connection.setAutoCommit(false);  
            resultSet= statement.executeQuery(obj_id);
            resultSet.next();
            Integer obj = Integer.parseInt(resultSet.getString(1));  
            query = "update params set value='"+balanceStr+"' where obj_id="+obj+" and attr_id="+Attributes.balance.value+";";
            statement.executeUpdate(query); 
            connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountMySqlDao.class.getName()).log(Level.SEVERE, null, ex);
            connection.rollback();
            return false;
        }finally{
        ConnectionFabrica.getInstance().closeConnection();
        }
    }   

    @Override
    public List<Account> getAllAccounts() throws SQLException {
         List<Account> accounts = null;
        connection = ConnectionFabrica.getInstance().getConnection();
        try{
            accounts = new ArrayList<Account>();
        for(String cardNumber: getValuesById(Attributes.card_number.ordinal())){
            accounts.add(getAccount(cardNumber));
        }
        }finally{
            ConnectionFabrica.getInstance().closeConnection();
        }
        return accounts;
       }

    @Override
    public boolean insertAccount(ArrayList<String> values) throws SQLException {
        try{
        insert(values, Types.account.ordinal());
        }catch(SQLException ex){
            Logger.getLogger(AccountMySqlDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    return true;
    }

    @Override
    public boolean deleteAccount(String cardNumber) throws SQLException {
       try{
        delete(Types.account.ordinal(), cardNumber);
        }catch(SQLException ex){
            Logger.getLogger(AccountMySqlDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    return true;
    }
}
