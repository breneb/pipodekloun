/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.littlemusician.database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

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
        Query DBQuery = session.createQuery(query);

        for (Iterator it = DBQuery.iterate(); it.hasNext();) {
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

    public Login getId(String username) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();

        Criteria criteria = session.createCriteria(Login.class);
        criteria.add(Restrictions.eq("username", username));

        Login login = (Login) criteria.uniqueResult();
        return login;
    }

    public Account getAccountData(int id) {
        Account account;

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();

        Criteria criteria = session.createCriteria(Account.class);
        criteria.add(Restrictions.eq("user_ID", id));

        account = (Account) criteria.uniqueResult();

        return account;
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
<<<<<<< HEAD

    public void insertAccountInformation(int id, String email, String profile) {
        try {

            Configuration config = new Configuration().configure();
            SessionFactory factory = config.buildSessionFactory();
            Session session = factory.openSession();
            Transaction trans = session.beginTransaction();

            Account acc = new Account();
            acc.setUser_ID(id);
            acc.setEmail(email);
            acc.setProfile(profile);

            session.save(acc);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     public List getAccountData(int id) {
     SessionFactory factory = new Configuration().configure().buildSessionFactory();
     session = factory.openSession();
     String query = "select acc.user_ID, acc.email, acc.profile from Account as acc where acc.user_ID ='" + id + "'";
     List musician = session.createQuery(query).list();
=======
    
    public List getAccountData(int id) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        String query = "select acc.user_ID, acc.email, acc.profile from Account as acc where acc.user_ID =" + id ;
        List musician = session.createQuery(query).list();
>>>>>>> 1753d9c1d257a9c939fcae255937af2ad58a26e2
        
        
     return musician;
     }
     */
}
