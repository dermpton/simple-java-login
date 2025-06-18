/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dermpton.userauth.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AppQuery {
    
    DataSource c = new DataSource();
    Boolean result = false;
    
    public Boolean validateUser(com.dermpton.userauth.model.User user){
        
        try {
            c.establishConnection();
                String query = "select username, password from users where username = ? and password = ?;";
                PreparedStatement stmnt = c.getCon().prepareStatement(query);
                stmnt.setString(1,user.getUsername());
                stmnt.setString(2,user.getPassword());
                
                ResultSet rs = stmnt.executeQuery();
                if(rs.next()){
                    result = true;
                }
                
            rs.close();
            stmnt.close();
            c.closeConnection();   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
}

