/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.littlemusician.database;

import org.hibernate.Session;

/**
 *
 * @author tni20865
 */
public class Helper {
    
    Session session = null;
    
    
    public Helper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    
    public boolean checkUser() {
        
        
        return false;
    }
    
    
    
}
