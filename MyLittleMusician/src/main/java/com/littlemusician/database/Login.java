/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.littlemusician.database;

/**
 *
 * @author tni20865
 */
public class Login {
    
    private int id;
    private String username;
    private String password;
    
    public Login() {
        
    }
    
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * @return the username
     */
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
