package com.netcracker.atm.dao.impl;

import com.netcracker.atm.dao.CompanyDao;
import com.netcracker.atm.model.Company;
import com.netcracker.atm.types.Attributes;
import com.netcracker.atm.types.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CompanyMySqlDao extends ObjectMySqlDao implements CompanyDao{
Connection connection = null;
private ResultSet resultSet = null;
    @Override
    public Company getByTitle(String title) throws SQLException{
         Statement statement = null;
        String id = null;
         String obj_id = "select distinct o.obj_id from object_types as t, objects as o, attributes as a, params as p" +
" where t.type_id=o.type_id and o.obj_id=p.obj_id   and a.attr_id=p.attr_id" +
" and o.obj_id = (select obj_id from params where value like '"+title+"');";
        Company company = new Company();
            connection = ConnectionFabrica.getInstance().getConnection();
            try{
            statement = connection.createStatement();      
            resultSet = getResultSet(Types.company.name(), title, resultSet);
            resultSet.next();
            company.setAccountNumber(resultSet.getString(1));
            resultSet.next();
            company.setTitle((resultSet.getString(1)));
            resultSet = statement.executeQuery(obj_id);
            resultSet.next();
            id = resultSet.getString(1);
            setService(id, resultSet, statement, company);
            }finally{
            ConnectionFabrica.getInstance().closeConnection();
            }
        return company;
    }

    
    
    @Override
    public ArrayList<Company> getAllCompany() throws SQLException {
        ArrayList<Company> company = null;
        connection = ConnectionFabrica.getInstance().getConnection();
        try{
            company = new ArrayList<Company>();
        for(String title: getValuesById(Attributes.title.ordinal())){
            company.add(getByTitle(title));
        }
        }finally{
            ConnectionFabrica.getInstance().closeConnection();
        }
        return company;
    }
    
@Override
    public boolean insertCompany(ArrayList<String> values, ArrayList<String> services) throws SQLException{
        insert(values, Types.company.ordinal());
        connection = ConnectionFabrica.getInstance().getConnection();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String obj_id = "SELECT max(obj_id) FROM objects;";
        preparedStatement = (PreparedStatement) connection.prepareStatement(obj_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Integer objId = resultSet.getInt(1);
        try{
            connection = ConnectionFabrica.getInstance().getConnection();
            connection.setAutoCommit(false);
            ArrayList<String> serviceArray = new ArrayList<>();
            for(String service: services){
                serviceArray.clear();
                serviceArray.add(service);
                insert(serviceArray, Types.serv_list.ordinal());
                updateObj(objId, objId+1);
                objId++;
            }
        }catch(Exception ex){
            Logger.getLogger(CompanyMySqlDao.class.getName()).log(Level.SEVERE, null, ex);
            connection.rollback();
            return false;
        }
        finally{ConnectionFabrica.getInstance().closeConnection();}
        return true;
    }
    
@Override
    public boolean deleteCompany(String title) throws SQLException{
        Company company = getByTitle(title);
        ArrayList<String> services = (ArrayList)company.getServices();
        delete(Types.company.ordinal(), title);
        for(String serv: services){
            delete(Types.serv_list.ordinal(), serv);
        }
         return true;
    }
    
    
    
    private void setService(String obj_id, ResultSet resultSet, Statement statement, Company company){
    Integer parent_id = Integer.parseInt(obj_id);
        String query = "select parent_id from objects where obj_id = "+parent_id+";";
    try {
        resultSet = statement.executeQuery(query);
        resultSet.next();
        String parent = null;
        parent = resultSet.getString(1);
        if (parent!=null){
            query = "select value from params where obj_id = "+parent+";";
            resultSet = statement.executeQuery(query);
            resultSet.next();
            company.getServices().add(resultSet.getString(1));
            setService(parent, resultSet, statement, company);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(CompanyMySqlDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
