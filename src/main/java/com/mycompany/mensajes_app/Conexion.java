/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JOSE-
 */
public class Conexion {
    
    public Connection get_connection() {
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:13306/mensajes_app","root","");
            
            if(connection != null) {
                System.out.println("Conexion exitosa");
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
        return connection;
    }
}
