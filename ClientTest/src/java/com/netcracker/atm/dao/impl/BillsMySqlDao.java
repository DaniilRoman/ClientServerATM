
package com.netcracker.atm.dao.impl;

import com.netcracker.atm.dao.BillsDao;
import com.netcracker.atm.model.Bills;
import java.sql.SQLException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Admin
 */
public class BillsMySqlDao  implements BillsDao{
    private static Session session = null;
    @Override
    public Bills getByValue(int value)  throws SQLException{
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Bills bills = null;
        Criteria criteria = session.createCriteria(Bills.class);
        criteria.add(Restrictions.eq("value", value));
        bills = (Bills) criteria.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return bills;
    }

    @Override
    public void update(int value, int count) throws SQLException{ 
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();      
        Bills bills = new Bills(value, count);
        session.saveOrUpdate(bills);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }
    
}
