/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.atm.dao;

import com.netcracker.atm.model.Company;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public interface CompanyDao {
    public Company getByName(String name) throws SQLException;
}
