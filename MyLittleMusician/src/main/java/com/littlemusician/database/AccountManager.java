/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.littlemusician.database;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author tni20865
 */
public class AccountManager {
    private Session session;
    private int count = 0;
    
    public boolean isValidLogin(String username, String password) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        String query = "select log.username,log.password from Login as log where log.username='" + username + "' and log.password='" + password + "'";
        Query DBquery = session.createQuery(query);
       
        for (Iterator it = DBquery.iterate(); it.hasNext();) {    
            it.next();            
            count++;
            
        }
        System.out.println("Total rows: " + count);
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    public void userInsert(String username, String password) {
        try {

            Configuration config = new Configuration().configure();
            SessionFactory factory = config.buildSessionFactory();
            Session session = factory.openSession();
            Transaction trans = session.beginTransaction();

            Login log = new Login();
            log.setUsername(username);
            log.setPassword(password);
            
            session.save(log);
            
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean isValidUsername(String username) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        String query = "select log.username from Login as log where log.username='" + username + "'";
        Query DBQuery = session.createQuery(query);
       
        for (Iterator it = DBQuery.iterate(); it.hasNext();) {    
            it.next();            
            count++;
            
        }
        
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public List getAccountData(int id) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        String query = "select acc.user_ID, acc.email, acc.profile from Account as acc where acc.user_ID ='" + id + "'";
        List musician = session.createQuery(query).list();
        
        
        return musician;
    }
}
