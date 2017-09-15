
package com.netcracker.atm.dao;

import com.netcracker.atm.model.Company;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CompanyDao {
    public Company getByTitle(String title) throws SQLException;
    public List<Company> getAllCompany() throws SQLException;
    public boolean insertCompany(ArrayList<String> values, ArrayList<String> services) throws SQLException;
    public boolean deleteCompany(String title) throws SQLException;
}
