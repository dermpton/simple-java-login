/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dermpton.userauth.data;

import java.sql.Connection;
import java.sql.DriverManager;


public class DataSource {
    
    private static Connection con; 
    
    public void establishConnection(){
        synchronized ("") {
            try {
               if ( this.getCon() == null || this.getCon().isClosed()) {
                   String url = "jdbc:mysql://localhost/subscriber_list";
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   this.setCon(DriverManager.getConnection(url, "root", "!dermpt0nPC"));
               } 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
        
    public void closeConnection(){
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Connection getCon() {
       return con;
    }
    
    public void setCon(Connection con) {
        this.con = con;
    }
}
