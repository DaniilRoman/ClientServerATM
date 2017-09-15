package com.netcracker.atm.dao.impl;

import com.netcracker.atm.dao.ObjectDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class ObjectMySqlDao implements ObjectDao{
    
        private Connection connection=null;
        private PreparedStatement preparedStatement = null;
        
        
        
    @Override
    public ResultSet getResultSet(String type, String attribute, ResultSet resultSet) throws SQLException {
       
        String query =  "select d.value from object_types as a, objects as b, attributes as c, params as d" +
" where a.type_name=?"+
" and a.type_id=b.type_id and b.obj_id=d.obj_id   and c.attr_id=d.attr_id " +
" and b.obj_id in (select obj_id from params where value like ?) order by c.attr_id;";
  try{
            connection = ConnectionFabrica.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, attribute);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(AccountMySqlDao.class.getName()).log(Level.SEVERE, null, ex);
   }
  return resultSet;
    }
    
    
    @Override
     public List<String> getValuesById(int attr_id) throws SQLException {
        String query = "select distinct value from params as p, attributes as a "
                + "where a.attr_id=p.attr_id and a.attr_id=?;";
        
        List<String> values = null;
        try{
        connection = ConnectionFabrica.getInstance().getConnection();
        preparedStatement =  connection.prepareStatement(query);
        preparedStatement.setInt(1, attr_id);
        values = new ArrayList<String>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
        values.add(resultSet.getString(1));
        }
        }finally{ConnectionFabrica.getInstance().closeConnection();}
        return values;
}
        @Override
        public boolean insert(ArrayList<String> values, int typeId) throws SQLException{
        ResultSet resultSet = null;
        String insertObject = "INSERT INTO objects (type_id) VALUES(?);";
        String obj_id = "SELECT max(obj_id) FROM project.objects;";
        String attributes = "select attr_id from attribute_object where type_id=? order by attr_id;";
        String insertValue = "INSERT INTO params (obj_id, attr_id, value) VALUES(?,?,?);";
        try{
            connection = ConnectionFabrica.getInstance().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = (PreparedStatement) connection.prepareStatement(insertObject);
            preparedStatement.setInt(1, typeId);
            preparedStatement.executeUpdate();
            preparedStatement = (PreparedStatement) connection.prepareStatement(obj_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Integer objId = resultSet.getInt(1);
            
            preparedStatement = (PreparedStatement) connection.prepareStatement(attributes);
            preparedStatement.setInt(1, typeId);
            resultSet = preparedStatement.executeQuery();
            int i=0;
            preparedStatement = (PreparedStatement) connection.prepareStatement(insertValue);
            while(resultSet.next()){
             preparedStatement.setInt(1, objId);
             preparedStatement.setInt(2, resultSet.getInt(1));
             preparedStatement.setString(3, values.get(i));
             preparedStatement.executeUpdate();
             i++;
            }   
            connection.commit();
        }catch(Exception ex){
            Logger.getLogger(CardMySqlDao.class.getName()).log(Level.SEVERE, null, ex);
            connection.rollback();
            return false;
        }
        finally{ConnectionFabrica.getInstance().closeConnection();}
        return true;
     }
  
        @Override
        public boolean delete(int typeId, String value) throws SQLException{
        ResultSet resultSet = null;
        String deleteParams = "delete from params where obj_id=?;";
        String deleteObject = "delete from objects where obj_id=?;";
        String obj_id = "select p.obj_id from object_types as t,params as p, objects as o, attributes as a "+
        "where o.obj_id=p.obj_id and a.attr_id=p.attr_id  and t.type_id = o.type_id "+
        "and t.type_id = ? and p.value like ?;";
          try{
            connection = ConnectionFabrica.getInstance().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = (PreparedStatement) connection.prepareStatement(obj_id);
            preparedStatement.setInt(1, typeId);
            preparedStatement.setString(2, value);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Integer objId = resultSet.getInt(1);
            
            preparedStatement = (PreparedStatement) connection.prepareStatement(deleteParams);
            preparedStatement.setInt(1, objId);
            preparedStatement.executeUpdate();
            preparedStatement = (PreparedStatement) connection.prepareStatement(deleteObject);
            preparedStatement.setInt(1, objId);
            preparedStatement.executeUpdate();
            connection.commit();
        }catch(SQLException ex){
            Logger.getLogger(CardMySqlDao.class.getName()).log(Level.SEVERE, null, ex);
            connection.rollback();
            return false;
        }
        finally{ConnectionFabrica.getInstance().closeConnection();}
         return true;
     }
    
        
        
        protected boolean updateObj(int objId, int parentId) throws SQLException{
         String update = "update objects set parent_id=? where obj_id=?;";   
         try{
            connection = ConnectionFabrica.getInstance().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = (PreparedStatement) connection.prepareStatement(update);
            preparedStatement.setInt(1, parentId);
            preparedStatement.setInt(2, objId);
            preparedStatement.executeUpdate();
            connection.commit();
        }catch(SQLException ex){
            Logger.getLogger(CardMySqlDao.class.getName()).log(Level.SEVERE, null, ex);
            connection.rollback();
            return false;
        }
        finally{ConnectionFabrica.getInstance().closeConnection();}
         return true;
     }
}
