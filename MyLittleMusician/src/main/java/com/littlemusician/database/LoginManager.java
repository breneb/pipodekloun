/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.littlemusician.database;

import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author tni20865
 */
public class LoginManager {
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
}
